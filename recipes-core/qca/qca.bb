SUMMARY = "Qt Cryptographic"

LICENSE="CLOSED"

inherit cmake_qt5
 
SRC_URI = "file://qca.tar.bz2"

S = "${WORKDIR}/qca"

FILES_${PN} += "${libdir}  /usr/mkspecs"
FILES_${PN}-dbg += "${libdir}/qca-qt5/crypto/.debug"

