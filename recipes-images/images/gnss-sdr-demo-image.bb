require base-gnss-sdr-dev-image.bb

SUMMARY = "An image with the GNSS-SDR binary and required environment"
LICENSE = "MIT"
PR = "r1"

EXTRA_IMAGE_FEATURES += "tools-debug tools-profile tools-sdk dev-pkgs dbg-pkgs"

SDK_EXTRA_TOOLS += "nativesdk-python3-six"

CORE_IMAGE_EXTRA_INSTALL += "\
    gnss-sdr \
"
