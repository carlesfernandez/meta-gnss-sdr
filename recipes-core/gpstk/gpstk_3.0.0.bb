SUMMARY = "The GPS Toolkit"
DESCRIPTION = "Libraries and applications to facilitate working with GPS data for research and high accuracy uses."
AUTHOR = "ARL:UT"
HOMEPAGE = "https://github.com/SGL-UT/GPSTk/"

LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING.md;md5=d32239bcb673463ab874e80d47fae504"
PR = "r0"

SRC_URI = "git://github.com/SGL-UT/GPSTk.git;protocol=https "
SRCREV = "f8febf70861ecfae83ba72bf5b68ff760d0f9c45"
S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE += " -DCMAKE_SKIP_INSTALL_RPATH=ON -DCMAKE_SKIP_RPATH=ON -DBUILD_EXT=OFF -DBUILD_PYTHON=OFF"

PACKAGE = "gpstk"

FILES_${PN} += " ${bindir}/* /usr/share/cmake/*"
