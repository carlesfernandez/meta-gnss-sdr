SUMMARY = "An image with the GNSS-SDR binary and required environment"

EXTRA_IMAGE_FEATURES += "tools-debug tools-profile tools-sdk dev-pkgs dbg-pkgs"
LICENSE = "MIT"

require base-dev-image.bb

IMAGES_INSTALL += "packagegroup-xfce-extended"

CORE_IMAGE_EXTRA_INSTALL += "\
    gnss-sdr \
"
