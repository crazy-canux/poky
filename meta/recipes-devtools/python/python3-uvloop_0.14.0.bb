SUMMARY = "gunicorn"
DESCRIPTION = "gunicorn"
HOMEPAGE = "http://gunicorn.org/"
SECTION = "devel/python"

LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""
#LICENSE = "MIT"
#LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=b8f45734454c1d1b5731ee98b3d16f53"

inherit pypi setuptools3

DEPENDS += "${PYTHON_PN}-setuptools-native ${PYTHON_PN}-cython-native ${PYTHON_PN}"

SRC_URI[md5sum] = "a2f82abb676756f11f544c6b51caf171"
SRC_URI[sha256sum] = "123ac9c0c7dd71464f58f1b4ee0bbd81285d96cdda8bc3519281b8973e3a461e"

# set use-system-libuv to use local libuv.
# compile libuv from source.
do_compile_prepend() {
    export LIBUV_CONFIGURE_HOST=${HOST_SYS}
}

do_install_prepend() {
    export LIBUV_CONFIGURE_HOST=${HOST_SYS}
}

BBCLASSEXTEND = "native nativesdk"
