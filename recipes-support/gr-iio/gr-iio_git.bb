SUMMARY = "IIO blocks for GNU Radio"
HOMEPAGE = "https://github.com/analogdevicesinc/gr-iio"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"
PR = "r0"

DEPENDS ="gnuradio libiio libad9361-iio"

inherit distutils-base cmake pkgconfig

S = "${WORKDIR}/git"

PV = "0.3"

SRCREV = "109436481a2a1872ce20a01a1f6cf390c508d308"

SRC_URI = "git://github.com/analogdevicesinc/gr-iio"

FILES_${PN} += " \
   /usr/share/gnuradio/grc/blocks/* \
"
