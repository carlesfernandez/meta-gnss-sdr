SUMMARY = "Light-weight C++ XML Processing Library"
HOMEPAGE = "https://pugixml.org"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://readme.txt;md5=541223080e6b4f0b05f2dbfaa3d222a2"
PR = "r1"

SRC_URI = "https://github.com/zeux/pugixml/releases/download/v${PV}/pugixml-${PV}.tar.gz"
SRC_URI[md5sum] = "3e4c588e03bdca140844f3c47c1a995e"
SRC_URI[sha256sum] = "40c0b3914ec131485640fa57e55bf1136446026b41db91c1bef678186a12abbe"

inherit cmake

EXTRA_OECMAKE += "-DBUILD_PKGCONFIG=ON \
                  -DBUILD_SHARED_LIBS=ON \
                  -DCMAKE_BUILD_TYPE=Release \
                  "

FILES:${PN}-dev += " \
	${libdir}/cmake \
"

BBCLASSEXTEND = "native nativesdk"