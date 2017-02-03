FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://defconfig	\
            file://0001-added-imx6ul-italdes.dts.patch	\
	    file://0002-added-gpio-RFID.patch	\
	    file://0003-added-touchscreen-support.patch	\
	    file://0004-add-goodix-touchscreen-driver-and-DENSITRON-lcd-disp.patch	\
"
