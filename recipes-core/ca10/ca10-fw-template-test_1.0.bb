SUMMARY = "Copy Italdes common files "
DESCRIPTION = "Copy Italdes common files"
LICENSE = "CLOSED"

SRC_URI = "file://YT2.480.0618CX_V3.1B01012.S \
           file://YT2.480.0622CX_V2.001B1xd_ME1003A001_V2.1000B60.bin \
         "

S = "${WORKDIR}"

do_install () {
	install -d ${D}/home/root/grg/firmware
	install -m 0444 ${WORKDIR}/YT2.480.0618CX_V3.1B01012.S ${D}/home/root/grg/firmware/YT2.480.0618CX_V3.1B01012.S
  install -m 0444 ${WORKDIR}/YT2.480.0622CX_V2.001B1xd_ME1003A001_V2.1000B60.bin ${D}/home/root/grg/firmware/YT2.480.0622CX_V2.001B1xd_ME1003A001_V2.1000B60.bin
}


PACKAGES = "${PN}"
FILES_${PN} += "home/root/grg/firmware"
