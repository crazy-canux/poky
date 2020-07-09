SUMMARY = "Provides cryptographic recipes and primitives to python developers"
HOMEPAGE = "https://cryptography.io/"
#LICENSE = "Apache-2.0 | BSD"
#LIC_FILES_CHKSUM = "file://LICENSE;md5=097f805837700cfac572ac274cd38124"
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

inherit pypi setuptools3
#inherit ptest

LDSHARED += "-pthread"

SRC_URI[md5sum] = "89f355fd2500f7b7ce13999afc7cd092"
SRC_URI[sha256sum] = "a0c30272fb4ddda5f5ffc1089d7405b7a71b0b0f51993cb4e5dbb4590b2fc229"

#SRC_URI += " \
#    file://run-ptest \
#"

DEPENDS += " \
    ${PYTHON_PN}-cffi \
    ${PYTHON_PN}-cffi-native \
    ${PYTHON_PN}-asn1crypto \
    ${PYTHON_PN}-six \
"

RDEPENDS_${PN} += " \
    ${PYTHON_PN}-cffi \
    ${PYTHON_PN}-idna \
    ${PYTHON_PN}-asn1crypto \
    ${PYTHON_PN}-pycparser \
    ${PYTHON_PN}-setuptools \
    ${PYTHON_PN}-six \
"

RDEPENDS_${PN}_class-target += " \
    ${PYTHON_PN}-cffi \
    ${PYTHON_PN}-idna \
    ${PYTHON_PN}-numbers \
    ${PYTHON_PN}-asn1crypto \
    ${PYTHON_PN}-pycparser \
    ${PYTHON_PN}-setuptools \
    ${PYTHON_PN}-six \
    ${PYTHON_PN}-threading \
"

RDEPENDS_${PN}-ptest += " \
    ${PN} \
    ${PYTHON_PN}-cryptography-vectors \
    ${PYTHON_PN}-iso8601 \
    ${PYTHON_PN}-pretend \
    ${PYTHON_PN}-pytest \
    ${PYTHON_PN}-pytz \
"

#do_install_ptest() {
#    install -d ${D}${PTEST_PATH}/tests
#    cp -rf ${S}/tests/* ${D}${PTEST_PATH}/tests/
#    install -d ${D}${PTEST_PATH}/tests/hazmat
#    cp -rf ${S}/tests/hazmat/* ${D}${PTEST_PATH}/tests/hazmat/
#}

#FILES_${PN}-dbg += " \
#    ${libdir}/${PYTHON_PN}2.7/site-packages/${SRCNAME}/hazmat/bindings/.debug \
#"

BBCLASSEXTEND = "native nativesdk"
