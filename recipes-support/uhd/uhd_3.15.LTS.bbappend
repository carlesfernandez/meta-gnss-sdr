# Update version in order to avoid issues with Boost 1.74
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI = "git://github.com/EttusResearch/uhd.git;branch=UHD-3.15.LTS;protocol=https \
    file://0001-Convert-the-asm-s16-le-converters-to-NEON-intrinsics.patch;striplevel=2 \
    file://0002-Be-more-verbose-when-checking-for-python-import.patch \
"

SRCREV = "7a3f15164f78a7a3b705a0d099eb5dc335ccd9f6"
PV = "3.15.LTS+git${SRCPV}"

# Workaround for maximum shebang size exceeded error
INSANE_SKIP_${PN} += " shebang-size"

do_install_append () {
    rm ${D}/usr/lib/uhd/utils/uhd_images_downloader.py
    rm ${D}/usr/bin/uhd_images_downloader
}

# Fix installed-vs-shipped warning
FILES_${PN} += " \
    ${PYTHON_SITEPACKAGES_DIR}/uhd/* \
"
