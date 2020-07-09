SUMMARY = "docker-compose"
LICENSE = "GPLv2 & Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=435b266b3899aa8a959f17d41c56def8"

SRC_URI[md5sum] = "a6f296957148e4c61b28fb324c27c966"
SRC_URI[sha256sum] = "7a2eb6d8173fdf408e505e6f7d497ac0b777388719542be9e49a0efd477a50c6"

inherit pypi setuptools3

RDEPENDS_${PN} += "\
    ${PYTHON_PN}-texttable \
    ${PYTHON_PN}-cached-property \
    ${PYTHON_PN}-dockerpty \
    ${PYTHON_PN}-pyyaml \
    ${PYTHON_PN}-six \
    ${PYTHON_PN}-jsonschema \
    ${PYTHON_PN}-requests \
    ${PYTHON_PN}-websocket-client \
    ${PYTHON_PN}-docker \
    ${PYTHON_PN}-docopt \
"

BBCLASSEXTEND = "native nativesdk"

