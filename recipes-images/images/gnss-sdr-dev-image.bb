require base-gnss-sdr-dev-image.bb

SUMMARY = "An image with a development/debug environment suitable for building GNSS-SDR."
LICENSE = "MIT"
PR = "r3"

IMAGE_FEATURES += "allow-empty-password allow-root-login empty-root-password post-install-logging"
EXTRA_IMAGE_FEATURES += " tools-profile dbg-pkgs"

TOOLCHAIN_TARGET_TASK += " \
    packagegroup-core-boot \
    packagegroup-gnss-sdr-base \
    packagegroup-gnss-sdr-base-extended \
    packagegroup-gnss-sdr-buildessential \
    packagegroup-gnss-sdr-drivers \
"

IMAGE_INSTALL:append = " packagegroup-gnss-sdr-base-extended"
SDK_INCLUDE_TOOLCHAIN = "1"

CORE_IMAGE_EXTRA_INSTALL += " \
    packagegroup-core-boot \
    packagegroup-gnss-sdr-base \
    packagegroup-gnss-sdr-base-extended \
    packagegroup-gnss-sdr-drivers \
"
