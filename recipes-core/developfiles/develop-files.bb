SUMMARY = "Copy Italdes common files "
DESCRIPTION = "Copy Italdes common files"
LICENSE = "CLOSED"

SRC_URI = "file://config.xml \
    	   file://interfaces \
         "

S = "${WORKDIR}"

do_install () {
	install -d ${D}/home/root
	install -m 0444 ${WORKDIR}/config.xml ${D}/home/root/

	install -d ${D}/etc/network
	install -m 0444 ${WORKDIR}/interfaces ${D}/etc/network

}

#INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
#PACKAGES = "${PN}"
#INSANE_SKIP_${PN} += "dev-deps"
#INSANE_SKIP_${PN} += "already-stripped"
FILES_${PN} += "home/root"
FILES_${PN} += "etc/network"
#INSANE_SKIP_${PN} += "installed-vs-shipped "
