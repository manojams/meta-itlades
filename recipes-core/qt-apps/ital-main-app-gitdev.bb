SUMMARY = "Italdes Qt Main App"
DESCRIPTION = "Italdes Qt main app"
LICENSE = "CLOSED"

DEPENDS = "qtdeclarative qtgraphicaleffects qtmultimedia qtsvg qtserialport qca"

SRCREV = "6112bd86ca202f46f520a444b6336d02b39c0511"
SRC_URI = "git://git@192.168.12.15/qt-group/arm/blackarm-qt-ca10.git;protocol=ssh;branch=ca10qmldev"

#TARGET_CFLAGS +=

S = "${WORKDIR}/git"

require recipes-qt/qt5/qt5.inc

do_install() {
    install -d ${D}/opt/bin/
    install -m 0755 ${B}/blackarm ${D}/opt/bin/
}

#FILES_${PN}-dbg += "${datadir}/${P}/.debug"
FILES_${PN} += "opt/bin/"

RDEPENDS_${PN} = "qtdeclarative-qmlplugins qtgraphicaleffects-qmlplugins ital-qt-main-app-service"
