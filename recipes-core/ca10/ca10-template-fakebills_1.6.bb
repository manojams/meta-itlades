SUMMARY = "Copy Italdes common files "
DESCRIPTION = "Copy Italdes common files"
LICENSE = "CLOSED"


SRC_URI = "file://YT2.480.0622CX_V2.C01B101_Mf1137B004_V2.1000B60.bin \
         "

S = "${WORKDIR}"

do_install () {
	install -d ${D}/home/root/grg/firmware
  install -m 0444 ${WORKDIR}/YT2.480.0622CX_V2.C01B101_Mf1137B004_V2.1000B60.bin ${D}/home/root/grg/firmware/YT2.480.0622CX_V2.C01B101_Mf1137B004_V2.1000B60.bin
}

PACKAGES = "${PN}"
FILES_${PN} += "home/root/grg/firmware"
