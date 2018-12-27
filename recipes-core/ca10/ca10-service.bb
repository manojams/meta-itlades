SUMMARY = "the config for the can socket interface"
SECTION = "CAN"
LICENSE = "CLOSED"

inherit update-rc.d

#RDEPENDS_${PN} = "initscripts"

SRC_URI = "file://grgca10"

INITSCRIPT_PARAMS = "defaults 99"
INITSCRIPT_NAME = "grgca10"

do_install() {
    install -d "${D}${sysconfdir}/init.d/"
    install -m 500 "${WORKDIR}/grgca10" "${D}${sysconfdir}/init.d/grgca10"
}
