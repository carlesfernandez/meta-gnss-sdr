SUMMARY = "Light-weight C++ XML Processing Library"
HOMEPAGE = "https://pugixml.org"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://readme.txt;md5=a631ae00f08e5904238e3a2653d66404"
PR = "r1"

SRC_URI = "https://github.com/zeux/pugixml/releases/download/v${PV}/pugixml-${PV}.tar.gz"
SRC_URI[md5sum] = "2d2730d3412b08d3e70c795bc17003df"
SRC_URI[sha256sum] = "8ddf57b65fb860416979a3f0640c2ad45ddddbbafa82508ef0a0af3ce7061716"

inherit cmake

EXTRA_OECMAKE += "-DBUILD_PKGCONFIG=ON \
                  -DBUILD_SHARED_LIBS=ON \
                  -DCMAKE_BUILD_TYPE=Release \
                  "

FILES:${PN}-dev += " \
	${libdir}/cmake \
"

BBCLASSEXTEND = "native nativesdk"
