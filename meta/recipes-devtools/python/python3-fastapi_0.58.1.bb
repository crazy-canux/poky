SUMMARY = "fastapi"
DESCRIPTION = "fastapi"
HOMEPAGE = "https://github.com/tiangolo/fastapi"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=95792ff3fe8e11aa49ceb247e66e4810"

inherit pypi setuptools3

SRC_URI[md5sum] = "31248dee05b7f81853ef66f385853ba1"
SRC_URI[sha256sum] = "92e59b77eef7d6eaa80b16d275adda06b5f33b12d777e3fc5521b2f7f4718e13"

RDEPENDS_${PN} += " \
    ${PYTHON_PN}-pydantic \
    ${PYTHON_PN}-starlette \
    ${PYTHON_PN}-aiofiles \
"


BBCLASSEXTEND = "native nativesdk"
