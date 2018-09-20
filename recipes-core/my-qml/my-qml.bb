SUMMARY = "Copy Italdes common files "
DESCRIPTION = "Copy Italdes common files"
LICENSE = "CLOSED"

SRC_URI = "file://libqgif.so \
         "

S = "${WORKDIR}"

do_install () {
	install -d ${D}/usr/lib/qt5/plugins/imageformats
	install -m 0444 ${WORKDIR}/libqgif.so ${D}/usr/lib/qt5/plugins/imageformats/libqgif.so

}

PACKAGES = "${PN}"
#INSANE_SKIP_${PN} += "already-stripped"
FILES_${PN} += "usr/lib/qt5/plugins/imageformats"
