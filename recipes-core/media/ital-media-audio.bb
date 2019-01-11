SUMMARY = "Italdes Media Audio"
DESCRIPTION = "Media AUdio files"
LICENSE = "CLOSED"


SRC_URI = "file://audio_1.wav \
           file://audio_2.wav \
           file://audio_3.wav \
           file://audio_4.wav \
           file://audio_5.wav \
           file://audio_6.wav \
           file://audio_7.wav \
           file://audio_8.wav \
           file://audio_9.wav \
           file://audio_10.wav \
           file://audio_11.wav \
           file://audio_12.wav \
           file://audio_13.wav \
           file://audio_14.wav \
           file://audio_15.wav \
           file://audio_16.wav \
           file://audio_17.wav \
           file://audio_18.wav \
           file://audio_19.wav \
           file://audio_20.wav \
           file://audio_21.wav \
           file://audio_22.wav \
           file://audio_23.wav \
           file://audio_24.wav \
           file://audio_25.wav \
           file://audio_26.wav \
           file://audio_27.wav \
           file://audio_28.wav \
           file://audio_29.wav \
           file://audio_30.wav \
           file://audio_31.wav \
           file://audio_32.wav \
           file://audio_33.wav \
           file://audio_34.wav \
           file://audio_35.wav \
           file://audio_36.wav \
         "

S = "${WORKDIR}"

do_install () {
  install -d ${D}/sdcard/media/audio
  install -m 0555 ${WORKDIR}/audio_1.wav ${D}/sdcard/media/audio/
  install -m 0555 ${WORKDIR}/audio_2.wav ${D}/sdcard/media/audio/
  install -m 0555 ${WORKDIR}/audio_3.wav ${D}/sdcard/media/audio/
  install -m 0555 ${WORKDIR}/audio_4.wav ${D}/sdcard/media/audio/
  install -m 0555 ${WORKDIR}/audio_5.wav ${D}/sdcard/media/audio/
  install -m 0555 ${WORKDIR}/audio_6.wav ${D}/sdcard/media/audio/
  install -m 0555 ${WORKDIR}/audio_7.wav ${D}/sdcard/media/audio/
  install -m 0555 ${WORKDIR}/audio_8.wav ${D}/sdcard/media/audio/
  install -m 0555 ${WORKDIR}/audio_9.wav ${D}/sdcard/media/audio/
  install -m 0555 ${WORKDIR}/audio_10.wav ${D}/sdcard/media/audio/
  install -m 0555 ${WORKDIR}/audio_12.wav ${D}/sdcard/media/audio/
  install -m 0555 ${WORKDIR}/audio_13.wav ${D}/sdcard/media/audio/
  install -m 0555 ${WORKDIR}/audio_14.wav ${D}/sdcard/media/audio/
  install -m 0555 ${WORKDIR}/audio_15.wav ${D}/sdcard/media/audio/
  install -m 0555 ${WORKDIR}/audio_16.wav ${D}/sdcard/media/audio/
  install -m 0555 ${WORKDIR}/audio_17.wav ${D}/sdcard/media/audio/
}

FILES_${PN} += "sdcard/media/audio"

RDEPENDS_${PN} = "ital-media-xml"
