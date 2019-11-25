#!/bin/bash
fdisk /dev/mmcblk0 <<'EOF'
d
n
p
1

t
83
w
EOF

if [ $? -ne 0 ]; then
        echo "Error fdisk"
        exit 1
fi

mkfs.ext4 /dev/mmcblk0 <<'EOF'
y
EOF

if [ $? -ne 0 ]; then
        echo "Error mkfs"
        exit 1
fi

exit $?
