SUMMARY = "Italdes Dnf certificates and server configuration "
DESCRIPTION = "Dnf certificates and server configuration"
LICENSE = "CLOSED"

SRC_URI = "file://oe-repo-italdes.repo \
          file://repo.italdes.it.client.crt \
          file://repo.italdes.it.client.key \
          "

S = "${WORKDIR}"

do_install () {
  install -d ${D}/home/root/certificate
  install -m 0444 ${WORKDIR}/oe-repo-italdes.repo ${D}/home/root/certificate/oe-repo-italdes.repo
  install -m 0444 ${WORKDIR}/repo.italdes.it.client.crt ${D}/home/root/certificate/repo.italdes.it.client.crt
  install -m 0444 ${WORKDIR}/repo.italdes.it.client.key ${D}/home/root/certificate/repo.italdes.it.client.key
}


FILES_${PN} += "/home/root/certificate/"
