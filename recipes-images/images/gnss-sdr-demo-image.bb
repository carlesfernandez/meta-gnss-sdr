require base-gnss-sdr-dev-image.bb

SUMMARY = "An image with the GNSS-SDR binary and required environment"
LICENSE = "MIT"
PR = "r2"

EXTRA_IMAGE_FEATURES += "tools-debug tools-profile tools-sdk dev-pkgs dbg-pkgs"

IMAGES_INSTALL += "packagegroup-xfce-extended"

CORE_IMAGE_EXTRA_INSTALL += "\
    gnss-sdr \
"
