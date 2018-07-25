SUMMARY = "Copy Italdes common files "
DESCRIPTION = "Copy Italdes common files"
LICENSE = "CLOSED"

SRC_URI = "file://blackarm\
         "


S = "${WORKDIR}"

do_install () {
  install -d ${D}/home/root
  install -m 0111 ${WORKDIR}/blackarm ${D}/home/root/blackarm
}

DEPENDS = "qtserialport qca qtbase"

#INHIBIT_PACKAGE_STRIP = "1"
#INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
#INSANE_SKIP_${PN} += "already-stripped"
FILES_${PN} += "home/root/"
#INSANE_SKIP_${PN} += "installed-vs-shipped "
