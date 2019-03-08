SUMMARY = "Italdes Media Audio"
DESCRIPTION = "Media AUdio files"
LICENSE = "CLOSED"


SRC_URI = "file://video01.mp4 \
           file://video01.png \
           file://video02.mp4 \
           file://video02.png \
           file://video03.mp4 \
           file://video03.png \
           file://video04.mp4 \
           file://video04.png \
           file://video05.mp4 \
           file://video05.png \
           file://video06.mp4 \
           file://video06.png \
           file://video07.mp4 \
           file://video07.png \
           file://video08.mp4 \
           file://video08.png \
           file://video09.mp4 \
           file://video09.png \
         "

S = "${WORKDIR}"

do_install () {
  install -d ${D}/sdcard/media/video
  install -m 0555 ${WORKDIR}/video01.mp4 ${D}/sdcard/media/video/
  install -m 0555 ${WORKDIR}/video01.png ${D}/sdcard/media/video/
  install -m 0555 ${WORKDIR}/video02.mp4 ${D}/sdcard/media/video/
  install -m 0555 ${WORKDIR}/video02.png ${D}/sdcard/media/video/
  install -m 0555 ${WORKDIR}/video03.mp4 ${D}/sdcard/media/video/
  install -m 0555 ${WORKDIR}/video03.png ${D}/sdcard/media/video/
  install -m 0555 ${WORKDIR}/video04.mp4 ${D}/sdcard/media/video/
  install -m 0555 ${WORKDIR}/video04.png ${D}/sdcard/media/video/
  install -m 0555 ${WORKDIR}/video05.mp4 ${D}/sdcard/media/video/
  install -m 0555 ${WORKDIR}/video05.png ${D}/sdcard/media/video/
  install -m 0555 ${WORKDIR}/video06.mp4 ${D}/sdcard/media/video/
  install -m 0555 ${WORKDIR}/video06.png ${D}/sdcard/media/video/
  install -m 0555 ${WORKDIR}/video07.mp4 ${D}/sdcard/media/video/
  install -m 0555 ${WORKDIR}/video07.png ${D}/sdcard/media/video/
  install -m 0555 ${WORKDIR}/video08.mp4 ${D}/sdcard/media/video/
  install -m 0555 ${WORKDIR}/video08.png ${D}/sdcard/media/video/
  install -m 0555 ${WORKDIR}/video09.mp4 ${D}/sdcard/media/video/
  install -m 0555 ${WORKDIR}/video09.png ${D}/sdcard/media/video/
}

FILES_${PN} += "sdcard/media/video"

RDEPENDS_${PN} = "ital-media-xml"
