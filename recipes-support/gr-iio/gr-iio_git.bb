SUMMARY = "IIO blocks for GNU Radio"
HOMEPAGE = "https://github.com/analogdevicesinc/gr-iio"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS ="gnuradio libiio libad9361-iio"

inherit distutils-base cmake pkgconfig

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"

S="${WORKDIR}/git"

PV = "0.2.36"

SRCREV = "1897decf25389db6d2a8c5d06845c3a268624cd8"

SRC_URI = "git://github.com/analogdevicesinc/gr-iio"

FILES_${PN} += " \
   /usr/share/gnuradio/grc/blocks/* \
"
