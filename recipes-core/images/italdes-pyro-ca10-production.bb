inherit core-image
inherit distro_features_check
inherit populate_sdk
inherit populate_sdk_${@base_contains('MACHINE', 'italdesgeam6ul', 'qt5_geam6ul', 'qt5_icore', d)}

EXTRA_IMAGE_FEATURES = "debug-tweaks ssh-server-openssh tools-debug package-management"

IMAGE_INSTALL_append_mx6 = " \
    firmware-imx-vpu-imx6q \
"

IMAGE_INSTALL_append_mx6 = " \
    packagegroup-qt5-qtcreator-debug \
    binutils \
    qtbase-dev \
    qtbase-mkspecs \
    qtbase-plugins \
    qtbase-staticdev \
    qtconnectivity-dev \
    qtconnectivity-mkspecs \
    qtconnectivity-qmlplugins \
    qtdeclarative-dev \
   qtdeclarative-mkspecs \
    qtdeclarative-plugins \
    qtdeclarative-qmlplugins \
    qtdeclarative-staticdev \
    qtenginio-dev \
    qtenginio-mkspecs \
    qtenginio-qmlplugins \
    qtgraphicaleffects-qmlplugins \
    qtimageformats-dev \
    qtimageformats-plugins \
    qtsvg-dev \
    qtsvg-mkspecs \
    qtsvg-plugins \
    qtxmlpatterns-dev \
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
    common-files \
    ca10\
    black-arm \
    iptables \
    init-ifupdown\
    libgal-mx6 \
    libegl-mx6 \
    libvsc-mx6 \
    libglslc-mx6 \
    libgles2-mx6 \
    "
DISTRO_FEATURES_append = " opengl"

IMAGE_INSTALL_remove ="qt3d nativesdk-qt3d qt3d-native ruby-native"

export IMAGE_BASENAME = "italdes-pyro-ca10-production"

update_rootfs() {
  tar -xzvf ${IMAGE_ROOTFS}/home/root/ttyX.tar.gz -C ${IMAGE_ROOTFS}/home/root/
  rm ${IMAGE_ROOTFS}/home/root/ttyX.tar.gz
}

ROOTFS_POSTPROCESS_COMMAND += "update_rootfs;"
