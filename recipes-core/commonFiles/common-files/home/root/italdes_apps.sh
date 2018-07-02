#! /bin/sh 

echo "Avvio applicazioni Italdes"
QT_APP=blackarm
java -jar /home/root/dist/bna_daemon.jar & 

#loop per gestire il riavvio in caso i crash dell'applicazione Qt
while [ true ] 
do
  /home/root/$QT_APP -platform linuxfb 
done

 
