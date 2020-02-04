do_install_append () {
    rm ${D}${sysconfdir}/ssh/sshd_config
}
