SUMMARY = "Light-weight C++ XML Processing Library"
HOMEPAGE = "https://pugixml.org"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://readme.txt;md5=60de230cb0033dcc89dd409e289a827d"
PR = "r0"

SRC_URI = "https://github.com/zeux/pugixml/releases/download/v${PV}/pugixml-${PV}.tar.gz"
SRC_URI[md5sum] = "f97237e9908201c6d8536210747b66af"
SRC_URI[sha256sum] = "55f399fbb470942410d348584dc953bcaec926415d3462f471ef350f29b5870a"

DEPENDS = "cmake"

inherit cmake
EXTRA_OECMAKE = " -DBUILD_SHARED_LIBS=ON "

FILES_${PN}-dev += " \
	${libdir}/cmake \
"
