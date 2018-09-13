SUMMARY = "A GNSS signal generator"
AUTHOR = "Javier Arribas <jarribas@cttc.es>"
HOMEPAGE = "https://bitbucket.org/jarribas/gnss-simulator/"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=31f43bdb1ab7b19dae6e891241ca0568"

DEPENDS = "volk gnuradio armadillo gflags glog "

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"

PV = "1.0"

SRCREV = "1cac3d93cfaad6f8352e42931b3b9f77817d2f2c"

# Make it easy to test against branches
GIT_BRANCH = "master"

SRC_URI = "git://bitbucket.org/jarribas/gnss-simulator.git;branch=${GIT_BRANCH};protocol=https "

S="${WORKDIR}/git"

inherit distutils-base cmake pkgconfig

PACKAGES = "gnss-simulator"

FILES_${PN} = "${bindir}/gnss_sim"
