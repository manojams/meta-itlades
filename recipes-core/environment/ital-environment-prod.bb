SUMMARY = "Italdes environment PROD"
DESCRIPTION = "This is for Production environment"
LICENSE = "CLOSED"

SRC_URI = "file://environment.txt \
         "

S = "${WORKDIR}"

do_install () {
	install -d ${D}/home/root/configuration/
  install -m 0444 ${WORKDIR}/environment.txt ${D}/home/root/configuration/
}

FILES_${PN} += "/home/root/configuration/"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
