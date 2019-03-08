SUMMARY = "Italdes Python supervisor"
SECTION = "CAN"
LICENSE = "CLOSED"

inherit update-rc.d

SRC_URI = "file://pysupervisor"

INITSCRIPT_PARAMS = "defaults 90"
INITSCRIPT_NAME = "pysupervisor"

do_install() {
    install -d "${D}${sysconfdir}/init.d/"
    install -m 500 "${WORKDIR}/pysupervisor" "${D}${sysconfdir}/init.d/"
}
