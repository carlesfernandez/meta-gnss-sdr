SUMMARY = "An image with a development/debug environment suitable \
 for building GNSS-SDR."

LICENSE = "MIT"
PR = "r0"

require native-sdk.inc
require version-image.inc

IMAGE_FEATURES += "splash ssh-server-openssh tools-sdk \
                   tools-debug debug-tweaks \
                   dev-pkgs \
"

EXTRA_IMAGE_FEATURES += " \
    package-management \
    tools-debug \
    tools-profile \
    tools-sdk \
    dev-pkgs \
"

EXTRA_IMAGE_FEATURES_remove_ettus-e1xx = "tools-profile"

CORE_IMAGE_EXTRA_INSTALL = "\
    packagegroup-gnss-sdr-base \
    packagegroup-gnss-sdr-base-extended \
    packagegroup-gnss-sdr-drivers \
    packagegroup-sdr-base-devel \
    packagegroup-sdr-base-python \
    packagegroup-sdr-python-extended \
    packagegroup-sdr-gnuradio-base \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'xauth', '', d)} \
    e2fsprogs-resize2fs \
"

SDK_NAME = "${DISTRO}-${SDK_ARCH}-${IMAGE_BASENAME}-${MACHINE}"

inherit core-image image-buildinfo
