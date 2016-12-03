SUMMARY = "Linear Algebra PACKage"
URL = "http://www.netlib.org/lapack"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e21002112b171eb76a5d54efdff481a9"

DEPENDS = "gcc-runtime"

FORTRAN_TOOLS = " \
    gfortran \
    gfortran-symlinks \
    libgfortran \
    libgfortran-dev \
"

#IMAGE_INSTALL += " ${FORTRAN_TOOLS}"

SRC_URI = "http://www.netlib.org/lapack/lapack-3.6.1.tgz"
SRC_URI[md5sum] = "421b2cb72e15f237e144428f9c460ee0"
SRC_URI[sha256sum] = "888a50d787a9d828074db581c80b2d22bdb91435a673b1bf6cd6eb51aa50d1de"

SRC_URI += "file://make.inc;md5=7273848b6eae242385045e31f7f4ded7"


export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"

inherit distutils-base cmake pkgconfig

ALLOW_EMPTY_${PN} = "1"

PV = "3.6.1"

S="${WORKDIR}/lapack-3.6.1"

