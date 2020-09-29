SUMMARY = "MATLAB MAT File I/O Library"
HOMEPAGE = "http://matio.sf.net"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=f74f7e7d96fb67c374e28579f866ab34"
PR = "r1"

DEPENDS = "zlib hdf5"

SRC_URI = "gitsm://github.com/tbeu/matio.git"
SRCREV = "882178d3943b815d47084a8f19e55797b1580ad3"
S = "${WORKDIR}/git"

inherit autotools

EXTRA_OECONF += "--enable-mat73=yes --with-default-file-ver=7.3"
