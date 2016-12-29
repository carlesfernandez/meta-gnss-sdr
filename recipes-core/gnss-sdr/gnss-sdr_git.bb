SUMMARY = "GNSS-SDR: An open source software defined GNSS receiver."
URL = "http://gnss-sdr.org"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=3c34afdc3adf82d2448f12715a255122"

#PREFERRED_VERSION_python-six = "1.10.0"

DEPENDS = "volk gnuradio armadillo uhd rtl-sdr libbladerf \
           openssh git-native gflags glog python python-mako python-six python-six-native" 

PACKAGECONFIG ??= "osmosdr"

PACKAGECONFIG[osmosdr] = "-DENABLE_OSMOSDR=ON,-DENABLE_OSMOSDR=OFF, gr-osmosdr, "
PACKAGECONFIG[staticlibs] = "-DENABLE_STATIC_LIBS=ON,-DENABLE_STATIC_LIBS=OFF "
PACKAGECONFIG[test] = "-DENABLE_UNIT_TESTING=ON,-DENABLE_UNIT_TESTING=OFF "
PACKAGECONFIG[logging] = "-DENABLE_LOG=ON,-DENABLE_LOG=OFF "

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"

ALLOW_EMPTY_${PN} = "1"

PV = "0.0.8"

SRCREV = "e846b3154790fa4c284a54e16d212719237312b4"

# Make it easy to test against branches
GIT_BRANCH = "next"

SRC_URI = "git://github.com/gnss-sdr/gnss-sdr.git;branch=${GIT_BRANCH};protocol=https "

S="${WORKDIR}/git"

inherit distutils-base cmake pkgconfig
