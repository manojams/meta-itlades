inherit core-image
inherit distro_features_check
#inherit populate_sdk_qt5
#inherit populate_sdk
#inherit populate_sdk_${@base_contains('MACHINE', 'italdesgeam6ul', 'qt5_geam6ul', 'qt5_icore', d)}

EXTRA_IMAGE_FEATURES = "debug-tweaks ssh-server-openssh tools-debug package-management"

IMAGE_INSTALL_append_mx6 = " \
    firmware-imx-vpu-imx6q \
"

IMAGE_INSTALL_append_mx6 = " \
  qtquick1 \
  qtquick1-plugins \
  qtquick1-qmlplugins \
  qtquickcontrols-qmlplugins \
  qtquickcontrols \
  qtquickcontrols2 \
  qtquickcontrols2-qmlplugins \
  qtmultimedia \
  qtmultimedia-plugins\
  qtmultimedia-qmlplugins\
  liberation-fonts\
  giflib\
    packagegroup-qt5-qtcreator-debug \
    binutils \
    qtbase-mkspecs \
    qtbase-plugins \
    qtconnectivity-mkspecs \
    qtconnectivity-qmlplugins \
   qtdeclarative-mkspecs \
    qtdeclarative-qmlplugins \
    qtgraphicaleffects \
    pulseaudio \
    qtenginio-mkspecs \
    qtenginio-qmlplugins \
    qtgraphicaleffects-qmlplugins \
    qtimageformats-plugins \
    qtsvg-mkspecs \
    qtsvg-plugins \
    qtxmlpatterns-mkspecs \
    qtserialport \
    tslib evtest tslib-conf tslib-tests tslib-calibrate \
    psplash \
    engicam-mtd-script \
    mtd-utils imx-kobs mtd-utils-ubifs \
    openvpn \
    nano \
    openct opensc \
    sqlite3 \
    qca \
    ntp \
    tzdata \
    u-boot-eng-fw-utils \
    fw-nandautosize \
    gst-meta-video \
    gstreamer1.0-plugins-imx \
    packagegroup-fsl-gstreamer1.0-full \
    alsa-utils \
    iptables \
    init-ifupdown\
    libgal-mx6 \
    libegl-mx6 \
    libvsc-mx6 \
    libglslc-mx6 \
    libgles2-mx6 \
    ital-imageformats-qml \
    python3-paho-mqtt \
    libpulse-mainloop-glib \
    ital-common-files \
    "

DISTRO_FEATURES_append = " opengl"

IMAGE_INSTALL_remove ="qt3d nativesdk-qt3d qt3d-native ruby-native wpa-supplicant wireless-tools perl-module \
                      packagegroup-base-wifi qtlocation qtsensors "

DISTRO_FEATURES_remove = "bluez5 bluetooth irda pcmcia wifi nfc usbgadget 3g"


export IMAGE_BASENAME = "italdes-pyro-ca10-production"

update_rootfs() {
  tar -xzvf ${IMAGE_ROOTFS}/home/root/ttyX.tar.gz -C ${IMAGE_ROOTFS}/home/root/
  rm ${IMAGE_ROOTFS}/home/root/ttyX.tar.gz
}

ROOTFS_POSTPROCESS_COMMAND += "update_rootfs;"
