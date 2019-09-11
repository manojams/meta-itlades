SUMMARY = "Copy Italdes common files "
DESCRIPTION = "Copy Italdes common files"
LICENSE = "CLOSED"

SRC_URI = "file://ital-update-1.1.sh \
          file://ital-update-1.1.dnf \
         "

S = "${WORKDIR}"

do_install () {
	install -d ${D}/home/root/updates
  install -m 0555 ${WORKDIR}/ital-update-1.1.sh ${D}/home/root/updates/
  install -m 0555 ${WORKDIR}/ital-update-1.1.dnf ${D}/home/root/updates/
}

FILES_${PN} += "home/root/updates"
