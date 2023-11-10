SUMMARY = "MATLAB MAT File I/O Library"
HOMEPAGE = "https://github.com/tbeu/matio"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=a131b7bed5a9df7a654b4bbc3dc781c8"
PR = "r0"

DEPENDS = "zlib hdf5"

SRC_URI = "gitsm://github.com/tbeu/matio.git;branch=master;protocol=https"
SRCREV = "5bc74f03d69fe700ad590b9243f0e0a3ef4949ed"
S = "${WORKDIR}/git"

inherit autotools pkgconfig

EXTRA_OECONF += "--enable-mat73=yes --with-default-file-ver=7.3"