SUMMARY = "Italdes Qt Main App"
DESCRIPTION = "Italdes Qt main app"
LICENSE = "CLOSED"
inherit gitpkgv

DEPENDS = "qtdeclarative qtgraphicaleffects qtmultimedia qtsvg qtserialport qca"
SRCREV = "511368af4a2691c463b332d613e29a6f8b3f66ae"

SRC_URI = "git://git@192.168.228.215/qt-group/arm/blackarm-qt-ca10.git;protocol=ssh;branch=production"

#TARGET_CFLAGS +=

S = "${WORKDIR}/git"

require recipes-qt/qt5/qt5.inc

EXTRA_QMAKEVARS_PRE += "CONFIG+=debug"

do_install() {
    install -d ${D}/opt/bin/
    install -m 0755 ${B}/blackarm ${D}/opt/bin/
}

#FILES_${PN}-dbg += "${datadir}/${P}/.debug"
FILES_${PN} += "opt/bin/"

PKGV = "${GITPKGVTAG}"
#PV = "0.12-git${SRCPV}"

RDEPENDS_${PN} = "qtdeclarative-qmlplugins qtgraphicaleffects-qmlplugins ital-qt-main-app-service"
