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
  #sdcard FAT32, used at first boot when it is not yet formatted
  echo "Monto la SD Card"
  mount /dev/mmcblk0p1 /sdcard
fi

if [ -e "/dev/mmcblk0" ]; then
  #sdcard ext4
  echo "Monto la SD Card"
  mount -o noatime /dev/mmcblk0 /sdcard
fi

#se non esiste la cartella log sulla SDCard, la creo
if ! [ -d '/sdcard/log' ]; then
        echo "creo cartella log"
        mkdir /sdcard/log
        mkdir /sdcard/log/backup
fi
#idem
if ! [ -d '/sdcard/media' ]; then
        echo "creo cartella multimedia"
        mkdir /sdcard/media
fi


###########################################
## Aggiornamento da pendrive
###########################################

if [ -e "/dev/sda1" ]; then
  echo "Monto la pendrive [sda1]"
  mount /dev/sda1 /mnt
elif [ -e "/dev/sda" ]; then
  echo "Monto la pendrive [sda]"
  mount /dev/sda /mnt
elif [ -e "/dev/sdb1" ]; then
  echo "Monto la pendrive [sdb1]"
  mount /dev/sda /mnt
elif [ -e "/dev/sdb" ]; then
  echo "Monto la pendrive [sdb]"
  mount /dev/sda /mnt
else
  echo "Pendrive non inserita"
fi

sync

umount /mnt

###########################################
## Controllo flag allarme RTC
###########################################
#Se alarme low voltage RTC appare la stringa:
#"rtc-pcf8563 0-0051: low voltage detected, date/time is not reliable."
#quindi creo il file segnaposto (nota sta in RAM, allo startup non è presente)
dmesg | grep "time is not reliable" && touch /var/run/rtc_invalid_date



###########################################
## Firewall IPtables
###########################################
#ripristino le regole del firewall
#nota: questo limita il ping ad es. alla VPN
echo "Imposto il Firewall"
cat /etc/iptables-save | iptables-restore -c

#alza l'audio al massimo
amixer set Headphone 127 &> /dev/null
