SUMMARY = "Linear Algebra PACKage"
URL = "http://www.netlib.org/lapack"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e21002112b171eb76a5d54efdff481a9"

DEPENDS = "gcc-runtime libgfortran"

PV = "3.7.0"

SRC_URI = "http://www.netlib.org/lapack/lapack-${PV}.tgz"
SRC_URI[md5sum] = "697bb8d67c7d336a0f339cc9dd0fa72f"
SRC_URI[sha256sum] = "ed967e4307e986474ab02eb810eed1d1adc73f5e1e3bc78fb009f6fe766db3be"

SRC_URI += "file://make.inc;md5=27f41711dd1bc0b15e3780e6bdf46d92"
SRC_URI += "file://001-SRC_Makefile.patch;md5=36222be8bb239cdd62599f51f6720074"
SRC_URI += "file://002-SRC_BLAS_Makefile.patch;md5=902cc505ecfff12f8e4d1f552b418ffc"

inherit distutils-base cmake pkgconfig

OECMAKE_GENERATOR = "Unix Makefiles"
EXTRA_OECMAKE = " -DBUILD_SHARED_LIBS=ON "

do_compile() {
     cp -f ${WORKDIR}/make.inc ${WORKDIR}/${PN}-${PV}/make.inc
     oe_runmake blas
     oe_runmake lapack
}

FILES_${PN} += "${base_libdir}"
FILES_${PN}-dbg += "${base_libdir}/.debug"

PACKAGES =+ "${PN}-misc"
FILES_${PN}-misc = "/usr/lib/libtmglib.so"
