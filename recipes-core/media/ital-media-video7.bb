SUMMARY = "Italdes Media Audio"
DESCRIPTION = "Media AUdio files"
LICENSE = "CLOSED"


SRC_URI = "file://video07.mp4 \
           file://video07.png \
         "

S = "${WORKDIR}"

do_install () {
  install -d ${D}/sdcard/media/video

  install -m 0555 ${WORKDIR}/video07.mp4 ${D}/sdcard/media/video/
  install -m 0555 ${WORKDIR}/video07.png ${D}/sdcard/media/video/

}

FILES_${PN} += "sdcard/media/video"

RDEPENDS_${PN} = "ital-media-xml"
