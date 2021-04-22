SUMMARY = "MATLAB MAT File I/O Library"
HOMEPAGE = "https://github.com/tbeu/matio"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=352bc9adeed66238671fddfbae91e5d6"
PR = "r1"

DEPENDS = "zlib hdf5"

SRC_URI = "gitsm://github.com/tbeu/matio.git"
SRCREV = "8e18058117fcf177d236e68d453d04e20f937598"
S = "${WORKDIR}/git"

inherit autotools

EXTRA_OECONF += "--enable-mat73=yes --with-default-file-ver=7.3"
