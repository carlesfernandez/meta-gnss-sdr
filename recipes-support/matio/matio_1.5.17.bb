SUMMARY = "MATLAB MAT File I/O Library"
HOMEPAGE = "http://matio.sf.net"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=02cdf1821aecbae99f76cff331b71285"

DEPENDS = "zlib hdf5"

SRC_URI = "https://github.com/tbeu/matio/archive/v${PV}.tar.gz"
SRC_URI[md5sum] = "1104009262b22a426f95c46859688f3b"
SRC_URI[sha256sum] = "4b8e9d65545ec9caf54765c476f534970cdf668e40e7d17b33cd489328e0b02a"

S = "${WORKDIR}/${PN}-${PV}"

inherit autotools

EXTRA_OECONF += "--enable-mat73=yes --with-default-file-ver=7.3"
