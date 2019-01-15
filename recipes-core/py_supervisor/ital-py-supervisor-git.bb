SUMMARY = "Italdes python supervisor"
LICENSE = "CLOSED"

inherit setuptools3

SRCREV = "96c6a7bf3174e67a5ac5b07f0ae68878a43f5c1e"
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
