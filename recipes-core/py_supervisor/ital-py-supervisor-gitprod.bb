SUMMARY = "Italdes python supervisor"
LICENSE = "CLOSED"
inherit gitpkgv

inherit setuptools3

SRCREV = "8b9d558d8fb72fd9fe9e5295053acf10b1bbec32"
SRC_URI = "git://git@192.168.228.215/qt-group/arm/python_manager.git;protocol=ssh;branch=production"

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
    ${PYTHON_PN}-aws-iot-device-sdk-python \
    ${PYTHON_PN}-dependency-injector"


PKGV = "${GITPKGVTAG}"
