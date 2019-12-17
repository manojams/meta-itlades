do_install(){

    if ${@bb.utils.contains('DISTRO_FEATURES', 'sysvinit', 'true', 'false', d)}; then
        mkdir -p ${D}${sysconfdir}/cron.hourly
        install -p -m 0755 ${S}/examples/logrotate.cron ${D}${sysconfdir}/cron.hourly/logrotate
    fi
}
