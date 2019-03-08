# Copyright (C) 2014 O.S. Systems Software LTDA.

SUMMARY = "Italdes Flasher image"
LICENSE = "CLOSED"

inherit core-image

IMAGE_INSTALL_append = " \
                        ital-installer-gitrel \
                        ital-flash-service \
                        "
