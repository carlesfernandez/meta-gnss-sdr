# GTest developers recommend to use source code instead of linking
# against a prebuilt library.
do_install() {
    _incdir=${includedir}/gtest
    _srcdir=${prefix}/src/gtest

    install -d ${D}${_incdir}/internal
    install -d ${D}${_srcdir}/src
    install -d ${D}${_srcdir}/cmake

    install -v -m 0644 ${S}/include/gtest/*.h ${D}${_incdir}
    install -v -m 0644 ${S}/include/gtest/internal/*.h ${D}${_incdir}/internal
    install -v -m 0644 ${S}/fused-src/gtest/* ${D}${_srcdir}/src
    install -v -m 0644 ${S}/CMakeLists.txt ${D}${_srcdir}
    install -v -m 0644 ${S}/cmake/* ${D}${_srcdir}/cmake
}

sysroot_stage_all_append() {
    sysroot_stage_dir ${D}${prefix}/src ${SYSROOT_DESTDIR}${prefix}/src
}

FILES_${PN}-dev += "${prefix}/src"
