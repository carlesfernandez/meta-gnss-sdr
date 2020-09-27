SUMMARY = "A GNSS signal generator"
AUTHOR = "Javier Arribas <jarribas@cttc.es>"
HOMEPAGE = "https://bitbucket.org/jarribas/gnss-simulator/"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=31f43bdb1ab7b19dae6e891241ca0568"
PR = "r0"

DEPENDS = "volk boost armadillo gflags glog "

PV = "1.0.git"

SRCREV = "86dafacb8b86ce51006b5ecf48e791f5c8a9ed38"

# Make it easy to test against branches
GIT_BRANCH = "master"

SRC_URI = "git://bitbucket.org/jarribas/gnss-simulator.git;branch=${GIT_BRANCH};protocol=https "

S = "${WORKDIR}/git"

inherit cmake

PACKAGES = "gnss-simulator"

FILES_${PN} = "${bindir}/gnss_sim \
  /usr/share/gnss-sim/* \
"

do_rm_work() {
}
