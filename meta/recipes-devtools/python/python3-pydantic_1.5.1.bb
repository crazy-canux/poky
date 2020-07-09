SUMMARY = "fastapi"
DESCRIPTION = "fastapi"
HOMEPAGE = "https://github.com/tiangolo/fastapi"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=215ca7f54cdc98f95ee96c7511d64158"

inherit pypi setuptools3

SRC_URI[md5sum] = "866774950cb506f15c309875b7297240"
SRC_URI[sha256sum] = "f0018613c7a0d19df3240c2a913849786f21b6539b9f23d85ce4067489dfacfa"

BBCLASSEXTEND = "native nativesdk"
