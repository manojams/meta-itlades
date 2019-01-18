SUMMARY = "Italdes Qt Main App"
DESCRIPTION = "Italdes Qt main app"
LICENSE = "CLOSED"

DEPENDS = "qtdeclarative qtgraphicaleffects qtmultimedia qtsvg qtserialport qca"

SRCREV = "4c65fd1e7decf1ccba863c5aa2c77af8b40ef9d9"
SRC_URI = "git://git@192.168.12.15/qt-group/arm/blackarm-qt-ca10.git;protocol=ssh;branch=ca10qml"


S = "${WORKDIR}/git"

require recipes-qt/qt5/qt5.inc

do_install() {
    install -d ${D}/opt/bin/
    install -m 0755 ${B}/blackarm ${D}/opt/bin/
}

#FILES_${PN}-dbg += "${datadir}/${P}/.debug"
FILES_${PN} += "opt/bin/"

RDEPENDS_${PN} = "qtdeclarative-qmlplugins qtgraphicaleffects-qmlplugins ital-qt-main-app-service"
