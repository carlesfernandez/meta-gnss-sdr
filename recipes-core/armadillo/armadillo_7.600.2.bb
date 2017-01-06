SUMMARY = "C++ linear algebra library"
HOMEPAGE = "http://arma.sourceforge.net/"
LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=cfd7d66d2864c38232ec1ef20b27c13a"
SRC_URI = "http://sourceforge.net/projects/arma/files/armadillo-${PV}.tar.xz"

SRC_URI[md5sum] = "8dee8bc37f7cb29323c20c4104126b5c"
SRC_URI[sha256sum] = "6790d5e6b41fcac6733632a9c3775239806d00178886226dec3f986a884f4c2d"

inherit cmake

FILES_${PN}-dev += " \
  /usr/share/Armadillo/CMake/ArmadilloLibraryDepends-noconfig.cmake \
  /usr/share/Armadillo/CMake/ArmadilloLibraryDepends.cmake \
  /usr/share/Armadillo/CMake/ArmadilloConfig.cmake \
  /usr/share/Armadillo/CMake/ArmadilloConfigVersion.cmake \
"
