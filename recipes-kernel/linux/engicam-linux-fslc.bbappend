FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
LICENSE = "GPLv2"

SRC_URI += "file://defconfig \
            file://0001-Add-new-monitor.patch \
            file://0001-Add-Gsm-Modem.patch \
	    file://0001-Fix-dtb-in-SOC_IMX6Q.patch \
            file://0001-Removed-iriginal-goodix.c.patch \
            file://0002-Added-goodix.c-modified-by-Engicam.patch \
	          file://0002-Logo-kernel-Italdes-vert.patch	"
