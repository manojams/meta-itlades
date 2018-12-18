#! /bin/sh

echo
echo "******************"
echo "Script di avvio"
echo "******************"

#trucco per evitare che il dynamic linker cerchi glibc in tutti i path di default
#ottimizza leggeremente l'esecuzione dei comandi (ps, grep, wc, echo ...)
export LD_PRELOAD=/lib/libc.so.6

###########################################
## Montaggio SD Card
###########################################
#note:
# - valido se il boot è fatto da NAND, altrimenti viene montata
#   la partizione del kernel della SD
# - montato prima della pendrive per consentire di spostarvi dei files
if [ -e "/dev/mmcblk0p1" ]; then
  echo "Monto la SD Card"
  mkdir /sdcard
  mount /dev/mmcblk0p1 /sdcard 2> /dev/null
fi

#se non esiste la cartella log sulla SDCard, la creo
if ! [ -d '/sdcard/log' ]; then
        echo "creo cartella log"
        mkdir /sdcard/log
fi
#idem
if ! [ -d '/sdcard/multimedia' ]; then
        echo "creo cartella multimedia"
        mkdir /sdcard/multimedia
fi

###########################################
## Aggiornamento da pendrive
###########################################

if [ -e "/dev/sda1" ]; then
  echo "Monto la pendrive [sda1]"
  mount /dev/sda1 /mnt 2> /dev/null
elif [ -e "/dev/sda" ]; then
  echo "Monto la pendrive [sda]"
  mount /dev/sda /mnt 2> /dev/null
elif [ -e "/dev/sdb1" ]; then
  echo "Monto la pendrive [sdb1]"
  mount /dev/sda /mnt 2> /dev/null
elif [ -e "/dev/sdb" ]; then
  echo "Monto la pendrive [sdb]"
  mount /dev/sda /mnt 2> /dev/null
else
  echo "Pendrive non inserita"
fi

#script esterno (lanciato per primo)
if [ -e "/mnt/operazioni.sh" ]; then
  echo "eseguo operazioni.sh"
  sh /mnt/operazioni.sh
fi

#aggiornamento
if [ -e "/mnt/update.tar.gz" ]; then
  echo -n "copio update.tar.gz... "
  cp /mnt/update.tar.gz /
  echo -n "scompatto... "
  tar xvzf update.tar.gz
  rm update.tar.gz
  echo "fine"
fi

#copio contenuti multimediali se presenti
if [ -e "/mnt/media" ]; then
  cp /mnt/media/* /sdcard/multimedia
fi
sync

umount /mnt 2> /dev/null

#copia dei dati multimediali dal server Italdes
if [ -x /etc/init.d/update_media.sh ]; then
	echo "Update dei dati multimediali da server Italdes..."
	cd /etc/init.d/
	./update_media.sh
	cd -
	echo "fatto."
fi

###########################################
## Controllo flag allarme RTC
###########################################
#Se alarme low voltage RTC appare la stringa:
#"rtc-pcf8563 0-0051: low voltage detected, date/time is not reliable."
#quindi creo il file segnaposto (nota sta in RAM, allo startup non è presente)
dmesg | grep "time is not reliable" && touch /var/run/rtc_invalid_date

###########################################
## DNS e DHCP
###########################################
#se presente il flag segnaposto lancio il client DHCP
#che va subito in background.
#All'ottenimento del lease chiama uno script di default
if [ -e "/home/root/dhcp_enabled" ]; then
  echo "ETH: lancio il client DHCP"
  udhcpc -b &
#altrimenti imposto indirizzo IP statico
#i parametri sono già presenti nel file /etc/network/interfaces
else
  echo "ETH: Configurazione statica"
  ifdown eth0
  ifup eth0
  if [ -e /home/root/nameserver.txt ]; then
     cat /home/root/nameserver.txt > /run/resolv.conf
  else
     echo "file nameserver.txt non trovato, imposto i DNS di default"
     echo "nameserver 8.8.8.8" >  /run/resolv.conf
     echo "nameserver 8.8.4.4" >> /run/resolv.conf
  fi
fi

###########################################
## Firewall IPtables
###########################################
#ripristino le regole del firewall
#nota: questo limita il ping ad es. alla VPN
echo "Imposto il Firewall"
cat /etc/iptables-save | iptables-restore -c

###########################################
## openvpn
###########################################
#nota: il demone provvede automaticamente a gestire
#le interruzioni di connettività. Appena la rete viene
#ripristinata, riavvia automaticamente la VPN.
#Possiamo quindi lanciarlo prima di ifup.
#Solitamente openvpn viene lanciato come servizio
#in uno degli script di avvio
echo "Avvio openvpn in daemon mode"
openvpn --config /etc/openvpn/client.conf &> /dev/null &

###########################################
## Avvio applicazioni
###########################################
#stop spashscreen
killall psplash
umount -l /mnt/.psplash

#alza l'audio al massimo
amixer set Headphone 127 &> /dev/null

#avvia applicazioni
#con loop per riavvio in caso di crash applicazione Qt
/home/root//italdes_apps.sh &
