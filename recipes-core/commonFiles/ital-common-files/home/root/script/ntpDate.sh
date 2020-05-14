#! /bin/sh
#echo "Start ntpdate-sync"
LOOP=true

while [ $LOOP == true ]; do
        #echo "Trying ntpdate-sync"
        /usr/bin/ntpdate-sync
        ret=$?
        if [ $ret -eq 0 ]; then
           #echo "ntpdate-sync OK"
           LOOP=false
        else
           #echo "ntpdate-sync failure, sleep"
           sleep 20
        fi
done
