SUMMARY = "Italdes Service for starting the qt amin app"
SECTION = "CAN"
LICENSE = "CLOSED"

SRC_URI = "file://italdes \
          file://italdes.sh"

inherit update-rc.d
INITSCRIPT_PARAMS = "defaults 20"
INITSCRIPT_NAME = "italdes"

do_install() {
    install -d "${D}${sysconfdir}/init.d/"
    install -m 500 "${WORKDIR}/italdes" "${D}${sysconfdir}/init.d/"
    install -m 500 "${WORKDIR}/italdes.sh" "${D}${sysconfdir}/init.d/"
}
