SUMMARY = "Copy Italdes common files "
DESCRIPTION = "Copy Italdes common files"
LICENSE = "CLOSED"

inherit cmake pkgconfig update-rc.d


INITSCRIPT_PACKAGES                 = "${PN}-postgresql"


#INITSCRIPT_PARAMS = "defaults 10"
#INITSCRIPT_NAME = "postgresql-server"

#FILES_${PN}+="${sysconfdir}/init.d/postgresql-server"
#INITSCRIPT_PARAMS-postgresql = "defaults 10"
#INITSCRIPT_NAME-postgresql = "postgresql-server"
