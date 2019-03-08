SUMMARY = "Italdes Service for starting the qt amin app"
SECTION = "CAN"
LICENSE = "CLOSED"

SRC_URI = "file://wvdial"

inherit update-rc.d
INITSCRIPT_PARAMS = "defaults 99"
INITSCRIPT_NAME = "wvdial"

do_install() {
    install -d "${D}${sysconfdir}/init.d/"
    install -m 500 "${WORKDIR}/wvdial" "${D}${sysconfdir}/init.d/"
}
