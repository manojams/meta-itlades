SUMMARY = "Italdes Servicestart flashing os images"
SECTION = "CAN"
LICENSE = "CLOSED"

SRC_URI = "file://prognand \
            file://prognand_sboot.sh \
            file://fw_env.config \
            file://uboot-env.txt \
            file://start_installer.sh \
            "

inherit update-rc.d
INITSCRIPT_PARAMS = "defaults 99"
INITSCRIPT_NAME = "prognand"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${sysconfdir}/init.d/
    install -m 500 ${WORKDIR}/prognand ${D}${sysconfdir}/init.d/
    install -d ${D}/home/root/flash_nand
    install -m 500 ${WORKDIR}/prognand_sboot.sh ${D}/home/root/flash_nand/
    install -m 500 ${WORKDIR}/start_installer.sh ${D}/home/root/flash_nand/
    install -m 0444 ${WORKDIR}/fw_env.config ${D}/home/root/flash_nand/
    install -m 0444 ${WORKDIR}/uboot-env.txt ${D}//home/root/flash_nand/
}

FILES_${PN} += "/home/root/flash_nand"
