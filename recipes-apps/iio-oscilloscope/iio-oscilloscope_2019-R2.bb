SUMMARY = "Analog Devices IIO Oscilloscope app"
HOMEPAGE = "https://wiki.analog.com/resources/tools-software/linux-software/iio_oscilloscope"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://license.txt;md5=cfe3dd5eb030dee299c43cb6f0b93096"
PR = "r1"

SRCREV = "ae326c09e42ad73c091bc16c9758b2ae649b6887"

GIT_BRANCH = "2019_R2"
SRC_URI = "git://github.com/analogdevicesinc/iio-oscilloscope.git;branch=${GIT_BRANCH};protocol=https "

S = "${WORKDIR}/git"

FILES_${PN} += "*"

DEPENDS += " glib-2.0 gtk+ gtkdatabox fftw libxml2 curl jansson matio libad9361-iio"
inherit autotools cmake
