SUMMARY = "Italdes Service for starting the qt amin app"
SECTION = "CAN"
LICENSE = "CLOSED"

inherit update-rc.d

SRC_URI = "file://qtmainapp"

INITSCRIPT_PARAMS = "defaults 99"
INITSCRIPT_NAME = "qtmainapp"

do_install() {
    install -d "${D}${sysconfdir}/init.d/"
    install -m 500 "${WORKDIR}/qtmainapp" "${D}${sysconfdir}/init.d/"
}
