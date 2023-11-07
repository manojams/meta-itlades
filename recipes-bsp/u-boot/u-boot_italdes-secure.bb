require recipes-bsp/u-boot/u-boot.inc

DEPENDS += "dtc-native"

SECTION = "bootloaders"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=30503fd321432fc713238f582193b78e"

SRCBRANCH = "master"
SRC_URI = "git://github.com/manojams/uboot-italdes-secure.git;branch=${SRCBRANCH};protocol=https"

SRCREV = "617021cda69a4e4e504d3b4028679f260c557943"

EXTRA_OEMAKE += "u-boot.img"

S = "${WORKDIR}/git"