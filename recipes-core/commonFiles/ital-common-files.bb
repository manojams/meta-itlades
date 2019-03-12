SUMMARY = "Copy Italdes common files "
DESCRIPTION = "Copy Italdes common files"
LICENSE = "CLOSED"

SRC_URI = "file://etc/iptables-save \
					file://etc/rotation \
	       file://etc/udev/rules.d/99-italdes.rules\
         file://home/root/chk_vpu_err.sh\
         file://home/root/configurazione.sh\
         file://home/root/comandi.txt\
         file://home/root/dhcp_enabled\
         file://home/root/ntpd_check.sh\
         file://home/root/rfid_update.sh\
         file://home/root/service.txt\
         file://home/root/drop_cache.sh\
         file://home/root/ttyX.tar.gz;unpack=0 \
         "

S = "${WORKDIR}"

do_install () {
	install -d ${D}/etc
  install -m 0444 ${WORKDIR}/etc/iptables-save ${D}/etc/iptables-save
	install -m 0444 ${WORKDIR}/etc/rotation ${D}/etc/rotation
	install -d ${D}/etc/udev
	install -d ${D}/etc/udev/rules.d
	install -m 0444 ${WORKDIR}/etc/udev/rules.d/99-italdes.rules ${D}/etc/udev/rules.d/99-italdes.rules
  install -d ${D}/home
  install -d ${D}/home/root
  cp -rf  ${WORKDIR}/home/root/ttyX.tar.gz ${D}/home/root/
  install -m 0555 ${WORKDIR}/home/root/chk_vpu_err.sh  ${D}/home/root/chk_vpu_err.sh
  install -m 0555 ${WORKDIR}/home/root/configurazione.sh  ${D}/home/root/configurazione.sh
  install -m 0444 ${WORKDIR}/home/root/dhcp_enabled  ${D}/home/root/dhcp_enabled
  install -m 0555 ${WORKDIR}/home/root/ntpd_check.sh  ${D}/home/root/ntpd_check.sh
  install -m 0555 ${WORKDIR}/home/root/rfid_update.sh  ${D}/home/root/rfid_update.sh
  install -m 0444 ${WORKDIR}/home/root/service.txt  ${D}/home/root/service.txt
  install -m 0444 ${WORKDIR}/home/root/comandi.txt  ${D}/home/root/comandi.txt
  install -m 0555 ${WORKDIR}/home/root/drop_cache.sh  ${D}/home/root/drop_cache.sh
}

FILES_${PN} += "etc/"
FILES_${PN} += "home/root/"
