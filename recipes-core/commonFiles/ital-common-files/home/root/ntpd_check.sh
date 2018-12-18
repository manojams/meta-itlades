#! /bin/sh 
echo "avvio NTP"
rm /var/run/ntpd_sync 2> /dev/null
ntpd -gq > /var/run/ntpd.log &
sleep 10
killall ntpd
grep "ntpd: time" /var/run/ntpd.log && touch /var/run/ntpd_sync
echo "end --" 
