SUMMARY = "Italdes Qt Main App"
DESCRIPTION = "Italdes Qt main app"
LICENSE = "CLOSED"

DEPENDS = "qtdeclarative qtgraphicaleffects qtmultimedia qtsvg qtserialport qca"

SRCREV = "6e07f377b47cca130cdd8c3f6cce4510f0c30135"
SRC_URI = "git://git@192.168.12.15/qt-group/arm/blackarm-qt-ca10.git;protocol=ssh;branch=ca10qml"


S = "${WORKDIR}/git"

require recipes-qt/qt5/qt5.inc

do_install() {
    install -d ${D}/home/root/
    install -m 0755 ${B}/blackarm ${D}/home/root/
}

#FILES_${PN}-dbg += "${datadir}/${P}/.debug"
FILES_${PN} += "home/root/"

RDEPENDS_${PN} = "qtdeclarative-qmlplugins qtgraphicaleffects-qmlplugins"
