SUMMARY = "Copy Italdes common files "
DESCRIPTION = "Copy Italdes common files"
LICENSE = "CLOSED"

SRC_URI = "file://dnf-packages-dev.repo \
         "

S = "${WORKDIR}"

do_install () {
	install -d ${D}//etc/yum.repos.d/
	install -m 0444 ${WORKDIR}/dnf-packages-dev.repo ${D}/etc/yum.repos.d/dnf-packages-dev.repo

}

PACKAGES = "${PN}"
FILES_${PN} += "etc/yum.repos.d/"
