# Workaround for maximum shebang size exceeded error
INSANE_SKIP_${PN} += " file-rdeps shebang-size"

# Fix installed-vs-shipped warning
FILES_${PN} += " \
    ${PYTHON_SITEPACKAGES_DIR}/uhd/* \
"
