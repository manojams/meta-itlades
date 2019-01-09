SUMMARY = "Italdes Config File for Model Ca10 v1"
DESCRIPTION = "Config files for qt main app"
LICENSE = "CLOSED"

SRC_URI = "file://config.xml \
          "

S = "${WORKDIR}"

do_install () {
	install -d ${D}/home/root
	install -m 0444 ${WORKDIR}/config.xml ${D}/home/root/
}

FILES_${PN} += "home/root"
