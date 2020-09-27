SUMMARY = "Light-weight C++ XML Processing Library"
HOMEPAGE = "https://pugixml.org"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://readme.txt;beginline=33;endline=52;md5=0e7d05454930d4a0ddbc582254c6cba2"
PR = "r0"

SRC_URI = "https://github.com/zeux/pugixml/releases/download/v${PV}/pugixml-${PV}.tar.gz"
SRC_URI[md5sum] = "7286ee2ed11376b6b780ced19fae0b64"
SRC_URI[sha256sum] = "d156d35b83f680e40fd6412c4455fdd03544339779134617b9b28d19e11fdba6"

DEPENDS = "cmake"

inherit cmake
EXTRA_OECMAKE = " -DBUILD_SHARED_LIBS=ON "

FILES_${PN}-dev += " \
	${libdir}/cmake \
"
