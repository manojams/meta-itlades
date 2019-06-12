SUMMARY = "Italdes Qt Installer sdcard"
DESCRIPTION = "UI for installer from sdcard"
LICENSE = "CLOSED"
inherit gitpkgv

DEPENDS = "qtdeclarative qtgraphicaleffects qtmultimedia qtsvg qtserialport"
SRCREV = "9c86e554ee65f89ee1b279b46375fdbe9c01f0d7"
SRC_URI = "git://git@192.168.228.215/qt-group/arm/blackarm-installer-qt.git;protocol=ssh;branch=master"

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
