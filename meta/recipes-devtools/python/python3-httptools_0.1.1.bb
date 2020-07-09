SUMMARY = "gunicorn"
DESCRIPTION = "gunicorn"
HOMEPAGE = "http://gunicorn.org/"
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""
#LICENSE = "MIT"
#LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=da949adf3d15b1f52fbac5ca5ea882b4"

inherit pypi setuptools3

SRC_URI[md5sum] = "063a9b6f8c79cf5f11592e7a49715275"
SRC_URI[sha256sum] = "41b573cf33f64a8f8f3400d0a7faf48e1888582b6f6e02b82b9bd4f0bf7497ce"

BBCLASSEXTEND = "native nativesdk"
