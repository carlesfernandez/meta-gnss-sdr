include uhd.inc
PR = "r0"

LIC_FILES_CHKSUM = "file://LICENSE.md;md5=d20118f84adb62b1e27fcce89b9b240a"

SRC_URI = "git://github.com/EttusResearch/uhd.git;protocol=https;branch=UHD-4.9"

SRCREV = "9ec1f58234c572adbb3624c225c7c641b5115d3b"

S = "${UNPACKDIR}/${BP}/host"

INSANE_SKIP:${PN}-src += "buildpaths"
INSANE_SKIP:${PN} += "buildpaths"

EXTRA_OECMAKE:append = " -DUHD_RELEASE_MODE=release"

FILES:${PN} += " \
    ${PYTHON_SITEPACKAGES_DIR}/uhd/* \
    ${PYTHON_SITEPACKAGES_DIR}/usrp_mpm/* \
"
