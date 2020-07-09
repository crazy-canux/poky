SUMMARY = "gunicorn"
DESCRIPTION = "gunicorn"
HOMEPAGE = "http://gunicorn.org/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=206119e27d6b034e7ce70d73063c82a8"

inherit pypi setuptools3

SRC_URI[md5sum] = "9f82b3674ced119596afe3b7b977f82c"
SRC_URI[sha256sum] = "596eaa8645b6dbc24d6610e335f8ddf5f925b4c4b86fdc7146abb0bf0da65d17"

RDEPENDS_${PN} += " \
    ${PYTHON_PN}-click \
    ${PYTHON_PN}-h11 \
    ${PYTHON_PN}-uvloop \
    ${PYTHON_PN}-websockets \
    ${PYTHON_PN}-httptools \
"

BBCLASSEXTEND = "native nativesdk"
