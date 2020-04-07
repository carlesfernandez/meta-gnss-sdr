DESCRIPTION = "Libraries and applications to facilitate working with GPS data for research and high accuracy uses."
AUTHOR = "ARL:UT"
HOMEPAGE = "https://github.com/SGL-UT/GPSTk/"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING.md;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "https://github.com/SGL-UT/GPSTk/archive/v${PV}.tar.gz"
SRC_URI[md5sum] = "b085879c4b4197e4d01e90f83352e6cd"
SRC_URI[sha256sum] = "fe45c79537d263eb145623c456a0d0bf79acd0ac8dd79136d6b5610aa26055e4"
S="${WORKDIR}/GPSTk-${PV}"

inherit cmake

EXTRA_OECMAKE += " -DCMAKE_SKIP_INSTALL_RPATH=ON -DCMAKE_SKIP_RPATH=ON -DBUILD_EXT=OFF -DBUILD_PYTHON=OFF"

PACKAGE = "gpstk"

FILES_${PN} += " ${bindir}/* /usr/share/cmake/*"
