SUMMARY = "GNSS-SDR: An open source software defined GNSS receiver."
URL = "http://gnss-sdr.org"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=3c34afdc3adf82d2448f12715a255122"

#PREFERRED_VERSION_python-six = "1.10.0"

DEPENDS = "volk gnuradio armadillo gr-osmosdr uhd rtl-sdr libbladerf \
           openssh git-native gflags glog python python-mako python-six python-six-native" 

#RDEPENDS_{PN} += "python-core python-lang python-mako python-six"
#PACKAGECONFIG ??= "osmosdr"

PACKAGECONFIG[osmosdr] = "-DENABLE_OSMOSDR=ON,-DENABLE_OSMOSDR=OFF,osmosdr, "
PACKAGECONFIG[staticlibs] = "-DENABLE_STATIC_LIBS=ON,-DENABLE_STATIC_LIBS=OFF "
PACKAGECONFIG[test] = "-DENABLE_UNIT_TESTING=ON,-DENABLE_UNIT_TESTING=OFF "
 
export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"

ALLOW_EMPTY_${PN} = "1"

PV = "0.0.8"

SRCREV = "c6df0d6f4048f7a6f0447d429bcce986a8a47e30"

# Make it easy to test against branches
GIT_BRANCH = "bitbake"

SRC_URI = "git://github.com/carlesfernandez/gnss-sdr.git;branch=${GIT_BRANCH};protocol=https "

S="${WORKDIR}/git"

inherit distutils-base cmake pkgconfig
