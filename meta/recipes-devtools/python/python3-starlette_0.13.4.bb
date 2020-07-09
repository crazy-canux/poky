SUMMARY = "fastapi"
DESCRIPTION = "fastapi"
HOMEPAGE = "https://github.com/tiangolo/fastapi"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=11e8c8dbfd5fa373c703de492140ff7a"

inherit pypi setuptools3

SRC_URI[md5sum] = "888aa6af0a42e5d1f2aeea4941e8102d"
SRC_URI[sha256sum] = "04fe51d86fd9a594d9b71356ed322ccde5c9b448fc716ac74155e5821a922f8d"

BBCLASSEXTEND = "native nativesdk"
