require recipes-bsp/u-boot/u-boot.inc

DEPENDS += "dtc-native"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=30503fd321432fc713238f582193b78e"

SRCREV = "6a0a33026b26a06ded3f5ecd80630b2e7c805db6"
SRC_URI = "git://bitbucket.org/italdes/u-boot.git;protocol=https"

S = "${WORKDIR}/git"
