SUMMARY = "Copy Italdes common files "
DESCRIPTION = "Copy Italdes common files"
LICENSE = "CLOSED"

SRC_URI = "file://dist/bna_daemon.jar;unpack=0 \
          file://dist/lib/dbus.jar;unpack=0 \
          file://dist/lib/hexdump.jar;unpack=0 \
          file://dist/lib/jssc.jar;unpack=0 \
          file://dist/lib/MEI-java.jar;unpack=0 \
          file://dist/lib/unix.jar;unpack=0 \
         "


S = "${WORKDIR}"

do_install () {
	install -d ${D}/home
  install -d ${D}/home/root
  install -d ${D}/home/root/dist
	install -m 0444 ${WORKDIR}/dist/bna_daemon.jar ${D}/home/root/dist/bna_daemon.jar
  install -d ${D}/home/root/dist/lib
  install -m 0444 ${WORKDIR}/dist/lib/dbus.jar ${D}/home/root/dist/lib/dbus.jar
  install -m 0444 ${WORKDIR}/dist/lib/hexdump.jar ${D}/home/root/dist/lib/hexdump.jar
  install -m 0444 ${WORKDIR}/dist/lib/jssc.jar ${D}/home/root/dist/lib/jssc.jar
  install -m 0444 ${WORKDIR}/dist/lib/MEI-java.jar ${D}/home/root/dist/lib/MEI-java.jar
  install -m 0444 ${WORKDIR}/dist/lib/unix.jar ${D}/home/root/dist/lib/unix.jar
}

#ALLOW_EMPTY_${PN} = "1"
INSANE_SKIP_${PN} += "already-stripped"
FILES_${PN} += "home/root/"
INSANE_SKIP_${PN} += "installed-vs-shipped "
