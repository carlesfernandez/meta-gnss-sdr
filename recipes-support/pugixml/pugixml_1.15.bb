SUMMARY = "Light-weight C++ XML Processing Library"
HOMEPAGE = "https://pugixml.org"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://readme.txt;md5=14add14d509dd4f48390ec3e1eec6c10"
PR = "r0"

SRC_URI = "https://github.com/zeux/pugixml/releases/download/v${PV}/pugixml-${PV}.tar.gz"
SRC_URI[md5sum] = "3b894c29455eb33a40b165c6e2de5895"
SRC_URI[sha256sum] = "655ade57fa703fb421c2eb9a0113b5064bddb145d415dd1f88c79353d90d511a"

inherit cmake

EXTRA_OECMAKE += "-DBUILD_PKGCONFIG=ON \
                  -DBUILD_SHARED_LIBS=ON \
                  -DCMAKE_BUILD_TYPE=Release \
                  "

FILES:${PN}-dev += " \
	${libdir}/cmake \
"

BBCLASSEXTEND = "native nativesdk"