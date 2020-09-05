SUMMARY = "An image with a development/debug \
environment suitable for building GNSS-SDR."

EXTRA_IMAGE_FEATURES += "tools-debug tools-profile tools-sdk dev-pkgs"
LICENSE = "MIT"

require gnuradio-dev-image.bb

RDEPENDS_packagegroup-sdr-base-python += " python3-six"

SDK_EXTRA_TOOLS += "nativesdk-python3-six nativesdk-protobuf"
TOOLCHAIN_HOST_TASK_append = " nativesdk-protobuf-compiler"
TOOLCHAIN_TARGET_TASK = " \
    packagegroup-core-boot \
    packagegroup-gnss-sdr-base \
    packagegroup-gnss-sdr-drivers \
    packagegroup-gnss-sdr-base-extended \
    packagegroup-gnss-sdr-buildessential \
"

IMAGE_INSTALL_append = " packagegroup-gnss-sdr-base-extended"
SDK_INCLUDE_TOOLCHAIN = "1"

CORE_IMAGE_EXTRA_INSTALL += " \
    packagegroup-core-boot \
    packagegroup-gnss-sdr-base \
    packagegroup-gnss-sdr-base-extended \
    packagegroup-gnss-sdr-drivers \
"
