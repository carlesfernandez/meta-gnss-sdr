SUMMARY = "C++ linear algebra library"
HOMEPAGE = "https://arma.sourceforge.net/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=d273d63619c9aeaf15cdaf76422c4f87"
PR = "r0"

SRC_URI = "https://sourceforge.net/projects/arma/files/armadillo-${PV}.tar.xz"

SRC_URI[md5sum] = "abb97193a856b6223ef6ef1b297efe21"
SRC_URI[sha256sum] = "023242fd59071d98c75fb015fd3293c921132dc39bf46d221d4b059aae8d79f4"

# FIXME: Build paths are currently embedded
INSANE_SKIP:${PN}-dev += "buildpaths"

EXTRA_OECMAKE += " -DBUILD_SHARED_LIBS=ON"
DEPENDS = "lapack"
inherit cmake

FILES:${PN}-dev += " \
  ${datadir}/Armadillo/CMake/ArmadilloLibraryDepends-noconfig.cmake \
  ${datadir}/Armadillo/CMake/ArmadilloLibraryDepends.cmake \
  ${datadir}/Armadillo/CMake/ArmadilloConfig.cmake \
  ${datadir}/Armadillo/CMake/ArmadilloConfigVersion.cmake \
"