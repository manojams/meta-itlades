inherit update-rc.d

INITSCRIPT_NAME = "${PN}"
INITSCRIPT_PACKAGES = "${PN}"
INITSCRIPT_PARAMS = "start 90 5 2 . stop 30 0 1 6 ."
