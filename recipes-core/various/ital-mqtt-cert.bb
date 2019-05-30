SUMMARY = "Italdes Dnf certificates and server configuration "
DESCRIPTION = "Dnf certificates and server configuration"
LICENSE = "CLOSED"

SRC_URI = "file://service.italdes.it.intermediate.crt \
          "

S = "${WORKDIR}"

do_install () {
  install -d ${D}/home/root/certificate
  install -m 0444 ${WORKDIR}/service.italdes.it.intermediate.crt ${D}/home/root/certificate/
}


FILES_${PN} += "/home/root/certificate/"
