inherit core-image
inherit distro_features_check
inherit populate_sdk
inherit populate_sdk_${@base_contains('MACHINE', 'italdesgeam6ul', 'qt5_geam6ul', 'qt5_icore', d)}

EXTRA_IMAGE_FEATURES = "debug-tweaks ssh-server-openssh tools-debug"

IMAGE_INSTALL_append_mx6 = " \
    firmware-imx-vpu-imx6q \
"
IMAGE_INSTALL_append_mx6 = " \
    packagegroup-qt5-qtcreator-debug \
    binutils \
    qtbase-dev \
    qtbase-fonts \
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
    packagegroup-fslc-gstreamer1.0-full \
    gstreamer1.0-plugins-imx \
    common-files \
    black-arm \
    iptables \
    "


IMAGE_INSTALL_append_mx6ul = " \
    packagegroup-qt5-qtcreator-debug \
    openssh-sftp-server \
    binutils \
    qtbase-dev \
    qtbase-fonts \
    qtbase-mkspecs \
    qtbase-plugins \
    qtbase-staticdev \
    qtimageformats-dev \
    qtimageformats-plugins \
    qtsvg-dev \
    qtsvg-mkspecs \
    qtsvg-plugins \
    qtxmlpatterns-dev \
    qtxmlpatterns-mkspecs \
    tslib evtest tslib-conf tslib-tests tslib-calibrate \
    psplash \
    engicam-mtd-script \
    mtd-utils imx-kobs mtd-utils-ubifs \
    dbus \
    openvpn \
    pcsc-lite \
    nano \
    libunix-java-dev \
    openct opensc \
    pcsc-tools \
    dbus-settings \
    sqlite3 \
    qca \
    ntp \
    tzdata \
    u-boot-eng-fw-utils \
    fw-nandautosize \
"

IMAGE_INSTALL_remove ="qt3d nativesdk-qt3d qt3d-native ruby-native"

export IMAGE_BASENAME = "italdes-test-image"

IMAGE_INSTALL_append += "jdk8"

update_rootfs() {
	tar -xzvf ${IMAGE_ROOTFS}/jdk1.8/jdk-8u91-linux-arm32-vfp-hflt.tar.gz -C ${IMAGE_ROOTFS}/jdk1.8
	rm ${IMAGE_ROOTFS}/jdk1.8/jdk-8u91-linux-arm32-vfp-hflt.tar.gz
  tar -xzvf ${IMAGE_ROOTFS}/home/root/ttyX.tar.gz -C ${IMAGE_ROOTFS}/home/root/
  rm ${IMAGE_ROOTFS}/home/root/ttyX.tar.gz
	ln -s -r  ${IMAGE_ROOTFS}/jdk1.8/jdk1.8.0_91/jre/bin/java  ${IMAGE_ROOTFS}/usr/bin/java
	ls -alFh ${IMAGE_ROOTFS}/etc/dbus-1/
	rm ${IMAGE_ROOTFS}/etc/dbus-1/system.conf
	mv ${IMAGE_ROOTFS}/etc/dbus-1/system.conf.my  ${IMAGE_ROOTFS}/etc/dbus-1/system.conf
}

ROOTFS_POSTPROCESS_COMMAND += "update_rootfs;"
