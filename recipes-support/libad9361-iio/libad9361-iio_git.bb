SUMMARY = "Device specific library for AD936X transceivers"
DESCRIPTION = "This is a simple library used for userspace, which manages multi-chip sync, on platforms (FMCOMMS5) where multiple AD9361 devices are used."
AUTHOR = "Analog Devices, Inc."
HOMEPAGE = "https://github.com/analogdevicesinc/libad9361-iio"
LICENSE = "LGPL-2.1-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=40d2542b8c43a3ec2b7f5da31a697b88"
PR = "r2"

DEPENDS = "libiio"

SRCREV = "43643ab0ef8a3fbdb6c7595f42842f534a291664"

PV = "0.2"
GIT_BRANCH = "main"
SRC_URI = "git://github.com/analogdevicesinc/libad9361-iio;branch=${GIT_BRANCH};protocol=https"

S = "${WORKDIR}/git"

inherit setuptools3-base cmake pkgconfig

FILES:${PN}-dev += " \
  ${libdir}/pkgconfig/libad9361.pc \
"

FILES:{PN}-dbg += " \
  /usr/src/debug/* \
  /usr/lib/.debug/* \
"
