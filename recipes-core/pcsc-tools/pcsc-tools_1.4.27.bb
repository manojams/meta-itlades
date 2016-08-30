LICENSE = "CLOSED"

S = "${WORKDIR}"

SRC_URI = " file://pcsc-tools-1.4.27.tar.gz "

#WORKDIR="pcsc-tools-1.4.27"

S = "${WORKDIR}/${PN}-${PV}" 

do_compile() {
    cd ${S}
    make
}

do_install() {
    install -d ${D}${bindir} 
    install -m 0755 ${S}/pcsc_scan ${D}${bindir}/pcsc_scan
    install -m 0755 ${S}/scriptor ${D}${bindir}/scriptor
    install -m 0755 ${S}/ATR_analysis ${D}${bindir}/ATR_analysis
}



