#! /bin/sh
echo "avvio NTP"
/etc/init.d/ntpd stop
echo "Trying with default addr"
ntpdate guardian.italdes.it
if [ $? -ne 0 ]
then
  echo "Default addr failed, starting backup"
  ntpdate 172.16.0.1
fi
/etc/init.d/ntpd start
echo "end --"
