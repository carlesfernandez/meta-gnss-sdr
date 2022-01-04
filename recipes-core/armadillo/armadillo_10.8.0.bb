SUMMARY = "C++ linear algebra library"
HOMEPAGE = "http://arma.sourceforge.net/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=d273d63619c9aeaf15cdaf76422c4f87"
PR = "r0"

SRC_URI = "https://sourceforge.net/projects/arma/files/armadillo-${PV}.tar.xz"

SRC_URI[md5sum] = "bd1e5146b23d6666c0f3e716afaf7d74"
SRC_URI[sha256sum] = "7c5d2fd4bba095733829f7fe03d4a74e732b81c75dd4d40001163487c967d5bc"

EXTRA_OECMAKE += " -DBUILD_SHARED_LIBS=ON"
DEPENDS = "lapack"
inherit cmake

FILES_${PN}-dev += " \
  ${datadir}/Armadillo/CMake/ArmadilloLibraryDepends-noconfig.cmake \
  ${datadir}/Armadillo/CMake/ArmadilloLibraryDepends.cmake \
  ${datadir}/Armadillo/CMake/ArmadilloConfig.cmake \
  ${datadir}/Armadillo/CMake/ArmadilloConfigVersion.cmake \
"
