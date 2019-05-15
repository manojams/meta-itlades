SUMMARY = "Copy Italdes common files "
DESCRIPTION = "Copy Italdes common files"
LICENSE = "CLOSED"

SRC_URI = "file://configurazione.sh\
         "

S = "${WORKDIR}"

do_install () {
  install -d ${D}/home/root/script
  install -m 0555 ${WORKDIR}/configurazione.sh  ${D}/home/root/script/configurazione.sh
}

FILES_${PN} += "home/root/script/"
