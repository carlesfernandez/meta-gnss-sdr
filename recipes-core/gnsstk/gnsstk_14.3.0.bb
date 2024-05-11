SUMMARY = "GNSSTk C++ Library"
DESCRIPTION = "The goal of the gnsstk project is to provide an open source library to the satellite navigation community--to free researchers to focus on research, not lower level coding."
AUTHOR = "ARL:UT"
HOMEPAGE = "https://github.com/SGL-UT/gnsstk"
PR = "r0"

LICENSE = "LGPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING.md;md5=d32239bcb673463ab874e80d47fae504"

GIT_BRANCH = "stable"
SRC_URI = "git://github.com/SGL-UT/gnsstk.git;branch=${GIT_BRANCH};protocol=https \
          file://0001-Patch-for-GCC13.patch \
          "
SRCREV = "fe45a3933ddbdc82d28900897ed43fe989c6dfae"
S = "${WORKDIR}/git"
RDEPENDS:${PN} = "bash"
inherit cmake

EXTRA_OECMAKE += " -DCMAKE_SKIP_INSTALL_RPATH=ON -DCMAKE_SKIP_RPATH=ON -DUSE_RPATH=OFF -DBUILD_EXT=ON -DBUILD_PYTHON=OFF"

PACKAGES = "gnsstk gnsstk-dev gnsstk-dbg"

FILES:${PN} += " ${bindir}/* "
FILES:${PN}-dev += " ${includedir}/* ${libdir}/* /usr/share/cmake/*"
FILES:${PN}-dbg += " \
     ${prefix}/src/debug/gnsstk/* \
     ${bindir}/.debug/* \
"