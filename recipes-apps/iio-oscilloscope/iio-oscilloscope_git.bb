SUMMARY = "Analog Devices IIO Oscilloscope app"
HOMEPAGE = "https://wiki.analog.com/resources/tools-software/linux-software/iio_oscilloscope"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://license.txt;md5=cfe3dd5eb030dee299c43cb6f0b93096"
PR = "r0"

SRCREV = "02dcb357c2e2c092c91c5cba2dc0cab83cad1e99"

PV = "0.14"
GIT_BRANCH = "master"
SRC_URI = "git://github.com/analogdevicesinc/iio-oscilloscope.git;branch=${GIT_BRANCH};protocol=https "

S = "${WORKDIR}/git"

FILES_${PN} += "*"

DEPENDS += " glib-2.0 gtk+ gtkdatabox fftw libxml2 curl jansson matio libad9361-iio"
inherit autotools cmake
