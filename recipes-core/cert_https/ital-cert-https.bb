SUMMARY = "Copy Italdes common files "
DESCRIPTION = "Copy Italdes common files"
LICENSE = "CLOSED"


SRC_URI = "file://ca-certificates.crt \
         "

S = "${WORKDIR}"

do_install () {
  install -d ${D}/etc/ssl/certs/
  install -m 0555 ${WORKDIR}/ca-certificates.crt ${D}/etc/ssl/certs/ca-certificates.crt
}

FILES_${PN} += "etc/ssl/certs/"
