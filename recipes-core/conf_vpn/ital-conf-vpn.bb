SUMMARY = "Italdes openvpn configuration"
DESCRIPTION = "Italdes openvpn configuration"
LICENSE = "CLOSED"


SRC_URI = "file://client.conf \
    	   file://italdes-ca.crt \
         file://chiave.key \
         "

S = "${WORKDIR}"

do_install () {
	install -d ${D}/etc/openvpn
	install -m 0444 ${WORKDIR}/chiave.key ${D}/etc/openvpn/chiave.key
	install -m 0444 ${WORKDIR}/client.conf ${D}/etc/openvpn/client.conf
	install -m 0444 ${WORKDIR}/italdes-ca.crt ${D}/etc/openvpn/italdes-ca.crt
}


FILES_${PN} += "etc/openvpn"
