SUMMARY = "Basic Linear Algebra Subprograms"
URL = "http://www.netlib.org/blas"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e21002112b171eb76a5d54efdff481a9"

DEPENDS = "gcc-runtime"

PV = "3.7.0"

SRC_URI = "http://www.netlib.org/blas/blas-${PV}.tgz"
SRC_URI[md5sum] = "70f26f95c93fd3871a886bf4237e8268"
SRC_URI[sha256sum] = "55415f901bfc9afc19d7bd7cb246a559a748fc737353125fcce4c40c3dee1d86"

SRC_URI += "file://LICENSE;md5=e21002112b171eb76a5d54efdff481a9"

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"

inherit distutils-base cmake pkgconfig

ALLOW_EMPTY_${PN} = "1"

S="${WORKDIR}/BLAS-${PV}"
