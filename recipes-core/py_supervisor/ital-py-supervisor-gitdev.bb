SUMMARY = "Italdes python supervisor"
LICENSE = "CLOSED"
inherit gitpkgv

inherit setuptools3

SRCREV = "${AUTOREV}"
#SRCREV = "99d586cde0fdb8bf70f8abc5fbcf3ed524c0bc76"
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
    ${PYTHON_PN}-psutil \
    ital-py-supervisor-service \
    ital-py-app-git \
    ${PYTHON_PN}-aws-iot-device-sdk-python"

PKGV = "${GITPKGV}"
