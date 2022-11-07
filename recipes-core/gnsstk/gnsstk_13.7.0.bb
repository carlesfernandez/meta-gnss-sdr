SUMMARY = "GNSSTk C++ Library"
DESCRIPTION = "The goal of the gnsstk project is to provide an open source library to the satellite navigation community--to free researchers to focus on research, not lower level coding."
AUTHOR = "ARL:UT"
HOMEPAGE = "https://github.com/SGL-UT/gnsstk"
PR = "r0"

LICENSE = "LGPLv3"
LIC_FILES_CHKSUM = "file://COPYING.md;md5=d32239bcb673463ab874e80d47fae504"

GIT_BRANCH = "stable"
SRC_URI = "git://github.com/SGL-UT/gnsstk.git;branch=${GIT_BRANCH};protocol=https"
SRCREV = "90eb02cd63c342e01c375dfc0fca8cecdf91162e"
S = "${WORKDIR}/git"
RDEPENDS_${PN} = "bash"
inherit cmake

EXTRA_OECMAKE += " -DCMAKE_SKIP_INSTALL_RPATH=ON -DCMAKE_SKIP_RPATH=ON -DUSE_RPATH=OFF -DBUILD_EXT=ON -DBUILD_PYTHON=OFF"

PACKAGES = "gnsstk gnsstk-dev gnsstk-dbg"

FILES_${PN} += " ${bindir}/* "
FILES_${PN}-dev += " ${includedir}/* ${libdir}/* /usr/share/cmake/*"
FILES_${PN}-dbg += " \
     ${prefix}/src/debug/gnsstk/* \
     ${bindir}/.debug/* \
"
