inherit core-image
inherit distro_features_check
#inherit populate_sdk
#inherit populate_sdk_${@base_contains('MACHINE', 'italdesgeam6ul', 'qt5_geam6ul', 'qt5_icore', d)}


DEPENDS += " italdes-pyro-ca10-production"

IMAGE_INSTALL_append_mx6 = " develop-files \
                              italdes-pyro-ca10-production"

export IMAGE_BASENAME = "italdes-pyro-ca10-develop"
