SUMMARY = "IIO blocks for GNU Radio"
HOMEPAGE = "https://github.com/analogdevicesinc/gr-iio"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"
PR = "r3"

DEPENDS = "gnuradio libiio libad9361-iio bison-native"

inherit distutils-base cmake pkgconfig

S = "${WORKDIR}/git"

PV = "0.3"

SRCREV = "407865f89b92daa89fec5c2b3c0e44bb422ef9d3"

SRC_URI = "git://github.com/analogdevicesinc/gr-iio.git;protocol=https "

FILES_${PN} += " \
   /usr/share/gnuradio/grc/blocks/* \
"
