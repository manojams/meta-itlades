SUMMARY = "Italdes Qt Main App"
DESCRIPTION = "Italdes Qt main app"
LICENSE = "CLOSED"
inherit gitpkgv

DEPENDS = "qtdeclarative qtgraphicaleffects qtmultimedia qtsvg qtserialport qca"
#SRCREV = "${AUTOREV}"
SRCREV= "1ab2734b4b3d09d65e1458f4ab7b4e742571c966"
SRC_URI = "git://git@192.168.228.215/qt-group/arm/blackarm-qt-ca10.git;protocol=ssh;branch=pre_release"

EXTRA_QMAKEVARS_PRE += "CONFIG+=testbag"
#EXTRA_QMAKEVARS_PRE += "CONFIG+=debug"


S = "${WORKDIR}/git"

require recipes-qt/qt5/qt5.inc

do_install() {
    install -d ${D}/opt/bin/
    install -m 0755 ${B}/blackarm ${D}/opt/bin/
}

#FILES_${PN}-dbg += "${datadir}/${P}/.debug"
FILES_${PN} += "opt/bin/"

#PV .= "+git${SRCPV}"
#PKGV = "${GITPKGV}"
PKGV = "${GITPKGVTAG}"

RDEPENDS_${PN} = "qtdeclarative-qmlplugins qtgraphicaleffects-qmlplugins ital-qt-main-app-service"
