inherit core-image
inherit distro_features_check
#inherit populate_sdk_qt5
#inherit populate_sdk
#inherit populate_sdk_${@base_contains('MACHINE', 'italdesgeam6ul', 'qt5_geam6ul', 'qt5_icore', d)}

EXTRA_IMAGE_FEATURES = "debug-tweaks ssh-server-openssh package-management"


IMAGE_INSTALL_append_mx6 = " \
  firmware-imx-vpu-imx6q \
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
    psplash \
    nano \
    openssh-misc \
    openvpn \
    openct opensc \
    openssh-ssh \
    openssh-sshd \
    openssh-scp \
    sqlite3 \
    qca \
    ntp \
    ntpdate \
    tzdata \
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
    imageformats-qml \
    libpulse-mainloop-glib \
    bash \
    ital-common-files \
    ital-py-supervisor-gitprod \
    ital-script-service \
    ital-conf-vpn \
    ital-script-vpn \
    wvdial \
    ital-wvdialChat \
    ital-dnf-repo-cert \
    ital-mqtt-cert \
    sshpass \
    cronie \
    logrotate \
    ital-conf-ssh \
    e2fsprogs-mke2fs \
    lrzsz \
    ffmpeg \
    zip \
    curl \
    "

#Antonio aggiunto per utenti ssh il 10-01-2020
inherit extrausers
EXTRA_USERS_PARAMS = " useradd italdes; \
                       usermod -p $(openssl passwd italdesPSW2020) italdes; \
		       usermod -p $(openssl passwd italdes2019) root; \
		       usermod -g shutdown italdes; "

fakeroot update_dot_bashrc () {
echo 'alias reboot="/sbin/shutdown -r now"' >> ${IMAGE_ROOTFS}/home/italdes/.bashrc
}
IMAGE_PREPROCESS_COMMAND += "update_dot_bashrc; "

DISTRO_FEATURES_append = " opengl"

IMAGE_INSTALL_remove ="qt3d nativesdk-qt3d qt3d-native ruby-native wpa-supplicant wireless-tools perl-module \
                      packagegroup-base-wifi qtlocation qtsensors "

DISTRO_FEATURES_remove = "bluez5 bluetooth irda pcmcia wifi nfc usbgadget 3g"

export IMAGE_BASENAME = "italdes-ca10-prod-minimal"




ROOTFS_POSTPROCESS_COMMAND += "update_rootfs;"
ROOTFS_POSTPROCESS_COMMAND_remove = "ssh_allow_empty_password;"
