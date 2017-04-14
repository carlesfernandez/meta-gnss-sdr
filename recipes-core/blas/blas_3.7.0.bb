SUMMARY = "Basic Linear Algebra Subprograms"
URL = "http://www.netlib.org/blas"
LICENSE = "BSD-3-Clause"
#LIC_FILES_CHKSUM = "file://LICENSE;md5=e21002112b171eb76a5d54efdff481a9"

DEPENDS = "gcc-runtime"

PV = "3.7.0"

SRC_URI = "http://www.netlib.org/blas/blast-forum/cblas.tgz"
SRC_URI[md5sum] = "1e8830f622d2112239a4a8a83b84209a"
SRC_URI[sha256sum] = "0f6354fd67fabd909baf57ced2ef84e962db58fae126e4f41b21dd4fec60a2a3"

# SRC_URI += "file://make.inc;md5=1b0019f28d7ede0c411f6e86e9eee56b"

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"

inherit distutils-base cmake pkgconfig

ALLOW_EMPTY_${PN} = "1"

S="${WORKDIR}/CBLAS"
