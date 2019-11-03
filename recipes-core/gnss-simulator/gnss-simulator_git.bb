SUMMARY = "A GNSS signal generator"
AUTHOR = "Javier Arribas <jarribas@cttc.es>"
HOMEPAGE = "https://bitbucket.org/jarribas/gnss-simulator/"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=31f43bdb1ab7b19dae6e891241ca0568"

DEPENDS = "volk boost armadillo gflags glog "

PV = "1.0.git"

SRCREV = "c62d196952c7ea6a6d2033a562bf5b9bec1d084d"

# Make it easy to test against branches
GIT_BRANCH = "master"

SRC_URI = "git://bitbucket.org/jarribas/gnss-simulator.git;branch=${GIT_BRANCH};protocol=https "

S="${WORKDIR}/git"

inherit cmake

PACKAGES = "gnss-simulator"

FILES_${PN} = "${bindir}/gnss_sim \
  /usr/share/gnss-sim/* \
"

do_rm_work() {
}
