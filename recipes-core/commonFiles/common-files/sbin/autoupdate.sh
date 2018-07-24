#!/bin/bash
# --- file autoupdate.sh --- 

#controllo se passato il nome del file update
if [[ ! $1 ]]; then
 echo "file update non specificato"
 exit -1
fi 

#elimino i files segnaposto del download precedente
rm /var/run/update_downloaded &> /dev/null
rm /var/run/update_installed  &> /dev/null

#scarico il file zippato via HTTP
cd /
rm $1 &> /dev/null
wget -q https://guardian.italdes.it/binary/$1 && touch /var/run/update_downloaded || exit -1

#Scompatto il file nella cartella.
#Verranno sovrascritti a tappeto i files e le cartelle 
#dell'albero contenuto nello zippato
tar xvzf $1 && touch /var/run/update_installed      
rm $1 &> /dev/null

#forzo il sync del filesystem
sync
