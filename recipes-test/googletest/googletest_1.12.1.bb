DESCRIPTION = "Google's framework for writing C++ tests"
HOMEPAGE = "https://github.com/google/googletest"
SECTION = "libs"
LICENSE = "BSD-3-Clause"
PR = "r0"
 
LIC_FILES_CHKSUM = "file://LICENSE;md5=cbbd27594afd089daa160d3a16dd515a"

PROVIDES += "gmock gtest"
S = "${WORKDIR}/git"
SRCREV = "219af0d535635f173e58d7e8ef197b0bc48b878a"
SRC_URI = "git://github.com/google/googletest.git;protocol=https;branch=main"

ALLOW_EMPTY_${PN} = "1"
ALLOW_EMPTY_${PN}-dbg = "1"

RDEPENDS_${PN}-dev += "${PN}-staticdev"

BBCLASSEXTEND = "native nativesdk"

do_configure:prepend() {
    # explicitly use python3
    # the scripts are already python3 compatible since https://github.com/google/googletest/commit/d404af0d987a9c38cafce82a7e26ec8468c88361 and other fixes like this
    # but since this oe-core change http://git.openembedded.org/openembedded-core/commit/?id=5f8f16b17f66966ae91aeabc23e97de5ecd17447
    # there isn't python in HOSTTOOLS so "env python" fails
    sed -i 's@^#!/usr/bin/env python$@#!/usr/bin/env python3@g' ${S}/googlemock/scripts/*py ${S}/googlemock/scripts/generator/*py ${S}/googlemock/scripts/generator/cpp/*py ${S}/googlemock/test/*py ${S}/googletest/scripts/*py ${S}/googletest/test/*py
}

# GTest developers recommend to use source code instead of linking
# against a prebuilt library.
do_install_append() {
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

sysroot_stage_all_append() {
    sysroot_stage_dir ${D}${prefix}/src ${SYSROOT_DESTDIR}${prefix}/src
}

FILES_${PN}-dev += "${prefix}/src"
