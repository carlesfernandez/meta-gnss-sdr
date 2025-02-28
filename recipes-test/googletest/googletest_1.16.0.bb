DESCRIPTION = "Google's framework for writing C++ tests"
HOMEPAGE = "https://github.com/google/googletest"
SECTION = "libs"
PR = "r0"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=cbbd27594afd089daa160d3a16dd515a"

PROVIDES += "gmock gtest"

S = "${WORKDIR}/git"
SRCREV = "6910c9d9165801d8827d628cb72eb7ea9dd538c5"
SRC_URI = "git://github.com/google/googletest.git;branch=v1.16.x;protocol=https"

inherit cmake

ALLOW_EMPTY:${PN} = "1"
ALLOW_EMPTY:${PN}-dbg = "1"

BBCLASSEXTEND = "native nativesdk"

# GTest developers recommend to use source code instead of linking
# against a prebuilt library.
do_install:append() {
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