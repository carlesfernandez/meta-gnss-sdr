SUMMARY = "A console-only image with a working GNSS-SDR environment \
"

EXTRA_IMAGE_FEATURES += "tools-debug tools-profile tools-sdk dev-pkgs dbg-pkgs"
LICENSE = "MIT"

require gnuradio-dev-image.bb

SDK_EXTRA_TOOLS += "nativesdk-python-six"
CORE_IMAGE_EXTRA_INSTALL += "\
    packagegroup-gnss-sdr-bin \
"

