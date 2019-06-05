SUMMARY = "Copy Italdes common files "
DESCRIPTION = "Copy Italdes common files"
LICENSE = "CLOSED"

SRC_URI = "file://ital-update-grg-1.0.sh \
          file://ital-update-grg-1.0.dnf \
         "

S = "${WORKDIR}"

do_install () {
	install -d ${D}/home/root/updates
  install -m 0555 ${WORKDIR}/ital-update-grg-1.0.sh ${D}/home/root/updates/
  install -m 0555 ${WORKDIR}/ital-update-grg-1.0.dnf ${D}/home/root/updates/
}

FILES_${PN} += "home/root/updates"
