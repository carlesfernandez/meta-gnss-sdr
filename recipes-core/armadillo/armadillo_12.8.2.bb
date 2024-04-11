SUMMARY = "C++ linear algebra library"
HOMEPAGE = "https://arma.sourceforge.net/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=d273d63619c9aeaf15cdaf76422c4f87"
PR = "r0"

SRC_URI = "https://sourceforge.net/projects/arma/files/armadillo-${PV}.tar.xz"

SRC_URI[md5sum] = "c33b4eb1cd593d2449db3e17235c84a0"
SRC_URI[sha256sum] = "03b62f8c09e4f5d74643b478520741b8e27b55e7e4525978fcae2f5d791ac3bf"


EXTRA_OECMAKE += " -DBUILD_SHARED_LIBS=ON"
DEPENDS = "lapack"
inherit cmake

FILES:${PN}-dev += " \
  ${datadir}/Armadillo/CMake/ArmadilloLibraryDepends-noconfig.cmake \
  ${datadir}/Armadillo/CMake/ArmadilloLibraryDepends.cmake \
  ${datadir}/Armadillo/CMake/ArmadilloConfig.cmake \
  ${datadir}/Armadillo/CMake/ArmadilloConfigVersion.cmake \
"