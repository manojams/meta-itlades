#! /bin/bash
#Programmazione in fabbrica della NAND del modulo iMX6S


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

/home/root/flash_nand/start_installer.sh
sleep 5
PROCESSO=$(pidof installer_ba)

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

echo "Dtb.."
wget $SERVER/production_files/uImage-icorem6dl-italdes.dtb
if [ $? -ne 0 ]; then
   echo "error wget uImage-icorem6dl-italdes.dtb"
   exit 1
fi

fw_printenv -c /home/root/flash_nand/fw_env.config | grep ethaddr > /home/root/flash_nand/ethaddr

echo -n -e \\x00 > /proc/$PROCESSO/fd/0
echo "mtd0"
flash_erase /dev/mtd0 0 0
kobs-ng init -x -v -w SPL-nand_signed --search_exponent=1 -v
if [ $? -ne 0 ]; then
   echo "error mtd0"
   exit 1
fi

echo -n -e \\x01 > /proc/$PROCESSO/fd/0
echo "mtd1"
flash_erase /dev/mtd1 0 0
nandwrite -m -p /dev/mtd1 u-boot-ivt.img-nand_signed
if [ $? -ne 0 ]; then
   echo "error mtd1"
   exit 1
fi

#mtd2
echo "mtd2"
fw_setenv -s /home/root/flash_nand/ethaddr
fw_setenv -s /home/root/flash_nand/uboot-env.txt
if [ $? -ne 0 ]; then
   echo "error fw_setenv"
   exit 1
fi

echo "mtd3"
flash_erase /dev/mtd3 0 0
nandwrite -m -p /dev/mtd3 uImage-ivt_signed
if [ $? -ne 0 ]; then
   echo "error mtd3"
   exit 1
fi

echo "mtd4"
flash_erase /dev/mtd4 0 0
nandwrite -m -p /dev/mtd4 uImage-icorem6dl-italdes.dtb
if [ $? -ne 0 ]; then
   echo "error mtd4"
   exit 1
fi

echo "mtd5 format"
echo -n -e \\x02 > /proc/$PROCESSO/fd/0
ubiformat -y /dev/mtd5
if [ $? -ne 0 ]; then
   echo "error ubiformat"
   exit 1
fi

echo -n -e \\x03 > /proc/$PROCESSO/fd/0
echo "mtd5 attach"
ubiattach /dev/ubi_ctrl -m 5
if [ $? -ne 0 ]; then
   echo "error ubiattach"
   exit 1
fi

echo -n -e \\x04 > /proc/$PROCESSO/fd/0
#-N volume name, -s volume size in bytes
#Modulo 512 MB
echo "mtd5 ubimkvol"
ubimkvol /dev/ubi0 -N rootfs -s490000000
if [ $? -ne 0 ]; then
   echo "error ubimkvol"
   exit 1
fi

echo -n -e \\x05 > /proc/$PROCESSO/fd/0

echo -n -e \\x06 > /proc/$PROCESSO/fd/0
echo "mtd5 ubiupdatevol"
ubiupdatevol /dev/ubi0_0 italdes-ca10-prod-minimal-italdesicorem6solo.ubifs
if [ $? -ne 0 ]; then
   echo "error ubiupdatevol"
   exit 1
fi

echo -n -e \\x07 > /proc/$PROCESSO/fd/0
mkdir /rootfs
echo "mtd5 mount"
mount -t ubifs ubi0:rootfs /rootfs
if [ $? -ne 0 ]; then
   echo "error mount"
   exit 1
fi

echo -n -e \\x08 > /proc/$PROCESSO/fd/0

sync
echo -n -e \\x09 > /proc/$PROCESSO/fd/0
