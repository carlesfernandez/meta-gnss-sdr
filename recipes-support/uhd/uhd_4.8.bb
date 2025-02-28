include uhd.inc
PR = "r0"

LIC_FILES_CHKSUM = "file://../LICENSE.md;md5=d20118f84adb62b1e27fcce89b9b240a"

SRC_URI = "git://github.com/EttusResearch/uhd.git;protocol=https;branch=UHD-4.8"

SRCREV = "308126a479ca19dfaebfe4784b375e608788d763"

S = "${WORKDIR}/sources-unpack/git/host/git/host"
UNPACKDIR = "${WORKDIR}/sources-unpack/git/host"

INSANE_SKIP:${PN}-src += "buildpaths"
INSANE_SKIP:${PN} += "buildpaths"

EXTRA_OECMAKE:append = " -DUHD_RELEASE_MODE=release"

FILES:${PN} += " \
    ${PYTHON_SITEPACKAGES_DIR}/uhd/* \
    ${PYTHON_SITEPACKAGES_DIR}/usrp_mpm/* \
"
