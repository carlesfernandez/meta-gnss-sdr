SUMMARY = "An image with the GNSS-SDR binary and required environment"
LICENSE = "MIT"
PR = "r0"

EXTRA_IMAGE_FEATURES += "tools-debug tools-profile tools-sdk dev-pkgs dbg-pkgs"

require base-gnss-sdr-dev-image.bb

SDK_EXTRA_TOOLS += "nativesdk-python3-six"

IMAGES_INSTALL += "packagegroup-xfce-extended"

CORE_IMAGE_EXTRA_INSTALL += "\
    gnss-sdr \
"
