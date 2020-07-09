SUMMARY = "A pure Python netlink and Linux network configuration library"
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""
#LICENSE = "GPLv2 & Apache-2.0"
#LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=26ea08883a46db00c3d71de3c96e43cc"

SRC_URI[md5sum] = "98ee55f239bf8f2d002915d76b416c22"
SRC_URI[sha256sum] = "61b23850ad5d917436aa73c2847ab941bc0edbe79a324b0eebdb98af0b65b10d"

inherit pypi

BBCLASSEXTEND = "native nativesdk"
