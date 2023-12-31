SUMMARY = "Italdes Dnf certificates and server configuration "
DESCRIPTION = "Dnf certificates and server configuration"
LICENSE = "CLOSED"

SRC_URI = "file://oe-repo-italdes.repo \
          file://repo.italdes.it.client.crt \
          file://repo.italdes.it.client.intermediate.crt \
          file://repo.italdes.it.client.key \
          "

S = "${WORKDIR}"

do_install () {
  install -d ${D}/home/root/certificate
  install -m 0444 ${WORKDIR}/oe-repo-italdes.repo ${D}/home/root/certificate/
  install -m 0444 ${WORKDIR}/repo.italdes.it.client.crt ${D}/home/root/certificate/
  install -m 0444 ${WORKDIR}/repo.italdes.it.client.intermediate.crt ${D}/home/root/certificate/
  install -m 0444 ${WORKDIR}/repo.italdes.it.client.key ${D}/home/root/certificate/
}


FILES_${PN} += "/home/root/certificate/"
