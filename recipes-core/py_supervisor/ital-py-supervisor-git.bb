SUMMARY = "Italdes python supervisor"
LICENSE = "CLOSED"

inherit setuptools3

SRCREV = "7f99e62904e44f23df5d9056904dea4695010f54"
SRC_URI = "git://git@192.168.12.15/qt-group/arm/python_manager.git;protocol=ssh;branch=master"

#DEPENDS += "${PYTHON_PN}-pytest-runner-native"

S = "${WORKDIR}/git"

RDEPENDS_${PN} = "\
    ${PYTHON_PN}-logging \
    ${PYTHON_PN}-threading \
    ${PYTHON_PN}-paho-mqtt \
    ${PYTHON_PN}-xml \
    ital-py-supervisor-service \
    ital-py-app-git"
