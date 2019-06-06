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

rm -rf $FILES_DIR/*
cd $FILES_DIR/
wget $SERVER/production_files/icorem6dl-italdes.dtb
if [ $? -ne 0 ]; then
   echo "error wget icorem6dl-italdes.dtb"
   exit 1
fi
wget $SERVER/production_files/uImage
if [ $? -ne 0 ]; then
   echo "error wget uImage"
   exit 1
fi
wget $SERVER/production_files/rootfs.tar.bz2
if [ $? -ne 0 ]; then
   echo "error wget rootfs.tar.bz2"
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
fw_setenv -c fw_env.config -s uboot-env.txt

flash_erase /dev/mtd3 0 0
nandwrite -m -p /dev/mtd3 uImage-ivt_signed

echo -n -e \\x02 > /proc/$PROCESSO/fd/0
ubiformat -y /dev/mtd4

echo -n -e \\x03 > /proc/$PROCESSO/fd/0
#ubiattach /dev/ubi_ctrl -m 3
ubiattach p /dev/mtd4

echo -n -e \\x04 > /proc/$PROCESSO/fd/0
#-N volume name, -s volume size in bytes
#Modulo 512 MB
ubimkvol /dev/ubi0 -N rootfs -s495000000

echo -n -e \\x05 > /proc/$PROCESSO/fd/0
#mkdir /rootfs 2> /dev/null

echo -n -e \\x06 > /proc/$PROCESSO/fd/0
#mount -t ubifs ubi0:rootfs /rootfs
ubiupdatevol /dev/ubi0_0 /path/to/ubifs.img


echo -n -e \\x07 > /proc/$PROCESSO/fd/0
mkdir /rootfs 2> /dev/null
mount t ubifs ubi0:volume_name /rootfs
#tar xvf $FILES_DIR/rootfs.tar.bz2 -C /rootfs


echo -n -e \\x08 > /proc/$PROCESSO/fd/0
#fw_setenv bootargs console=ttymxc3,115200 vt.global_cursor_default=0 cma=0MB video=mxcfb0:dev=lcd,LCD-DENST
#fw_setenv lcd_panel LCD-DENST
#sync
echo -n -e \\x09 > /proc/$PROCESSO/fd/0
