#!/bin/bash
umount -fl /dev/mmcblk0p1
if [ $? -ne 0 ]; then
        echo "Warning when running umount /dev/mmcblk0p1"
	#no exit is necessary
        #exit 1
fi

fdisk /dev/mmcblk0 <<'EOF'
d
p
n
p
1

w
EOF

if [ $? -ne 0 ]; then
        echo "Error fdisk new partition"
        exit 1
fi

fdisk /dev/mmcblk0 <<'EOF'
t
83
w
EOF

if [ $? -ne 0 ]; then
        echo "Error fdisk partition type"
        exit 1
fi

mkfs.ext4 /dev/mmcblk0p1 <<'EOF'
y
EOF

if [ $? -ne 0 ]; then
        echo "Error mkfs"
        exit 1
fi

exit $?

