DESCRIPTION = "autossh"
LICENSE = "GPLv2+"
PR = "r0"

#LIC_FILES_CHKSUM = "file://autossh.c;beginline=1;endline=24;md5=755a81ffe573faf6c18d1f1061d097c4"
#LIC_FILES_CHKSUM = "file://autossh.c;beginline=1;endline=24;md5=755a81ffe573faf6c18d1f1061d097c"
LICENSE = "CLOSED"

SRC_URI = "http://www.harding.motd.ca/autossh/${PN}-${PV}.tgz"

inherit autotools-brokensep

S = "${WORKDIR}/${PN}-${PV}"

TARGET_CC_ARCH += "${LDFLAGS}"

do_compile() {
	oe_runmake
}

do_install() {
        install -d ${D}${bindir}
        install -m 0755 ${WORKDIR}/${PN}-${PV}/autossh ${D}${bindir}/autossh
}

FILES_${PN} = "${bindir}/autossh"

SRC_URI[md5sum] = "2b804bc1bf6d2f2afaa526d02df7c0a2"
SRC_URI[sha256sum] = "5fc3cee3361ca1615af862364c480593171d0c54ec156de79fc421e31ae21277"

# recipe originally imported from openarp repository:
# http://code.google.com/p/meta-openarp/source/browse/recipes-connectivity/autossh/autossh_1.4c.bb?r=a4eb8555958f6e12442f2786bcfe38760479d36c
