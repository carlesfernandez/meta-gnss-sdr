SUMMARY = "A GNSS signal generator"
AUTHOR = "Javier Arribas <jarribas@cttc.es>"
HOMEPAGE = "https://bitbucket.org/jarribas/gnss-simulator/"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=31f43bdb1ab7b19dae6e891241ca0568"
PR = "r3"

DEPENDS = "volk boost gflags glog"

PV = "1.0.git"

SRCREV = "146959efd4209c26a3ede2d494e393820e59aeb2"

# Make it easy to test against branches
GIT_BRANCH = "master"

SRC_URI = "git://bitbucket.org/jarribas/gnss-simulator.git;branch=${GIT_BRANCH};protocol=https"

S = "${WORKDIR}/git"

inherit cmake

PACKAGES = "gnss-simulator gnss-simulator-dbg"

FILES:${PN} = "${bindir}/gnss_sim \
     ${datadir}/gnss-sim/* \
"

FILES:${PN}-dbg += " \
     ${prefix}/src/debug/gnss-simulator/* \
     ${bindir}/.debug/gnss_sim \
"

do_rm_work() {
}
