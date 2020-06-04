SUMMARY = "Italdes Service for starting the qt main app"
SECTION = "CAN"
LICENSE = "CLOSED"

SRC_URI = "file://qtmainapp \
          file://qtmainapp.sh\
          file://qtmainapplogr \
          file://controllerbaglogr \
          file://messageslogr \
          "

#inherit update-rc.d
#INITSCRIPT_PARAMS = "defaults 99"
#INITSCRIPT_NAME = "qtmainapp"

do_install() {
    install -d "${D}${sysconfdir}/init.d/"
    install -m 500 "${WORKDIR}/qtmainapp" "${D}${sysconfdir}/init.d/"
    install -m 500 "${WORKDIR}/qtmainapp.sh" "${D}${sysconfdir}/init.d/"
    install -d "${D}${sysconfdir}/logrotate.d/"
    install -m 644 "${WORKDIR}/qtmainapplogr" "${D}${sysconfdir}/logrotate.d/"
    install -m 644 "${WORKDIR}/controllerbaglogr" "${D}${sysconfdir}/logrotate.d/"
    install -m 644 "${WORKDIR}/messageslogr" "${D}${sysconfdir}/logrotate.d/"
}
