SUMMARY = "C++ linear algebra library"
HOMEPAGE = "http://arma.sourceforge.net/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=d273d63619c9aeaf15cdaf76422c4f87"
SRC_URI = "http://sourceforge.net/projects/arma/files/armadillo-${PV}.tar.xz"

SRC_URI[md5sum] = "c601f3a5ec6d50666aa3a539fa20e6ca"
SRC_URI[sha256sum] = "efd70600ab6f30449d90a3e58ff7499937985209bb0a03ce4e322474dbf11fe3"

EXTRA_OECMAKE += " -DBUILD_SHARED_LIBS=ON"
DEPENDS += " lapack "
inherit cmake

FILES_${PN}-dev += " \
  /usr/share/Armadillo/CMake/ArmadilloLibraryDepends-noconfig.cmake \
  /usr/share/Armadillo/CMake/ArmadilloLibraryDepends.cmake \
  /usr/share/Armadillo/CMake/ArmadilloConfig.cmake \
  /usr/share/Armadillo/CMake/ArmadilloConfigVersion.cmake \
"
