SUMMARY = "A GNSS signal generator"
AUTHOR = "Javier Arribas <jarribas@cttc.es>"
HOMEPAGE = "https://bitbucket.org/jarribas/gnss-simulator/"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=31f43bdb1ab7b19dae6e891241ca0568"
PR = "r8"

DEPENDS = "abseil-cpp boost volk"

PV = "1.0.git"

SRCREV = "c283007ff3ec9bd49c26359ee6ff69e5e84c36b4"

# Make it easy to test against branches
GIT_BRANCH = "master"

SRC_URI = "git://bitbucket.org/jarribas/gnss-simulator.git;branch=${GIT_BRANCH};protocol=https"

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
