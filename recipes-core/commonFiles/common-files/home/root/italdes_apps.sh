#! /bin/sh

echo "Avvio applicazioni Italdes"
QT_APP=blackarm
/home/root/grg/GrgCommManager &

#loop per gestire il riavvio in caso i crash dell'applicazione Qt
while [ true ]
do
  /home/root/$QT_APP 
done
