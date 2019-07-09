SUMMARY = "ca10 template euro ecb"
DESCRIPTION = "ca10 template euro ecb"
LICENSE = "CLOSED"

SRC_URI = "file://YT2.480.0622CX_V3.C01B115_M71004A038_V2.1000B71_X7.1004E23.bin \
          file://YT2.480.0618CX_V3.1B02049.S \
          file://flash.sh \
         "

S = "${WORKDIR}"

do_install () {
	install -d ${D}/home/root/grg/firmware/v-ecb
  install -m 0444 ${WORKDIR}/YT2.480.0622CX_V3.C01B115_M71004A038_V2.1000B71_X7.1004E23.bin ${D}/home/root/grg/firmware/v-ecb/
  install -m 0444 ${WORKDIR}/YT2.480.0618CX_V3.1B02049.S ${D}/home/root/grg/firmware/v-ecb/
  install -m 0555 ${WORKDIR}/flash.sh ${D}/home/root/grg/firmware/v-ecb/
}

PACKAGES = "${PN}"
FILES_${PN} += "home/root/grg/firmware/v-ecb"
