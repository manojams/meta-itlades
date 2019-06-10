#! /bin/bash
#Programmazione in fabbrica della NAND del modulo iMX6S

/opt/bin/installer_ba -platform linuxfb &

###########################################
## Avvio applicazioni
###########################################
#stop spashscreen
killall psplash
umount -l /mnt/.psplash

#cartella contenente i files da programmare:
#uImage icorem6dl-italdes.dtb rootfs.tar.bz2
FILES_DIR=/production_files
SERVER=192.168.228.224

rm -rf $FILES_DIR
mkdir $FILES_DIR
cd $FILES_DIR/
wget $SERVER/production_files/SPL-nand_signed
if [ $? -ne 0 ]; then
   echo "error wget SPL-nand_signed"
   exit 1
fi
wget $SERVER/production_files/u-boot-ivt.img-nand_signed
if [ $? -ne 0 ]; then
   echo "error wget u-boot-ivt.img-nand_signed"
   exit 1
fi

wget $SERVER/production_files/uImage-ivt_signed
if [ $? -ne 0 ]; then
   echo "error wget uImage-ivt_signed"
   exit 1
fi

wget $SERVER/production_files/italdes-ca10-prod-minimal-italdesicorem6solo.ubifs
if [ $? -ne 0 ]; then
   echo "error wget italdes-ca10-prod-minimal-italdesicorem6solo.ubifs"
   exit 1
fi


sleep 5
PROCESSO=$(pidof installer_ba)

set -e

echo -n -e \\x00 > /proc/$PROCESSO/fd/0
flash_erase /dev/mtd0 0 0
kobs-ng init -x -v -w SPL-nand_signed --search_exponent=1 -v

echo -n -e \\x01 > /proc/$PROCESSO/fd/0
flash_erase /dev/mtd1 0 0
nandwrite -m -p /dev/mtd1 u-boot-ivt.img-nand_signed

#???????
fw_setenv -c /home/root/flash_nand/fw_env.config -s /home/root/flash_nand/uboot-env.txt

flash_erase /dev/mtd3 0 0
nandwrite -m -p /dev/mtd3 uImage-ivt_signed

flash_erase /dev/mtd4 0 0
nandwrite -m -p /dev/mtd4 imx6dl-icore.dtb

echo -n -e \\x02 > /proc/$PROCESSO/fd/0
ubiformat -y /dev/mtd5

echo -n -e \\x03 > /proc/$PROCESSO/fd/0
ubiattach /dev/ubi_ctrl -m 5

echo -n -e \\x04 > /proc/$PROCESSO/fd/0
#-N volume name, -s volume size in bytes
#Modulo 512 MB
ubimkvol /dev/ubi0 -N rootfs -s490000000

echo -n -e \\x05 > /proc/$PROCESSO/fd/0
mkdir /rootfs 2> /dev/null

echo -n -e \\x06 > /proc/$PROCESSO/fd/0
ubiupdatevol /dev/ubi0_0 italdes-ca10-prod-minimal-italdesicorem6solo.ubifs

echo -n -e \\x07 > /proc/$PROCESSO/fd/0
mkdir /rootfs 2> /dev/null
mount -t ubifs ubi0:rootfs /rootfs

echo -n -e \\x08 > /proc/$PROCESSO/fd/0

sync
echo -n -e \\x09 > /proc/$PROCESSO/fd/0
