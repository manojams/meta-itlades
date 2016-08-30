SUMMARY = "Added jdk8 and example .jar"
DESCRIPTION = "This package provides to add add jdk8 and example .jar"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/copyright;md5=3dd6192d306f582dee7687da3d8748ab"

S = "${WORKDIR}"

SRC_URI = "file://jdk-8u91-linux-arm32-vfp-hflt.tar.gz;unpack=0 \
	   file://simple.jar;unpack=0 \
	   file://copyright"


do_install (){
	install -d ${D}/jdk1.8
	install -d ${D}/example
	cp -rf ${WORKDIR}/jdk-8u91-linux-arm32-vfp-hflt.tar.gz ${D}/jdk1.8
	cp -rf ${WORKDIR}/simple.jar ${D}/example
}

FILES_${PN} += "jdk1.8"
FILES_${PN} += "example"
