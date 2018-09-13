SUMMARY = "A GNSS signal generator"
AUTHOR = "Javier Arribas <jarribas@cttc.es>"
HOMEPAGE = "https://gnss-sdr.org"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=3c34afdc3adf82d2448f12715a255122"

DEPENDS = "volk gnuradio armadillo gflags glog  \
          python-mako python-mako-native python-six python-six-native"

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"

PV = "1.0"

SRCREV = "56bb6f37e3984056977d0829a0f3d58b1a4294e3"

# Make it easy to test against branches
GIT_BRANCH = "master"

SRC_URI = "git://bitbucket.org/jarribas/gnss-simulator.git;branch=${GIT_BRANCH};protocol=https "

S="${WORKDIR}/git"

inherit distutils-base cmake pkgconfig

PACKAGES = "gnss-simulator"

FILES_${PN} = "${bindir}/gnss_sim"
