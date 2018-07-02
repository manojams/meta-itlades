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


INSANE_SKIP_${PN} += "already-stripped"
FILES_${PN} += "home/root/"
INSANE_SKIP_${PN} += "installed-vs-shipped "
