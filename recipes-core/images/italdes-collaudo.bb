inherit core-image
inherit distro_features_check
inherit populate_sdk 
inherit populate_sdk_${@base_contains('MACHINE', 'italdesgeam6ul', 'qt5_geam6ul', 'qt5', d)}

EXTRA_IMAGE_FEATURES = "debug-tweaks ssh-server-openssh tools-debug"

IMAGE_INSTALL_append_mx6 = " \
    firmware-imx-vpu-imx6q \
"
IMAGE_INSTALL_append_mx6 = " \
	packagegroup-qt5-qtcreator-debug \ 
	qtserialport \   
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
"
 
IMAGE_INSTALL_append_mx6ul = " \
	packagegroup-qt5-qtcreator-debug \
	qtserialport \
	openssh-sftp-server \   
	binutils \   
	qtbase-dev \
	qtbase-fonts \
	qtbase-mkspecs \
	qtbase-plugins \
	qtbase-staticdev \
	qtdeclarative-dev \
	qtdeclarative-mkspecs \
	qtdeclarative-plugins \
	qtdeclarative-qmlplugins \
	qtdeclarative-staticdev \
	qtimageformats-dev \
	qtimageformats-plugins \
	qtsvg-dev \
	qtsvg-mkspecs \
	qtsvg-plugins \	
	qtquick1 \
"

#PACKAGES TSLIB+EVTEST
IMAGE_INSTALL_append = " \
	tslib \
	evtest \
	tslib-conf \
	tslib-tests \
	tslib-calibrate \
"

#PACKAGES MTD UTILS
IMAGE_INSTALL_append = " \
	engicam-mtd-script \
	mtd-utils \
	imx-kobs \
	mtd-utils-ubifs \
	fw-nandautosize \
	u-boot-eng-fw-utils \
"

#PACKAGES DEBUG
IMAGE_INSTALL_append = " \
	psplash \
"

#ALSA PACKAGES
IMAGE_INSTALL_append = " \
	alsa-utils \
	alsa-tools \
	alsa-state \
	alsa-lib \
	alsa-utils-alsaconf \
"

export IMAGE_BASENAME = "italdes-collaudo"
