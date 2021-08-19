SUMMARY = "IIO blocks for GNU Radio"
HOMEPAGE = "https://github.com/analogdevicesinc/gr-iio"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"
PR = "r3"

DEPENDS = "gnuradio libiio libad9361-iio bison-native python3-pybind11-native"

inherit distutils3-base cmake pkgconfig python3native

S = "${WORKDIR}/git"

PV = "0.3"

SRCREV = "f1815389212cae0c1641b9d66e4921351ba21da2"

GIT_BRANCH = "gr3.9"
SRC_URI = "git://github.com/dl1ksv/gr-iio.git;branch=${GIT_BRANCH};protocol=https "

FILES:${PN} += " \
   /usr/share/gnuradio/grc/blocks/* \
"
