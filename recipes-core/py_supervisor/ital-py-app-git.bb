SUMMARY = "Italdes Qt Python App"
DESCRIPTION = "Italdes Qt Python app"
LICENSE = "CLOSED"
inherit gitpkgv

DEPENDS = "qtdeclarative qtsvg"

SRCREV = "166cee86c02b4ce5660e9683f68e44b0ae5b6e91"
#SRCREV = "${AUTOREV}"
SRC_URI = "git://git@192.168.228.215/qt-group/arm/qt-python-service-app.git;protocol=ssh;branch=master"


S = "${WORKDIR}/git"

require recipes-qt/qt5/qt5.inc

do_install() {
    install -d ${D}/opt/bin/
    install -m 0755 ${B}/qt-py-app ${D}/opt/bin/
}

FILES_${PN} += "opt/bin/"
PKGV = "${GITPKGVTAG}"

RDEPENDS_${PN} = "qtdeclarative-qmlplugins qtgraphicaleffects-qmlplugins ital-qt-py-app-service"
