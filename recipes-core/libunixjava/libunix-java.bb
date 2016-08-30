SUMMARY = "Basic script for mtd programming"
DESCRIPTION = "This package provides basic script for mtd programming"
LICENSE = "CLOSED"

SRC_URI = "file://libunix-java.so"

S = "${WORKDIR}"

do_install () {
	install -d ${D}/lib
	install -m 0755 ${WORKDIR}/libunix-java.so ${D}/lib/libunix-java.so
}


INSANE_SKIP_${PN} += "already-stripped"
FILES_${PN} += "lib/"
#INSANE_SKIP_${PN} += "installed-vs-shipped " 

