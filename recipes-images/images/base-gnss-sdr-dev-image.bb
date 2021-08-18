SUMMARY = "An image with a development/debug environment suitable for building GNSS-SDR."

LICENSE = "MIT"
PR = "r3"

require native-sdk.inc
require version-image.inc

IMAGE_FEATURES += " \
    debug-tweaks \
    dev-pkgs \
    package-management \
    splash \
    ssh-server-openssh \
    tools-debug \
    tools-sdk \
"

EXTRA_IMAGE_FEATURES:remove_ettus-e1xx = "tools-profile"
EXTRA_IMAGE_FEATURES:remove_zedboard-zynq7 = "tools-profile"

CORE_IMAGE_EXTRA_INSTALL = "\
    packagegroup-gnss-sdr-base \
    packagegroup-gnss-sdr-base-extended \
    packagegroup-gnss-sdr-drivers \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'xauth', '', d)} \
    e2fsprogs-resize2fs \
"

SDK_NAME = "${DISTRO}-${SDK_ARCH}-${IMAGE_BASENAME}-${MACHINE}"

inherit core-image image-buildinfo
