SUMMARY = "Italdes Certificates for accessing to guardian "
DESCRIPTION = "ssh certificates"
LICENSE = "CLOSED"


SRC_URI = "file://bin \
         file://lib \
         "

#http://www.harding.motd.ca/autossh/

S = "${WORKDIR}"

do_install () {
  install -d ${D}/bin
  install -d ${D}/lib
  cp -r ${WORKDIR}/bin ${D}
  cp -r ${WORKDIR}/lib ${D}
}

FILES_${PN} += "/"
INSANE_SKIP_${PN} += "already-stripped"
