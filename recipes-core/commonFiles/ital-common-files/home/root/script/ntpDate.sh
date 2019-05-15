#! /bin/sh
echo "avvio NTP"
LOOP=true

while [ $LOOP == true ]; do
        /etc/init.d/ntpd stop
        echo "Trying ntpdate"
        ntpdate guardian.italdes.it
        ret=$?
        /etc/init.d/ntpd start
        if [ $ret -eq 0 ]; then
           echo "Ntp date OK"
           LOOP=false
        else
           echo "Ntp date failure, sleep"
           sleep 2
        fi
done
