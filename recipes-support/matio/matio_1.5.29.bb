SUMMARY = "MATLAB MAT File I/O Library"
HOMEPAGE = "https://github.com/tbeu/matio"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=9d9dce8b2ae887cf64af04913523847c"
PR = "r0"

DEPENDS = "zlib hdf5"

SRC_URI = "gitsm://github.com/tbeu/matio.git;branch=master;protocol=https"
SRCREV = "9a032693865af286a1ebb1bb0a0fac726553dea3"

inherit autotools pkgconfig

EXTRA_OECONF += "--enable-mat73=yes --with-default-file-ver=7.3"