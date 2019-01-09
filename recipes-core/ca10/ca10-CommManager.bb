SUMMARY = "GRG CommManager"
DESCRIPTION = "Ca10 lib and CommManager"
LICENSE = "CLOSED"

SRC_URI = "file://GRGCA10DevCfg.ini \
    	   file://GRGCA10Dev_DRIVER_MUTEX \
    	   file://GrgCommManager \
    	   file://GRGDTATM_CommCfg.ini \
	       file://GrgLogServer.cfg\
         file://libDevDriverLog.so \
         file://libGRGCA10Dev.so\
         file://libGrgDevBase.so\
         file://interfaces_ca10.txt\
         "

S = "${WORKDIR}"

do_install () {
	install -d ${D}/usr/lib
	install -m 0444 ${WORKDIR}/libDevDriverLog.so ${D}/usr/lib/libDevDriverLog.so
  install -m 0444 ${WORKDIR}/libGRGCA10Dev.so ${D}/usr/lib/libGRGCA10Dev.so
  install -m 0444 ${WORKDIR}/libGrgDevBase.so ${D}/usr/lib/libGrgDevBase.so

	install -d ${D}/home/root/grg
	install -m 0444 ${WORKDIR}/GRGCA10DevCfg.ini ${D}/home/root/grg/GRGCA10DevCfg.ini
  install -m 0444 ${WORKDIR}/GRGCA10Dev_DRIVER_MUTEX ${D}/home/root/grg/GRGCA10Dev_DRIVER_MUTEX
  install -m 0555 ${WORKDIR}/GrgCommManager ${D}/home/root/grg/GrgCommManager
  install -m 0444 ${WORKDIR}/GRGDTATM_CommCfg.ini ${D}/home/root/grg/GRGDTATM_CommCfg.ini
  install -m 0444 ${WORKDIR}/GrgLogServer.cfg ${D}/home/root/grg/GrgLogServer.cfg
  install -m 0444 ${WORKDIR}/interfaces_ca10.txt ${D}/home/root/grg/interfaces_ca10.txt
}

#INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
PACKAGES = "${PN}"
#INSANE_SKIP_${PN} += "dev-deps"
INSANE_SKIP_${PN} += "already-stripped"
FILES_${PN} += "usr/lib"
FILES_${PN} += "home/root/grg"
#FILES_{PN}-dev += "usr/lib/*.so"
#INSANE_SKIP_${PN} += "installed-vs-shipped "
