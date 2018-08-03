SUMMARY = "Copy Italdes common files "
DESCRIPTION = "Copy Italdes common files"
LICENSE = "CLOSED"


SRC_URI = "file://italdes-packages.repo"

S = "${WORKDIR}"

do_install () {
	install -d ${D}/etc/packages.repo/
  install -m 0555 ${WORKDIR}/italdes-packages.repo ${D}/etc/packages.repo/italdes-packages.repo

}

FILES_${PN} += "etc/packages.repo/"
