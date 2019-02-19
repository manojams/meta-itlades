SUMMARY = "Italdes Service for starting the qt main app"
SECTION = "CAN"
LICENSE = "CLOSED"

SRC_URI = "file://qtpyapp"

do_install() {
    install -d "${D}${sysconfdir}/init.d/"
    install -m 500 "${WORKDIR}/qtpyapp" "${D}${sysconfdir}/init.d/"
}
