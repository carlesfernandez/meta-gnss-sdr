SUMMARY = "Light-weight C++ XML Processing Library"
HOMEPAGE = "https://pugixml.org"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://readme.txt;md5=a631ae00f08e5904238e3a2653d66404"
PR = "r0"

SRC_URI = "https://github.com/zeux/pugixml/releases/download/v${PV}/pugixml-${PV}.tar.gz"
SRC_URI[md5sum] = "2d0be30b843eb9d1893c1ba9ad334946"
SRC_URI[sha256sum] = "599eabdf8976aad86ac092a198920d8c127623d1376842bc6d683b12a37fb74f"

DEPENDS = "cmake"

inherit cmake
EXTRA_OECMAKE = " -DBUILD_SHARED_LIBS=ON "

FILES_${PN}-dev += " \
	${libdir}/cmake \
"
