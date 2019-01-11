SUMMARY = "Italdes python supervisor"
LICENSE = "CLOSED"

inherit setuptools3

SRCREV = "ebda0c126bfa06f591a4bba958ba284a3f5ce1a3"
SRC_URI = "git://git@192.168.12.15/qt-group/arm/python_manager.git;protocol=ssh;branch=master"

#DEPENDS += "${PYTHON_PN}-pytest-runner-native"

S = "${WORKDIR}/git"

RDEPENDS_${PN} = "\
    ${PYTHON_PN}-logging \
    ${PYTHON_PN}-threading \
    ${PYTHON_PN}-paho-mqtt \
    ${PYTHON_PN}-xml \
    ital-py-supervisor-service"
