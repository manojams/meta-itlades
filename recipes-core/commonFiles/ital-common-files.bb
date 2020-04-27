SUMMARY = "Copy Italdes common files "
DESCRIPTION = "Copy Italdes common files"
LICENSE = "CLOSED"

SRC_URI = "file://etc/iptables-save \
	   file://etc/rotation \
	   file://etc/udev/rules.d/99-italdes.rules\
     file://home/root/script/chk_vpu_err.sh\
     file://home/root/script/ntpDate.sh\
     file://home/root/script/rfid_update.sh\
     file://home/root/script/drop_cache.sh\
	   file://home/root/script/kill_psplash.sh\
	   file://home/root/configuration/service.txt\
	   file://home/root/script/sdcard_format.sh\
	   file://home/italdes/screenshot.sh\
	   file://home/root/script/ssh_auth_yes_no.sh \
		 file://home/root/configuration/service.txt \
		 file://home/root/configuration/environment.txt \
     "

S = "${WORKDIR}"

do_install () {
	install -d ${D}/etc
  install -m 0444 ${WORKDIR}/etc/iptables-save ${D}/etc/iptables-save
	install -m 0444 ${WORKDIR}/etc/rotation ${D}/etc/rotation

	install -d ${D}/etc/udev/rules.d
	install -m 0444 ${WORKDIR}/etc/udev/rules.d/99-italdes.rules ${D}/etc/udev/rules.d/99-italdes.rules

  install -d ${D}/home/root/configuration
	install -m 0444 ${WORKDIR}/home/root/configuration/service.txt  ${D}/home/root/configuration/
	install -m 0444 ${WORKDIR}/home/root/configuration/environment.txt ${D}/home/root/configuration/

	install -d ${D}/home/root/script
	install -m 0555 ${WORKDIR}/home/root/script/chk_vpu_err.sh  ${D}/home/root/script/
	install -m 0555 ${WORKDIR}/home/root/script/kill_psplash.sh  ${D}/home/root/script/
	install -m 0555 ${WORKDIR}/home/root/script/ntpDate.sh  ${D}/home/root/script/
	install -m 0555 ${WORKDIR}/home/root/script/rfid_update.sh  ${D}/home/root/script/
	install -m 0555 ${WORKDIR}/home/root/script/drop_cache.sh  ${D}/home/root/script/
	install -m 0555 ${WORKDIR}/home/root/script/sdcard_format.sh  ${D}/home/root/script/
	install -m 0555 ${WORKDIR}/home/root/script/ssh_auth_yes_no.sh  ${D}/home/root/script/
	install -d ${D}/home/italdes
	install -m 0555 ${WORKDIR}/home/italdes/screenshot.sh ${D}/home/italdes/

	install -d ${D}/opt/db
	chmod -R 777 ${D}/opt/db

}

FILES_${PN} += "etc/"
FILES_${PN} += "home/root/configuration"
FILES_${PN} += "home/root/script"
FILES_${PN} += "home/italdes"
FILES_${PN} += "opt/db"
