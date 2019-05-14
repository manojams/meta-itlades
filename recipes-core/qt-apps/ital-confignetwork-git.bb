SUMMARY = "Italdes Qt app for network"
DESCRIPTION = "Italdes Qt app for configure network"
LICENSE = "CLOSED"

DEPENDS = "qtdeclarative qtgraphicaleffects qtmultimedia"

SRCREV = "1f8d77581d3035f1f7ef142996c067f609dcf374"
SRC_URI = "git://git@192.168.228.215/qt-group/arm/blackarm-configrete-qt.git;protocol=ssh;"


S = "${WORKDIR}/git"

require recipes-qt/qt5/qt5.inc

do_install() {
    install -d ${D}/opt/bin/
    install -m 0755 ${B}/bna_configrete ${D}/opt/bin/
}

#FILES_${PN}-dbg += "${datadir}/${P}/.debug"
FILES_${PN} += "opt/bin/"

RDEPENDS_${PN} = "qtdeclarative-qmlplugins qtgraphicaleffects-qmlplugins"
