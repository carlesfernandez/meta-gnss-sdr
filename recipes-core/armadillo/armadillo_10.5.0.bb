SUMMARY = "C++ linear algebra library"
HOMEPAGE = "http://arma.sourceforge.net/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=d273d63619c9aeaf15cdaf76422c4f87"
PR = "r0"

SRC_URI = "https://sourceforge.net/projects/arma/files/armadillo-${PV}.tar.xz"

SRC_URI[md5sum] = "5029ca015833240ce531ca6c6ba5b263"
SRC_URI[sha256sum] = "ea990c34dc6d70d7c95b4354d9f3b0819bde257dbb67796348e91e196082cb87"

EXTRA_OECMAKE += " -DBUILD_SHARED_LIBS=ON -DDETECT_HDF5=OFF"
DEPENDS = "lapack"
inherit cmake

FILES_${PN}-dev += " \
  ${datadir}/Armadillo/CMake/ArmadilloLibraryDepends-noconfig.cmake \
  ${datadir}/Armadillo/CMake/ArmadilloLibraryDepends.cmake \
  ${datadir}/Armadillo/CMake/ArmadilloConfig.cmake \
  ${datadir}/Armadillo/CMake/ArmadilloConfigVersion.cmake \
"
