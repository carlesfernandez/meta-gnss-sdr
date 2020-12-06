SUMMARY = "Light-weight C++ XML Processing Library"
HOMEPAGE = "https://pugixml.org"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://readme.txt;md5=a631ae00f08e5904238e3a2653d66404"
PR = "r0"

SRC_URI = "https://github.com/zeux/pugixml/releases/download/v${PV}/pugixml-${PV}.tar.gz"
SRC_URI[md5sum] = "71c5fcf9d11b92e1ed751b31ffffbebb"
SRC_URI[sha256sum] = "9dce9f0a3756c5ab84ab7466c99972d030021d81d674f5d38b9e30e9a3ec4922"

DEPENDS = "cmake"

inherit cmake
EXTRA_OECMAKE = " -DBUILD_SHARED_LIBS=ON "

FILES_${PN}-dev += " \
	${libdir}/cmake \
"
