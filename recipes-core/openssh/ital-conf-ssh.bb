SUMMARY = "OpenSSH configuration file"
DESCRIPTION = "install sshd_config file and authorization key file"
LICENSE = "CLOSED"

#DEPENDS += "openssh"

SRC_URI = "file://sshd_config \
	   file://authorized_keys"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${sysconfdir}/ssh
    install -d ${D}/home/italdesfx/.ssh
    install ${WORKDIR}/authorized_keys ${D}/home/italdesfx/.ssh/authorized_keys
    install ${WORKDIR}/sshd_config ${D}${sysconfdir}/ssh
}

FILES_${PN} += "${sysconfdir}/ssh"
FILES_${PN} += "/home/italdesfx/.ssh"
