SUMMARY = "Device specific library for AD936X transceivers"
DESCRIPTION = "This is a simple library used for userspace, which manages multi-chip sync, on platforms (FMCOMMS5) where multiple AD9361 devices are used."
AUTHOR = "Analog Devices, Inc."
HOMEPAGE = "https://github.com/analogdevicesinc/libad9361-iio"
LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://LICENSE;md5=40d2542b8c43a3ec2b7f5da31a697b88"
PR = "r0"

DEPENDS = "libiio"

SRCREV = "be7eb026436f6b68eb718a01cdd249acd85b05c5"

GIT_BRANCH = "2019_R2"
SRC_URI = "git://github.com/analogdevicesinc/libad9361-iio;branch=${GIT_BRANCH};protocol=https "

S = "${WORKDIR}/git"

inherit distutils3-base cmake pkgconfig

FILES_${PN}-dev += " \
  ${libdir}/pkgconfig/libad9361.pc \
"

FILES_{PN}-dbg += " \
  /usr/src/debug/* \
  /usr/lib/.debug/* \
"
