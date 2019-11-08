SUMMARY = "the config for the can socket interface"
SECTION = "CAN"
LICENSE = "CLOSED"

inherit update-rc.d

SRC_URI = "file://grgca10 \
            file://ca10cronlogs.sh"

INITSCRIPT_PARAMS = "defaults 70"
INITSCRIPT_NAME = "grgca10"

do_install() {
    install -d "${D}${sysconfdir}/etc/cron.daily/"
    install -m 500 "${WORKDIR}/ca10cronlogs.sh" "${D}${sysconfdir}/etc/cron.daily/"

    install -d "${D}${sysconfdir}/init.d/"
    install -m 500 "${WORKDIR}/grgca10" "${D}${sysconfdir}/init.d/grgca10"
}
