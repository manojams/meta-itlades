
FILESEXTRAPATHS_append := "${THISDIR}/${PN}"
LICENSE = "CLOSED"

DEPENDS = "dbus"

SRC_URI = "file://system.conf"

do_install () {
	install -d ${D}/etc/
	install -d ${D}/etc/dbus-1/
	install -m 0755 ${WORKDIR}/system.conf ${D}/etc/dbus-1/system.conf.my
}


FILES_${PN} += "etc"


