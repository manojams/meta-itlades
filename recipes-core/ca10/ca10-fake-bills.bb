SUMMARY = "ca10 template euro test"
DESCRIPTION = "ca10 template euro test"
LICENSE = "CLOSED"


SRC_URI = "file://YT2.480.0622CX_V2.C01B113_Mf1137B006_V2.1000B68.bin \
          file://flash.sh \
         "

S = "${WORKDIR}"

do_install () {
  install -d ${D}/home/root/grg/firmware/v-fake
  install -m 0444 ${WORKDIR}/YT2.480.0622CX_V2.C01B113_Mf1137B006_V2.1000B68.bin ${D}/home/root/grg/firmware/v-fake
  install -m 0555 ${WORKDIR}/flash.sh ${D}/home/root/grg/firmware/v-fake/
}

PACKAGES = "${PN}"
FILES_${PN} += "home/root/grg/firmware/v-fake"
