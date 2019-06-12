require recipes-bsp/u-boot/u-boot.inc

DEPENDS += "dtc-native"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=30503fd321432fc713238f582193b78e"

SRCREV = "060093523e799c7a963ae83f784d8cde8555bcf9"
SRC_URI = "git://bitbucket.org/italdes/u-boot.git;protocol=https"

S = "${WORKDIR}/git"