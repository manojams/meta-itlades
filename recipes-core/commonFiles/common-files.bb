SUMMARY = "Copy Italdes common files "
DESCRIPTION = "Copy Italdes common files"
LICENSE = "CLOSED"

SRC_URI = "file://etc/rotation \
    	   file://etc/openvpn/chiave.key \
    	   file://etc/openvpn/client.conf \
    	   file://etc/openvpn/italdes-ca.crt \
    	   file://etc/rc5.d/S99z_Italdes.sh \
	       file://etc/udev/rules.d/99-italdes.rules\
         file://home/root/bna_configrete \
         file://home/root/chk_vpu_err.sh\
         file://home/root/configurazione.sh\
         file://home/root/config.xml\
         file://home/root/dhcp_enabled\
         file://home/root/error_list.csv\
         file://home/root/italdes_apps.sh\
         file://home/root/ntpd_check.sh\
         file://home/root/rfid_update.sh\
         file://home/root/service.txt\
         file://home/root/keys/italdes.pem\
         file://home/root/keys/italdes_pubkey.pem\
         file://home/root/ttyX.tar.gz;unpack=0 \
         "


S = "${WORKDIR}"

do_install () {
	install -d ${D}/etc
	install -m 0444 ${WORKDIR}/etc/rotation ${D}/etc/rotation
	install -d ${D}/etc/openvpn
	install -m 0444 ${WORKDIR}/etc/openvpn/chiave.key ${D}/etc/openvpn/chiave.key
	install -m 0444 ${WORKDIR}/etc/openvpn/client.conf ${D}/etc/openvpn/client.conf
	install -m 0444 ${WORKDIR}/etc/openvpn/italdes-ca.crt ${D}/etc/openvpn/italdes-ca.crt
	install -d ${D}/etc/rc5.d
	install -m 0555 ${WORKDIR}/etc/rc5.d/S99z_Italdes.sh ${D}/etc/rc5.d/S99z_Italdes.sh
	install -d ${D}/etc/udev
	install -d ${D}/etc/udev/rules.d
	install -m 0444 ${WORKDIR}/etc/udev/rules.d/99-italdes.rules ${D}/etc/udev/rules.d/99-italdes.rules
  install -d ${D}/home
  install -d ${D}/home/root
  cp -rf  ${WORKDIR}/home/root/ttyX.tar.gz ${D}/home/root/
  install -m 0444 ${WORKDIR}/home/root/bna_configrete  ${D}/home/root/bna_configrete
  install -m 0555 ${WORKDIR}/home/root/chk_vpu_err.sh  ${D}/home/root/chk_vpu_err.sh
  install -m 0555 ${WORKDIR}/home/root/configurazione.sh  ${D}/home/root/configurazione.sh
  install -m 0666 ${WORKDIR}/home/root/config.xml  ${D}/home/root/config.xml
  install -m 0444 ${WORKDIR}/home/root/dhcp_enabled  ${D}/home/root/dhcp_enabled
  install -m 0444 ${WORKDIR}/home/root/error_list.csv  ${D}/home/root/error_list.csv
  install -m 0555 ${WORKDIR}/home/root/italdes_apps.sh  ${D}/home/root/italdes_apps.sh
  install -m 0555 ${WORKDIR}/home/root/ntpd_check.sh  ${D}/home/root/ntpd_check.sh
  install -m 0555 ${WORKDIR}/home/root/rfid_update.sh  ${D}/home/root/rfid_update.sh
  install -m 0444 ${WORKDIR}/home/root/service.txt  ${D}/home/root/service.txt
  install -d ${D}/home/root/keys
  install -m 0444 ${WORKDIR}/home/root/keys/italdes.pem  ${D}/home/root/keys/italdes.pem
  install -m 0444 ${WORKDIR}/home/root/keys/italdes_pubkey.pem  ${D}/home/root/keys/italdes_pubkey.pem

}


INSANE_SKIP_${PN} += "already-stripped"
FILES_${PN} += "etc/"
FILES_${PN} += "home/root/"
INSANE_SKIP_${PN} += "installed-vs-shipped "
