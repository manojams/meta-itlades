SUMMARY = "OpenSSH configuration file"
DESCRIPTION = "install sshd_config file and authorization key file"
LICENSE = "CLOSED"



SRC_URI = "file://authorized_keys"

S = "${WORKDIR}"

do_install() {
    install -d ${D}/home/italdesfx/.ssh
    install ${WORKDIR}/authorized_keys ${D}/home/italdesfx/.ssh/authorized_keys
}

FILES_${PN} += "/home/italdesfx/.ssh"
