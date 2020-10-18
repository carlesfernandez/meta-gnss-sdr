require base-gnss-sdr-dev-image.bb

SUMMARY = "An image with a development/debug environment suitable for building GNSS-SDR."
LICENSE = "MIT"
PR = "r3"

TOOLCHAIN_TARGET_TASK += " \
    packagegroup-core-boot \
    packagegroup-gnss-sdr-base \
    packagegroup-gnss-sdr-base-extended \
    packagegroup-gnss-sdr-buildessential \
    packagegroup-gnss-sdr-drivers \
"

IMAGE_INSTALL += "\
    packagegroup-gnss-sdr-buildessential \
"

SDK_INCLUDE_TOOLCHAIN = "1"
