SUMMARY = "Italdes Service for starting the qt amin app"
SECTION = "CAN"
LICENSE = "CLOSED"

SRC_URI = "file://qtmainapp \
          file://qtmainapp.sh\
          file://qtmainapplogr "

#inherit update-rc.d
#INITSCRIPT_PARAMS = "defaults 99"
#INITSCRIPT_NAME = "qtmainapp"

do_install() {
    install -d "${D}${sysconfdir}/init.d/"
    install -m 500 "${WORKDIR}/qtmainapp" "${D}${sysconfdir}/init.d/"
    install -m 500 "${WORKDIR}/qtmainapp.sh" "${D}${sysconfdir}/init.d/"
    install -d "${D}${sysconfdir}/logrotate.d/"
    install -m 644 "${WORKDIR}/qtmainapplogr" "${D}${sysconfdir}/logrotate.d/"
}
