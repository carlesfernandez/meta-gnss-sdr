SUMMARY = "C++ linear algebra library"
HOMEPAGE = "http://arma.sourceforge.net/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=d273d63619c9aeaf15cdaf76422c4f87"
SRC_URI = "http://sourceforge.net/projects/arma/files/armadillo-${PV}.tar.xz"

<<<<<<< HEAD:recipes-core/armadillo/armadillo_9.900.1.bb
SRC_URI[md5sum] = "18853ae13ef0996a558847b5128a840a"
SRC_URI[sha256sum] = "53d7ad6124d06fdede8d839c091c649c794dae204666f1be0d30d7931737d635"
=======
GIT_BRANCH = "9.900.x"
SRC_URI = "git://gitlab.com/conradsnicta/armadillo-code.git;branch=${GIT_BRANCH};protocol=https "
SRCREV = "31743403deee1f333fed91cde4f59f5403552e28"
S = "${WORKDIR}/git"
>>>>>>> 4c0d5f5... Update Armadillo receipt:recipes-core/armadillo/armadillo_9.900.x.bb

EXTRA_OECMAKE += " -DBUILD_SHARED_LIBS=ON"
DEPENDS += " lapack "
inherit cmake

FILES_${PN}-dev += " \
  /usr/share/Armadillo/CMake/ArmadilloLibraryDepends-noconfig.cmake \
  /usr/share/Armadillo/CMake/ArmadilloLibraryDepends.cmake \
  /usr/share/Armadillo/CMake/ArmadilloConfig.cmake \
  /usr/share/Armadillo/CMake/ArmadilloConfigVersion.cmake \
"
