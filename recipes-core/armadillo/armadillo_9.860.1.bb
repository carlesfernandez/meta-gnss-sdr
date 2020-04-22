SUMMARY = "C++ linear algebra library"
HOMEPAGE = "http://arma.sourceforge.net/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=d273d63619c9aeaf15cdaf76422c4f87"

SRC_URI = "git://gitlab.com/conradsnicta/armadillo-code"
SRCREV = "7f198df15e86699d99e28cab5cba18906728cae3"
S = "${WORKDIR}/git"

EXTRA_OECMAKE += " -DBUILD_SHARED_LIBS=ON"
DEPENDS += " lapack "
inherit cmake

FILES_${PN}-dev += " \
  /usr/share/Armadillo/CMake/ArmadilloLibraryDepends-noconfig.cmake \
  /usr/share/Armadillo/CMake/ArmadilloLibraryDepends.cmake \
  /usr/share/Armadillo/CMake/ArmadilloConfig.cmake \
  /usr/share/Armadillo/CMake/ArmadilloConfigVersion.cmake \
"
