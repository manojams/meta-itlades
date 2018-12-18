SUMMARY = "Copy Italdes common files "
DESCRIPTION = "Copy Italdes common files"
LICENSE = "CLOSED"

SRC_URI = "file://sbin/autoupdate.sh \
         file://etc/iptables-save \
    	   file://etc/rc5.d/S99z_Italdes.sh \
         file://etc/init.d/update_media.sh \
	       file://etc/udev/rules.d/99-italdes.rules\
         file://home/root/chk_vpu_err.sh\
         file://home/root/configurazione.sh\
         file://home/root/comandi.txt\
         file://home/root/config.xml\
         file://home/root/dhcp_enabled\
         file://home/root/italdes_apps.sh\
         file://home/root/ntpd_check.sh\
         file://home/root/rfid_update.sh\
         file://home/root/service.txt\
         file://home/root/drop_cache.sh\
         file://home/root/ttyX.tar.gz;unpack=0 \
         "

S = "${WORKDIR}"

do_install () {
	install -d ${D}/sbin
  install -m 0555 ${WORKDIR}/sbin/autoupdate.sh ${D}/sbin/autoupdate.sh
	install -d ${D}/etc
  install -m 0444 ${WORKDIR}/etc/iptables-save ${D}/etc/iptables-save
  install -d ${D}/etc/init.d
  install -m 0444 ${WORKDIR}/etc/init.d/update_media.sh ${D}/etc/init.d/update_media.sh
	install -d ${D}/etc/rc5.d
	install -m 0555 ${WORKDIR}/etc/rc5.d/S99z_Italdes.sh ${D}/etc/rc5.d/S99z_Italdes.sh
	install -d ${D}/etc/udev
	install -d ${D}/etc/udev/rules.d
	install -m 0444 ${WORKDIR}/etc/udev/rules.d/99-italdes.rules ${D}/etc/udev/rules.d/99-italdes.rules
  install -d ${D}/home
  install -d ${D}/home/root
  cp -rf  ${WORKDIR}/home/root/ttyX.tar.gz ${D}/home/root/
  install -m 0555 ${WORKDIR}/home/root/chk_vpu_err.sh  ${D}/home/root/chk_vpu_err.sh
  install -m 0555 ${WORKDIR}/home/root/configurazione.sh  ${D}/home/root/configurazione.sh
  install -m 0666 ${WORKDIR}/home/root/config.xml  ${D}/home/root/config.xml
  install -m 0444 ${WORKDIR}/home/root/dhcp_enabled  ${D}/home/root/dhcp_enabled
  install -m 0555 ${WORKDIR}/home/root/italdes_apps.sh  ${D}/home/root/italdes_apps.sh
  install -m 0555 ${WORKDIR}/home/root/ntpd_check.sh  ${D}/home/root/ntpd_check.sh
  install -m 0555 ${WORKDIR}/home/root/rfid_update.sh  ${D}/home/root/rfid_update.sh
  install -m 0444 ${WORKDIR}/home/root/service.txt  ${D}/home/root/service.txt
  install -m 0444 ${WORKDIR}/home/root/comandi.txt  ${D}/home/root/comandi.txt
  install -m 0444 ${WORKDIR}/home/root/drop_cache.sh  ${D}/home/root/drop_cache.sh

}

#INSANE_SKIP_${PN} += "already-stripped"
FILES_${PN} += "sbin/"
FILES_${PN} += "etc/"
FILES_${PN} += "home/root/"
#INSANE_SKIP_${PN} += "installed-vs-shipped "
