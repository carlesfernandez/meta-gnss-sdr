SUMMARY = "Analog Devices IIO Oscilloscope app"
HOMEPAGE = "https://wiki.analog.com/resources/tools-software/linux-software/iio_oscilloscope"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://license.txt;md5=cfe3dd5eb030dee299c43cb6f0b93096"
PR = "r2"

SRCREV = "39879ab906d4b370069623aadd6837addcda5c8f"

GIT_BRANCH = "main"
SRC_URI = "git://github.com/analogdevicesinc/iio-oscilloscope.git;branch=${GIT_BRANCH};protocol=https"

FILES:${PN} += "*"

DEPENDS = "glib-2.0 gtk+3 gtkdatabox fftw libxml2 curl jansson matio libad9361-iio"
inherit autotools cmake pkgconfig

