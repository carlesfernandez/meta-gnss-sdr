SUMMARY = "Linear Algebra PACKage"
URL = "http://www.netlib.org/lapack"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e21002112b171eb76a5d54efdff481a9"

DEPENDS = "gcc-runtime"

PV = "3.7.0"

SRC_URI = "http://www.netlib.org/lapack/lapack-${PV}.tgz"
SRC_URI[md5sum] = "697bb8d67c7d336a0f339cc9dd0fa72f"
SRC_URI[sha256sum] = "ed967e4307e986474ab02eb810eed1d1adc73f5e1e3bc78fb009f6fe766db3be"

SRC_URI += "file://make.inc;md5=1b0019f28d7ede0c411f6e86e9eee56b"

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"

inherit distutils-base cmake pkgconfig

ALLOW_EMPTY_${PN} = "1"

S="${WORKDIR}/lapack-${PV}"
