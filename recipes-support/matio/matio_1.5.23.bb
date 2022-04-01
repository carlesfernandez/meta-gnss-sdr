SUMMARY = "MATLAB MAT File I/O Library"
HOMEPAGE = "https://github.com/tbeu/matio"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=0af3a5e9b16370a321d36aa6acf4db59"
PR = "r1"

DEPENDS = "zlib hdf5"

SRC_URI = "gitsm://github.com/tbeu/matio.git;branch=master;protocol=https"
SRCREV = "e9e063e08ef2a27fcc22b1e526258fea5a5de329"
S = "${WORKDIR}/git"

inherit autotools pkgconfig

EXTRA_OECONF += "--enable-mat73=yes --with-default-file-ver=7.3"
