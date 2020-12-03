SUMMARY = "Light-weight C++ XML Processing Library"
HOMEPAGE = "https://pugixml.org"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://readme.txt;md5=60de230cb0033dcc89dd409e289a827d"
PR = "r0"

SRC_URI = "https://github.com/zeux/pugixml/releases/download/v${PV}/pugixml-${PV}.tar.gz"
SRC_URI[md5sum] = "93540f4644fd4e4b02049554ef37fb90"
SRC_URI[sha256sum] = "26913d3e63b9c07431401cf826df17ed832a20d19333d043991e611d23beaa2c"

DEPENDS = "cmake"

inherit cmake
EXTRA_OECMAKE = " -DBUILD_SHARED_LIBS=ON "

FILES_${PN}-dev += " \
	${libdir}/cmake \
"
