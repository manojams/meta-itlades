SUMMARY = "Italdes python supervisor"
LICENSE = "CLOSED"
inherit gitpkgv

inherit setuptools3

#SRCREV = "${AUTOREV}"
SRCREV = "cd9db484a10b8ff32e79d4bf854a948ec4e6e812"
SRC_URI = "git://git@192.168.228.215/qt-group/arm/python_manager.git;protocol=ssh;branch=master"

#DEPENDS += "${PYTHON_PN}-pytest-runner-native"

S = "${WORKDIR}/git"

RDEPENDS_${PN} = "\
    ${PYTHON_PN}-logging \
    ${PYTHON_PN}-threading \
    ${PYTHON_PN}-paho-mqtt \
    ${PYTHON_PN}-xml \
    ${PYTHON_PN}-pyserial \
    ${PYTHON_PN}-requests \
    ital-py-supervisor-service \
    ital-py-app-git"

PKGV = "${GITPKGVTAG}"
