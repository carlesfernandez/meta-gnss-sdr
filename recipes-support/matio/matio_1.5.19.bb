SUMMARY = "MATLAB MAT File I/O Library"
HOMEPAGE = "http://matio.sf.net"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=f74f7e7d96fb67c374e28579f866ab34"
PR = "r1"

DEPENDS = "zlib hdf5"

SRC_URI = "gitsm://github.com/tbeu/matio.git"
SRCREV = "ca56394e5672115df1981996ed12524d1d551259"
S = "${WORKDIR}/git"

inherit autotools

EXTRA_OECONF += "--enable-mat73=yes --with-default-file-ver=7.3"
