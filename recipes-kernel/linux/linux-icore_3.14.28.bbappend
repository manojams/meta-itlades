FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://defconfig \
            file://0001-added-device-tree-for-icorem6dl-italdes.patch \
            file://0002-fixed-problem-LOCK_ENn-LOCK_OPEN-gpio.patch \
"
