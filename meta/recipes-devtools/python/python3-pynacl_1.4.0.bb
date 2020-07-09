SUMMARY = "Good password hashing for your software and your servers"
HOMEPAGE = "https://github.com/pyca/bcrypt/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8cc789b082b3d97e1ccc5261f8594d3f"

inherit pypi setuptools3

PYPI_PACKAGE = "PyNaCl"

DEPENDS += " \
        libsodium \
        ${PYTHON_PN} \
        ${PYTHON_PN}-cython-native \
        ${PYTHON_PN}-wheel-native \
        ${PYTHON_PN}-cffi-native \
        ${PYTHON_PN}-six \
        ${PYTHON_PN}-pycparser \
        "

SRC_URI[md5sum] = "8c6c57893327a694c72510fb620e4744"
SRC_URI[sha256sum] = "54e9a2c849c742006516ad56a88f5c74bf2ce92c9f67435187c3c5953b346505"

RDEPENDS_${PN} += "\
    ${PYTHON_PN}-cffi \
    ${PYTHON_PN}-six \
    ${PYTHON_PN}-pycparser \
"

# use libsodium on system instead of compile from source.
export SODIUM_INSTALL="system"

BBCLASSEXTEND = "native nativesdk"

