SUMMARY = "Italdes Python supervisor"
SECTION = "CAN"
LICENSE = "CLOSED"

inherit update-rc.d

SRC_URI = "file://pysupervisor \
          file://pysupervisorlogr "

INITSCRIPT_PARAMS = "defaults 90"
INITSCRIPT_NAME = "pysupervisor"

do_install() {
    install -d "${D}${sysconfdir}/init.d/"
    install -m 500 "${WORKDIR}/pysupervisor" "${D}${sysconfdir}/init.d/"
    install -d "${D}${sysconfdir}/logrotate.d/"
    install -m 644 "${WORKDIR}/pysupervisorlogr" "${D}${sysconfdir}/logrotate.d/"
}
