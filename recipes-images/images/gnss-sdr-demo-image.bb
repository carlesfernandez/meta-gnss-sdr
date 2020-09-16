SUMMARY = "An image with the GNSS-SDR binary and required environment"

EXTRA_IMAGE_FEATURES += "tools-debug tools-profile tools-sdk dev-pkgs dbg-pkgs"
LICENSE = "MIT"

require base-dev-image.bb

SDK_EXTRA_TOOLS += "nativesdk-python3-six"

CORE_IMAGE_EXTRA_INSTALL += "\
    gnss-sdr \
"
