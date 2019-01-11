SUMMARY = "Italdes Qt Python App"
DESCRIPTION = "Italdes Qt Python app"
LICENSE = "CLOSED"

DEPENDS = "qtdeclarative qtsvg"

SRCREV = "909ef9d85dfc611025f5d37f3f5efbe216027c2d"
SRC_URI = "git://git@192.168.12.15/qt-group/arm/qt-python-service-app.git;protocol=ssh;branch=master"


S = "${WORKDIR}/git"

require recipes-qt/qt5/qt5.inc

do_install() {
    install -d ${D}/opt/bin/
    install -m 0755 ${B}/qt-py-app ${D}/opt/bin/
}

FILES_${PN} += "opt/bin/"

RDEPENDS_${PN} = "qtdeclarative-qmlplugins qtgraphicaleffects-qmlplugins ital-qt-py-app-service"
