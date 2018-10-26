SUMMARY = "MATLAB MAT File I/O Library"
HOMEPAGE = "http://matio.sf.net"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=02cdf1821aecbae99f76cff331b71285"

DEPENDS = "zlib hdf5"

SRC_URI = "https://github.com/tbeu/matio/archive/v${PV}.tar.gz"
SRC_URI[md5sum] = "010f48bfe11a612856b7b672151099d6"
SRC_URI[sha256sum] = "42e3f7d4f828d0eff51a152c4af65662f4970e4198c7e8035a5811e9fecbc8a5"

S = "${WORKDIR}/${PN}-${PV}"

inherit autotools

EXTRA_OECONF += "--enable-mat73=yes --with-default-file-ver=7.3"
