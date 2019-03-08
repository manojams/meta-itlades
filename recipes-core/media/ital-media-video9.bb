SUMMARY = "Italdes Media Audio"
DESCRIPTION = "Media AUdio files"
LICENSE = "CLOSED"


SRC_URI = "file://video09.mp4 \
           file://video09.png \
         "

S = "${WORKDIR}"

do_install () {
  install -d ${D}/sdcard/media/video

  install -m 0555 ${WORKDIR}/video09.mp4 ${D}/sdcard/media/video/
  install -m 0555 ${WORKDIR}/video09.png ${D}/sdcard/media/video/
}

FILES_${PN} += "sdcard/media/video"

RDEPENDS_${PN} = "ital-media-xml"
