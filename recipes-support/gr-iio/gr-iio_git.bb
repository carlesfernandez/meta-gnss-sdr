SUMMARY = "IIO blocks for GNU Radio"
HOMEPAGE = "https://github.com/analogdevicesinc/gr-iio"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"
PR = "r2"

DEPENDS = "gnuradio libiio libad9361-iio bison-native"

inherit distutils3-base cmake pkgconfig python3native

S = "${WORKDIR}/git"

PV = "0.3"

SRCREV = "f1bb949a1e616687c42f4ff08b943e2b1d598151"

GIT_BRANCH = "update-boost173"
SRC_URI = "git://github.com/analogdevicesinc/gr-iio.git;branch=${GIT_BRANCH};protocol=https "

FILES:${PN} += " \
   /usr/share/gnuradio/grc/blocks/* \
"
