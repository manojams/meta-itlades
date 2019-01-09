SUMMARY = "Italdes Media XML"
DESCRIPTION = "Media xml config file"
LICENSE = "CLOSED"


SRC_URI = "file://media.xml \
         "

S = "${WORKDIR}"

do_install () {
  install -d ${D}/home/root/
  install -m 0555 ${WORKDIR}/media.xml ${D}/home/root/
}

FILES_${PN} += "home/root/"
