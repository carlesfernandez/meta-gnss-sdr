SUMMARY = "Google C++ Testing Framework"
DESCRIPTION = "Google's framework for writing C++ tests. This recipe installs the source code in the target."
HOMEPAGE = "https://github.com/google/googletest"
SECTION = "libs"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=cbbd27594afd089daa160d3a16dd515a"
PR = "r0"

PROVIDES += "gmock gtest"

S = "${WORKDIR}/git"
SRCREV = "58d77fa8070e8cec2dc1ed015d66b454c8d78850"
SRC_URI = "git://github.com/google/googletest.git;protocol=https;branch=main"

inherit cmake

ALLOW_EMPTY:${PN} = "1"
ALLOW_EMPTY:${PN}-dbg = "1"

BCLASSEXTEND = "native nativesdk"
RDEPENDS:${PN}-dev = ""
EXTRA_OECMAKE += "-DBUILD_GTEST=ON"

# GTest developers recommend to use source code instead of linking
# against a prebuilt library.

do_install() {
    _incdir=${includedir}/gtest
    _srcdir=${prefix}/src/gtest

    install -d ${D}${_incdir}/internal
    install -d ${D}${_srcdir}/src
    install -d ${D}${_srcdir}/cmake

    mkdir -p ${D}${_incdir}/internal/custom

    install -v -m 0644 ${S}/googletest/include/gtest/*.h ${D}${_incdir}
    install -v -m 0644 ${S}/googletest/include/gtest/internal/*.h ${D}${_incdir}/internal
    install -v -m 0644 ${S}/googletest/include/gtest/internal/custom/*.h ${D}${_incdir}/internal/custom
    install -v -m 0644 ${S}/googletest/src/* ${D}${_srcdir}/src
    install -v -m 0644 ${S}/CMakeLists.txt ${D}${_srcdir}
    install -v -m 0644 ${S}/googletest/cmake/* ${D}${_srcdir}/cmake
}

sysroot_stage_all:append() {
    sysroot_stage_dir ${D}${prefix}/src ${SYSROOT_DESTDIR}${prefix}/src
}

FILES:${PN}-dev += "${prefix}/src"
