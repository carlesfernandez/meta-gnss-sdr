SUMMARY = "IIO blocks for GNU Radio"
HOMEPAGE = "https://github.com/analogdevicesinc/gr-iio"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"
PR = "r1"

DEPENDS = "gnuradio libiio libad9361-iio bison-native"

inherit distutils3-base cmake pkgconfig python3native

S = "${WORKDIR}/git"

PV = "0.3"

SRCREV = "b3bd9edfaa03e8c63631f9166e1997870cc6b9ba"

GIT_BRANCH = "upgrade-3.8"
SRC_URI = "git://github.com/analogdevicesinc/gr-iio.git;branch=${GIT_BRANCH};protocol=https"

FILES_${PN} += " \
   /usr/share/gnuradio/grc/blocks/* \
"
