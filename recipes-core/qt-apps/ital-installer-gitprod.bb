SUMMARY = "Italdes Qt Installer sdcard"
DESCRIPTION = "UI for installer from sdcard"
LICENSE = "CLOSED"
inherit gitpkgv

DEPENDS = "qtdeclarative qtgraphicaleffects qtmultimedia qtsvg qtserialport"
SRCREV = "d3838876fcfbfac9c5108f7e913be4430c0f20c8"
SRC_URI = "git://git@192.168.228.215/qt-group/arm/blackarm-installer-qt-ca10.git;protocol=ssh;branch=master"

#TARGET_CFLAGS +=

S = "${WORKDIR}/git"

require recipes-qt/qt5/qt5.inc

do_install() {
    install -d ${D}/opt/bin/
    install -m 0755 ${B}/installer_ba ${D}/opt/bin/
}

#FILES_${PN}-dbg += "${datadir}/${P}/.debug"
FILES_${PN} += "opt/bin/"

PKGV = "${GITPKGVTAG}"
#PV = "0.12-git${SRCPV}"

RDEPENDS_${PN} = "qtdeclarative-qmlplugins qtgraphicaleffects-qmlplugins ital-qt-main-app-service"
