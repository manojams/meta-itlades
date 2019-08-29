#!/bin/bash
#
# Setup della configurazione iniziale
# 1) scrive il numero di matricola in un file
# 2) crea certificati ed assegna l' IP della VPN
# 3) Carica i ceritifcati e configura la VPN
#
# Per eseguire ./configurazione.sh matricola
#

dir1="/home/root"
server="192.168.228.232"

if [ $1"x" = "x" ] ; then
   echo -e "\n\n Per eseguire lanciare: ./configurazione.sh matricola. \n\n"
   exit 1
fi

matricola=$1

# Test che la matricola sia numerica
if [ "$matricola" -eq "$matricola" ] 2>/dev/null; then
   sleep 0
else
   echo -e "\n\n*** Errore numero di matricola $matricola deve essere numerico! ***\n\n"
   exit 1
fi

# Test che la matricola abbia le ultime 5 cifre minori di 65536
NUM=${matricola:3:5}
if [ $NUM -gt 65535 ] ; then
   echo -e "\n\n*** Numero di matricola $matricola non accettabile ***\n\n"
   exit 1
fi


# Crea la configurazione VPN
sshpass -p 'Xv5)pd,g' ssh -o UserKnownHostsFile=/dev/null -o StrictHostKeyChecking=no  sysadmin@$server sudo /home/helpdesk/vpn.sh $matricola
if [ $? -ne 0 ] ; then
   echo -e "\n\n*** Errore nella connessione al server. ***\n\n"
   exit 1
fi
echo "Connesso al server"

# Configura la VPN
cd /etc/openvpn
rm -f italdes-????????.*
sshpass -p 'Xv5)pd,g' scp -o UserKnownHostsFile=/dev/null -o StrictHostKeyChecking=no sysadmin@$server:/etc/openvpn/easy-rsa/2.0/keys/italdes-$matricola.* .
if [ $? -ne 0 ] ; then
   echo -e "\n\n*** Errore nella connessione al server. ***\n\n"
   exit 1
fi
echo "Scaricato certificati"

sed -ri s/italdes-.{8}/italdes-$matricola/ client.conf


# Cambia la password di root
#echo "root:I7ALd3s-$matricola" | chpasswd
#echo "Cambiato la password di root "

#echo -e "\n Password di amministrazione modificata.\n"

# OK. Fine configurazione
echo -e "\n\n Matricola $matricola inserita nel file e"
echo -e " configurazione VPN sistemata."
echo -e "\n Fine configurazione.\n\n"
exit 0
#
