require uhd.inc
PR = "r0"

LIC_FILES_CHKSUM = "file://LICENSE;md5=8255adf1069294c928e0e18b01a16282"

SRC_URI = "git://github.com/EttusResearch/uhd.git;protocol=https;branch=UHD-4.3"

SRCREV = "1f8fd3457dee48dc472446113a6998c2529adf59"
S = "${WORKDIR}/git/host"

EXTRA_OECMAKE:append = " -DUHD_RELEASE_MODE=release"

do_install:append () {
    rm ${D}/usr/lib/uhd/utils/uhd_images_downloader.py
    rm ${D}/usr/bin/uhd_images_downloader
}

FILES:${PN} += " \
    ${PYTHON_SITEPACKAGES_DIR}/uhd/* \
    ${PYTHON_SITEPACKAGES_DIR}/usrp_mpm/* \
"


