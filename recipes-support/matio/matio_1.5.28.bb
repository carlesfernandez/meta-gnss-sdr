SUMMARY = "MATLAB MAT File I/O Library"
HOMEPAGE = "https://github.com/tbeu/matio"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=34985bae1a265d9bf53226089cd74566"
PR = "r0"

DEPENDS = "zlib hdf5"

SRC_URI = "gitsm://github.com/tbeu/matio.git;branch=master;protocol=https"
SRCREV = "4677b3fd4030c52e0fe45a863c840c78fb56f9a3"
S = "${WORKDIR}/git"

inherit autotools pkgconfig

EXTRA_OECONF += "--enable-mat73=yes --with-default-file-ver=7.3"