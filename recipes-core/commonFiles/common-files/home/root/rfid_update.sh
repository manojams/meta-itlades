echo "----------Aggiorno RFID ----------------"
echo "Resetto RFID"

#invio la stringa per il reboot dell'RFID.
#Dopo 5" verrà esposto un mass storage (normalmente /dev/sda, che udev mappa a /dev/rfid_disk)
echo -n -e \\x52\\x45\\x42\\x4f\\x4f\\x54\\x0d > /dev/ttyRFID
sleep 3
echo
echo "Monto il disco e copio il file .bin"
mount /dev/disk/by-uuid/FA12-574F /mnt
#mount /dev/sda /mnt
echo
sleep 1
#copio il file del FW nel disco temporaneo dlla RFID
cp /var/run/Update.bin /mnt
umount /mnt
sleep 10

#echo "Ottengo nuova versione firmware"
#echo -n -e \\x56\\x45\\x52\\x5f\\x41\\x50\\x50\\x0d > /dev/ttyRFID
#sleep 1
#cat /dev/ttyRFID > rfid_fw_ver &
#sleep 2
#kill $!
echo "---- Fine update ----"
echo
