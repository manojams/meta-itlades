SUMMARY = "Italdes Certificates for Knox key "
DESCRIPTION = "knox certificates for digital signature"
LICENSE = "CLOSED"


SRC_URI = "file://italdes.pem\
         file://italdes_pubkey.pem\
         "

S = "${WORKDIR}"

do_install () {
  install -d ${D}/home/root/keys
  install -m 0444 ${WORKDIR}/italdes.pem  ${D}/home/root/keys/italdes.pem
  install -m 0444 ${WORKDIR}/italdes_pubkey.pem  ${D}/home/root/keys/italdes_pubkey.pem
}

FILES_${PN} += "home/root/keys"
