SUMMARY = "An image with a development/debug \
environment suitable for building GNSS-SDR."

EXTRA_IMAGE_FEATURES += "tools-debug tools-profile tools-sdk dev-pkgs dbg-pkgs"
LICENSE = "MIT"

require gnuradio-dev-image.bb

RDEPENDS_packagegroup-sdr-base-python += " python-six"

SDK_EXTRA_TOOLS += "nativesdk-python-six"

CORE_IMAGE_EXTRA_INSTALL += " \
    packagegroup-gnss-sdr-base \
"
