SUMMARY = "Italdes Certificates for accessing to guardian "
DESCRIPTION = "ssh certificates"
LICENSE = "CLOSED"


SRC_URI = "file://authorized_keys \
         file://id_rsa \
         file://id_rsa.pub \
         file://known_hosts \
         "

S = "${WORKDIR}"

do_install () {
  install -d ${D}/home/root/.ssh
  install -m 0444 ${WORKDIR}/authorized_keys  ${D}/home/root/.ssh/authorized_keys
  install -m 0600 ${WORKDIR}/id_rsa  ${D}/home/root/.ssh/id_rsa
  install -m 0444 ${WORKDIR}/id_rsa.pub  ${D}/home/root/.ssh/id_rsa.pub
  install -m 0444 ${WORKDIR}/known_hosts  ${D}/home/root/.ssh/known_hosts
}

FILES_${PN} += "home/root/.ssh"
