#!/bin/sh

SRCFILE=http://192.168.12.11/guardian/public/multimedia/multimedia.tar.gz
DSTFILE=/sdcard/multimedia/




if [ ! -d $DSTFILE ]; then
	echo "Destination directory missing"
	exit -1
fi

echo "Copying data into device...."
cd /sdcard/multimedia
if [ -f ./multimedia.tar.gz ]; then
	rm ./multimedia.tar.gz
fi
wget $SRCFILE
if [ "$?" -ne 0 ]; then
	echo "Fail copying update files."
	exit 1
fi
tar -xvzf ./multimedia.tar.gz 
if [ "$?" -ne 0 ]; then
	echo "Fail extracting the tgz archive."
	exit 1
fi
rm ./multimedia.tar.gz
sync
cd -

echo "Update files copied."

touch /home/root/multimedia_update_ok
rm ./$0
sync
exit 0

