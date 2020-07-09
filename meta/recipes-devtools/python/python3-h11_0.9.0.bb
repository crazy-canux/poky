SUMMARY = "gunicorn"
DESCRIPTION = "gunicorn"
HOMEPAGE = "http://gunicorn.org/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=f5501d19c3116f4aaeef89369f458693"

inherit pypi setuptools3

SRC_URI[md5sum] = "53affae306153388512040e038519fa3"
SRC_URI[sha256sum] = "33d4bca7be0fa039f4e84d50ab00531047e53d6ee8ffbc83501ea602c169cae1"

BBCLASSEXTEND = "native nativesdk"
