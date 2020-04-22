SUMMARY = "C++ linear algebra library"
HOMEPAGE = "http://arma.sourceforge.net/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=d273d63619c9aeaf15cdaf76422c4f87"
SRC_URI = "http://sourceforge.net/projects/arma/files/armadillo-${PV}.tar.xz"

SRC_URI[md5sum] = "4a22f3f3551259ba7416f585b19fc515"
SRC_URI[sha256sum] = "1603888ab73b7f0588df1a37a464436eb0ff6b1372a9962ee1424b4329f165a9"

EXTRA_OECMAKE += " -DBUILD_SHARED_LIBS=ON"
DEPENDS += " lapack "
inherit cmake

FILES_${PN}-dev += " \
  /usr/share/Armadillo/CMake/ArmadilloLibraryDepends-noconfig.cmake \
  /usr/share/Armadillo/CMake/ArmadilloLibraryDepends.cmake \
  /usr/share/Armadillo/CMake/ArmadilloConfig.cmake \
  /usr/share/Armadillo/CMake/ArmadilloConfigVersion.cmake \
"
