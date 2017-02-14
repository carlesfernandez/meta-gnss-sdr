SUMMARY = "GNSS-SDR: An open source software defined GNSS receiver."
URL = "http://gnss-sdr.org"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=3c34afdc3adf82d2448f12715a255122"

DEPENDS = "volk uhd gnuradio armadillo gflags glog  \
           gnutls python-mako python-six python-six-native"

PACKAGECONFIG ??= "osmosdr unittest"

PACKAGECONFIG[osmosdr] = "-DENABLE_OSMOSDR=ON,-DENABLE_OSMOSDR=OFF,rtl-sdr libbladerf gr-osmosdr, "
PACKAGECONFIG[unittest] = "-DENABLE_UNIT_TESTING=ON,-DENABLE_UNIT_TESTING=OFF, gtest, "
PACKAGECONFIG[logging] = "-DENABLE_LOG=ON,-DENABLE_LOG=OFF "

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"

PV = "0.0.9"

SRCREV = "32e4d227af032365cfd7f9291d9f2c2fca57d99d"

# Make it easy to test against branches
GIT_BRANCH = "master"

SRC_URI = "git://github.com/gnss-sdr/gnss-sdr.git;branch=${GIT_BRANCH};protocol=https "

S="${WORKDIR}/git"

inherit distutils-base cmake pkgconfig
