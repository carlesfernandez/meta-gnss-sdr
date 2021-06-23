require version-image.inc

SUMMARY = "A spartan image with the GNSS-SDR binary and required environment"
LICENSE = "MIT"
PR = "r3"

inherit core-image image-buildinfo

IMAGE_FEATURES += " \
    debug-tweaks \
    ssh-server-openssh \
    splash \
"

EXTRA_IMAGE_FEATURES += " package-management"

IMAGE_INSTALL_append = " kernel-modules"

CORE_IMAGE_EXTRA_INSTALL += " \
    packagegroup-core-boot \
    packagegroup-gnss-sdr-bin \
    packagegroup-gnss-sdr-base \
    packagegroup-gnss-sdr-base-extended \
    packagegroup-gnss-sdr-drivers \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'xauth', '', d)} \
    e2fsprogs-resize2fs \
"
