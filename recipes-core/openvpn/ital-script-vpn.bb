SUMMARY = "Copy Italdes common files "
DESCRIPTION = "Copy Italdes common files"
LICENSE = "CLOSED"

SRC_URI = "file://configurazione.sh\
         "

S = "${WORKDIR}"

do_install () {
  install -d ${D}/home/root
  install -m 0555 ${WORKDIR}/configurazione.sh  ${D}/home/root/configurazione.sh
}

FILES_${PN} += "etc/"
FILES_${PN} += "home/root/"
