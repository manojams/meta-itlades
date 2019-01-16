SUMMARY = "Italdes initial config of mariadb"
DESCRIPTION = "Script for config mariadb"
LICENSE = "CLOSED"

SRC_URI = "file://initial-maridb-config.sh \
         "

S = "${WORKDIR}"

do_install () {
  install -d ${D}/home
  install -d ${D}/home/root
  install -m 0555 ${WORKDIR}/initial-maridb-config.sh  ${D}/home/root/
}

PACKAGES = "${PN}"
INSANE_SKIP_${PN} += "already-stripped"
FILES_${PN} += "/home/root"
