SUMMARY = "Italdes chat script"
DESCRIPTION = "chat script for modem"
LICENSE = "CLOSED"

SRC_URI = "file://wvdial.conf \
         "

S = "${WORKDIR}"

do_install () {
	install -d ${D}/etc
	install -m 0444 ${WORKDIR}/wvdial.conf  ${D}/etc/
}
                
PACKAGES = "${PN}"
FILES_${PN} += "etc"
