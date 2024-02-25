SUMMARY = "A GNSS signal generator"
AUTHOR = "Javier Arribas <jarribas@cttc.es>"
HOMEPAGE = "https://bitbucket.org/jarribas/gnss-simulator/"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=31f43bdb1ab7b19dae6e891241ca0568"
PR = "r5"

DEPENDS = "volk boost gflags glog"

PV = "1.0.git"

SRCREV = "da6b704b39bec80e3ba8a6bfd776df8993644cc0"

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
