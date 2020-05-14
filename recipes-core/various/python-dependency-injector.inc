DESCRIPTION = ""
HOMEPAGE = ""
LICENSE = "Apache-2.0 & (EPL-1.0 | EDL-1.0)"
#LICENSE_${PN}-examples = "Apache-2.0"
LIC_FILES_CHKSUM = "\
    file://LICENSE.rst;md5=774515eda08e9dd9a55802496bb0a6f3 \
"

SRC_URI[md5sum] = "bd1d50ae108a708e3ddd1ca658239f27"
SRC_URI[sha256sum] = "fcca1464f567d902983bff507b9e2e3fda0f932ee009e36f74ed5b8c348d17f4"

inherit pypi

PYPI_PACKAGE = "dependency-injector"


#RDEPENDS_${PN} += " \
#"

