DESCRIPTION = "Libraries and applications to facilitate working with GPS data for research and high accuracy uses."
AUTHOR = "Applied Research Laboratories at The University of Texas at Austin (ARL:UT)."
HOMEPAGE = "http://www.gpstk.org/"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING.md;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "https://github.com/SGL-UT/GPSTk/archive/v${PV}.tar.gz"
SRC_URI[md5sum] = "5d4ccd7995b0fe472f7f26733b0394b4"
SRC_URI[sha256sum] = "6977b136ff6639c7771c7eb2164bfaef101b7a706ddf281cc203f325ede3fc3c"
S="${WORKDIR}/GPSTk-${PV}"

inherit cmake

EXTRA_OECMAKE += " -DBUILD_EXT=OFF -DBUILD_PYTHON=OFF"

FILES_${PN} += " ${bindir}/* /usr/share/cmake/*"
