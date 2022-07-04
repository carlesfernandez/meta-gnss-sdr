SUMMARY = "The GPS Toolkit"
DESCRIPTION = "Libraries and applications to facilitate working with GPS data for research and high accuracy uses."
AUTHOR = "ARL:UT"
HOMEPAGE = "https://github.com/SGL-UT/gnsstk/"
PR = "r3"

LICENSE = "LGPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING.md;md5=d32239bcb673463ab874e80d47fae504"

GIT_BRANCH = "stable"
SRC_URI = "git://github.com/SGL-UT/gnsstk.git;branch=${GIT_BRANCH};protocol=https"
SRCREV = "7f4c840d21c7bac40c5d554bdaab386ba2ee59ef"
S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE += " -DCMAKE_SKIP_INSTALL_RPATH=ON -DCMAKE_SKIP_RPATH=ON -DUSE_RPATH=OFF -DBUILD_EXT=ON -DBUILD_PYTHON=OFF"

PACKAGES = "gpstk gpstk-dev gpstk-dbg"

FILES:${PN} += " ${bindir}/* "
FILES:${PN}-dev += " ${includedir}/* ${libdir}/* /usr/share/cmake/*"
FILES:${PN}-dbg += " \
     ${prefix}/src/debug/gpstk/* \
     ${bindir}/.debug/* \
"
