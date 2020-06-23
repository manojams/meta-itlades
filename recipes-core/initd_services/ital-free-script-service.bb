SUMMARY = "Italdes Service for starting the free-script"
SECTION = "CAN"
LICENSE = "CLOSED"

SRC_URI = "file://free-script \
          file://free-script.sh\
          file://free-scriptlogr \
          "

inherit update-rc.d
INITSCRIPT_PARAMS = "defaults 99"
INITSCRIPT_NAME = "free-script"

do_install() {
    install -d "${D}${sysconfdir}/init.d/"
    install -m 500 "${WORKDIR}/free-script" "${D}${sysconfdir}/init.d/"
    install -m 500 "${WORKDIR}/free-script.sh" "${D}${sysconfdir}/init.d/"
    install -d "${D}${sysconfdir}/logrotate.d/"
    install -m 644 "${WORKDIR}/free-scriptlogr" "${D}${sysconfdir}/logrotate.d/"
}
