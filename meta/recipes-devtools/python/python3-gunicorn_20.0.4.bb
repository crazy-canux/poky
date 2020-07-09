SUMMARY = "gunicorn"
DESCRIPTION = "gunicorn"
HOMEPAGE = "http://gunicorn.org/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f75f3fb94cdeab1d607e2adaa6077752"

inherit pypi setuptools3

SRC_URI[md5sum] = "543669fcbb5739ee2af77184c5e571a1"
SRC_URI[sha256sum] = "1904bb2b8a43658807108d59c3f3d56c2b6121a701161de0ddf9ad140073c626"

BBCLASSEXTEND = "native nativesdk"
