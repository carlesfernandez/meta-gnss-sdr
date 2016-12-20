SUMMARY = "GNSS-SDR: An open source software defined GNSS receiver."
URL = "http://gnss-sdr.org"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=3c34afdc3adf82d2448f12715a255122"

DEPENDS = "volk gnuradio armadillo gr-osmosdr uhd rtl-sdr libbladerf \
           libbladerf-bin openssh gflags glog"

#PACKAGECONFIG ??= "osmosdr"

PACKAGECONFIG[osmosdr] = "-DENABLE_OSMOSDR=ON,-DENABLE_OSMOSDR=OFF,osmosdr, "
PACKAGECONFIG[staticlibs] = "-DENABLE_STATIC_LIBS=ON,-DENABLE_STATIC_LIBS=OFF "

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"

ALLOW_EMPTY_${PN} = "1"

PV = "0.0.8"

SRCREV = "e02b17d7a173958cf92a843a0ecf9947716006cb"

# Make it easy to test against branches
GIT_BRANCH = "next"

SRC_URI = "git://github.com/gnss-sdr/gnss-sdr.git;branch=${GIT_BRANCH};protocol=https "

S="${WORKDIR}/git"

inherit distutils-base cmake pkgconfig
