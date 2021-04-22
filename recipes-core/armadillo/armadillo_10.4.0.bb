SUMMARY = "C++ linear algebra library"
HOMEPAGE = "http://arma.sourceforge.net/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=d273d63619c9aeaf15cdaf76422c4f87"
PR = "r2"

SRC_URI = "http://sourceforge.net/projects/arma/files/armadillo-${PV}.tar.xz"

SRC_URI[md5sum] = "9479b5ec68c0cc6b56abb0fbbd590faa"
SRC_URI[sha256sum] = "a2540f1f8ee1991ba1b14941daa3986fb774484fc678978d4d00bba87360102e"

EXTRA_OECMAKE += " -DBUILD_SHARED_LIBS=ON -DDETECT_HDF5=OFF"
DEPENDS = "lapack"
inherit cmake

FILES_${PN}-dev += " \
  ${datadir}/Armadillo/CMake/ArmadilloLibraryDepends-noconfig.cmake \
  ${datadir}/Armadillo/CMake/ArmadilloLibraryDepends.cmake \
  ${datadir}/Armadillo/CMake/ArmadilloConfig.cmake \
  ${datadir}/Armadillo/CMake/ArmadilloConfigVersion.cmake \
"
