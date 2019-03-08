SUMMARY = "Italdes Servicestart flashing os images"
SECTION = "CAN"
LICENSE = "CLOSED"

SRC_URI = "file://prognand \
            file://prognand.sh "

inherit update-rc.d
INITSCRIPT_PARAMS = "defaults 99"
INITSCRIPT_NAME = "prognand"

do_install() {
    install -d "${D}${sysconfdir}/init.d/"
    install -m 500 "${WORKDIR}/prognand" "${D}${sysconfdir}/init.d/"
    install -m 500 "${WORKDIR}/prognand.sh" "${D}${sysconfdir}/init.d/"
}
