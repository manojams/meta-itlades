SUMMARY = "Copy Italdes common files "
DESCRIPTION = "Copy Italdes common files"
LICENSE = "CLOSED"

SRC_URI = "file://YT2.480.0622CX_CA10_V2.C01B001_M71004A017_201802271655.bin \
          file://YT2.480.0618CX_V3.1B02006.S \
          file://flash.sh \
         "

S = "${WORKDIR}"

do_install () {
	install -d ${D}/home/root/grg/firmware/v1-1
  install -m 0444 ${WORKDIR}/YT2.480.0622CX_CA10_V2.C01B001_M71004A017_201802271655.bin ${D}/home/root/grg/firmware/v1-1/
  install -m 0444 ${WORKDIR}/YT2.480.0618CX_V3.1B02006.S ${D}/home/root/grg/firmware/v1-1/
  install -m 0555 ${WORKDIR}/flash.sh ${D}/home/root/grg/firmware/v1-1/
}

PACKAGES = "${PN}"
FILES_${PN} += "home/root/grg/firmware/v1-1"
