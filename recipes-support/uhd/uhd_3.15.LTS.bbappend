# Update version in order to avoid issues with Boost 1.74
SRC_URI = "git://github.com/EttusResearch/uhd.git;branch=UHD-3.15.LTS;protocol=https "
SRCREV = "7a3f15164f78a7a3b705a0d099eb5dc335ccd9f6"

# Workaround for maximum shebang size exceeded error
INSANE_SKIP_${PN} += " file-rdeps shebang-size"

# Fix installed-vs-shipped warning
FILES_${PN} += " \
    ${PYTHON_SITEPACKAGES_DIR}/uhd/* \
"
