SUMMARY = "MATLAB MAT File I/O Library"
HOMEPAGE = "http://matio.sf.net"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=bf0b2b75650fd711c8cca1fa7cd70503"

DEPENDS = "zlib hdf5"

SRC_URI = "gitsm://github.com/tbeu/matio.git"
SRCREV = "64f793668e09216029447990702c145403d14375"
S = "${WORKDIR}/git"

inherit autotools

EXTRA_OECONF += "--enable-mat73=yes --with-default-file-ver=7.3"
