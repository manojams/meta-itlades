SUMMARY = "Italdes Qt app for network"
DESCRIPTION = "Italdes Qt app for configure network"
LICENSE = "CLOSED"

DEPENDS = "qtdeclarative qtgraphicaleffects qtmultimedia"

SRCREV = "1f8d77581d3035f1f7ef142996c067f609dcf374"
SRC_URI = "git://git@192.168.12.15/qt-group/arm/blackarm-configrete-qt.git;protocol=ssh;"


S = "${WORKDIR}/git"

require recipes-qt/qt5/qt5.inc

do_install() {
    install -d ${D}/home/root/
    install -m 0755 ${B}/bna_configrete ${D}/home/root/
}

#FILES_${PN}-dbg += "${datadir}/${P}/.debug"
FILES_${PN} += "home/root/"

RDEPENDS_${PN} = "qtdeclarative-qmlplugins qtgraphicaleffects-qmlplugins"