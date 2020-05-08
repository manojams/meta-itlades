SUMMARY = "Italdes Service for starting the qt amin app"
SECTION = "CAN"
LICENSE = "CLOSED"

SRC_URI = "file://wvdial \
          file://wvdiallogr "

inherit update-rc.d
INITSCRIPT_PARAMS = "defaults 20"
INITSCRIPT_NAME = "wvdial"

do_install() {
    install -d "${D}${sysconfdir}/init.d/"
    install -m 500 "${WORKDIR}/wvdial" "${D}${sysconfdir}/init.d/"
    install -d "${D}${sysconfdir}/logrotate.d/"
    install -m 644 "${WORKDIR}/wvdiallogr" "${D}${sysconfdir}/logrotate.d/"
}
