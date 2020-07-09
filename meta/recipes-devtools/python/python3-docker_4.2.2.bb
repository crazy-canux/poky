SUMMARY = "A Python library for the Docker Engine API."
HOMEPAGE = "https://github.com/docker/docker-py"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=34f3846f940453127309b920eeb89660"

SRC_URI[md5sum] = "9028336105468b7869a91d50e76f88f9"
SRC_URI[sha256sum] = "26eebadce7e298f55b76a88c4f8802476c5eaddbdbe38dbc6cce8781c47c9b54"

DEPENDS += "${PYTHON_PN}-pip-native"

inherit pypi setuptools3

RDEPENDS_${PN} += "\
    ${PYTHON_PN}-six \
    ${PYTHON_PN}-misc \
    ${PYTHON_PN}-docker-pycreds \
    ${PYTHON_PN}-websocket-client \
    ${PYTHON_PN}-requests \
"

BBCLASSEXTEND = "native nativesdk"

