SUMMARY = "Analog Devices IIO Oscilloscope app"
HOMEPAGE = "https://wiki.analog.com/resources/tools-software/linux-software/iio_oscilloscope"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://license.txt;md5=cfe3dd5eb030dee299c43cb6f0b93096"
PR = "r2"

SRCREV = "74a00e66ddcafc7bb0bc6e36641f364254ef6da6"

GIT_BRANCH = "ubuntu20.04-v0.14"
SRC_URI = "git://github.com/analogdevicesinc/iio-oscilloscope.git;branch=${GIT_BRANCH};protocol=https"

S = "${WORKDIR}/git"

FILES:${PN} += "*"

DEPENDS = "glib-2.0 gtk+ gtkdatabox fftw libxml2 curl jansson matio libad9361-iio"
inherit autotools cmake pkgconfig
