DESCRIPTION = "Libraries and applications to facilitate working with GPS data for research and high accuracy uses."
AUTHOR = "Applied Research Laboratories at The University of Texas at Austin (ARL:UT)."
HOMEPAGE = "http://www.gpstk.org/"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING.md;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "https://github.com/SGL-UT/GPSTk/archive/v${PV}.tar.gz"
SRC_URI[md5sum] = "040d3f28a20abf3b6a409103f830e15d"
SRC_URI[sha256sum] = "75aa04137b17b90a116700431b4170d0d423dca32374b4effbcfebe7b1c06017"
S="${WORKDIR}/GPSTk-${PV}"

inherit cmake

EXTRA_OECMAKE += " -DBUILD_EXT=OFF -DBUILD_PYTHON=OFF"

FILES_${PN} += " ${bindir}/* /usr/share/cmake/*"
