FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
LICENSE = "GPLv2"

SRC_URI += "file://defconfig \
            file://0001-Added-italdes-dts-codec-ok-mmc.patch \
            file://0001-Removed-iriginal-goodix.c.patch \
            file://0002-Added-goodix.c-modified-by-Engicam.patch \
            file://mxc_vpu_dma.patch \
	          file://0002-Logo-kernel-Italdes-vert.patch	"
