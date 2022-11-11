do_install_append () {
    rm ${D}/usr/lib/uhd/utils/uhd_images_downloader.py
    rm ${D}/usr/bin/uhd_images_downloader
}

# Fix installed-vs-shipped warning
FILES_${PN} += " \
    ${PYTHON_SITEPACKAGES_DIR}/uhd/* \
"
