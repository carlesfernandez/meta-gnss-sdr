SUMMARY = "A GNSS signal generator"
AUTHOR = "Javier Arribas <jarribas@cttc.es>"
HOMEPAGE = "https://bitbucket.org/jarribas/gnss-simulator/"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=31f43bdb1ab7b19dae6e891241ca0568"

DEPENDS = "volk gnuradio armadillo gflags glog "

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"

PV = "1.0"

SRCREV = "338948ecfb0d64b18420cff9cb83e9d749be84b4"

# Make it easy to test against branches
GIT_BRANCH = "master"

SRC_URI = "git://bitbucket.org/jarribas/gnss-simulator.git;branch=${GIT_BRANCH};protocol=https "

S="${WORKDIR}/git"

inherit distutils-base cmake pkgconfig

PACKAGES = "gnss-simulator"

FILES_${PN} = "${bindir}/gnss_sim \
  /usr/share/gnss-sim/* \
"
