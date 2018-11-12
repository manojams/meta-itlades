SUMMARY = "Qt5 everywhere demo"
DESCRIPTION = "Quick tour of Qt 5.0, primarily focusing on its graphical capabilities."
HOMEPAGE = "https://code.qt.io"
LICENSE = "CLOSED"

DEPENDS = "qtdeclarative qtgraphicaleffects qtmultimedia qtsvg qtserialport qca"

SRCREV = "bb42b613ff9fd47e49872db305819b5587d2abd3"
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
