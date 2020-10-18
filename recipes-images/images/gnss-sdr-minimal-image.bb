SUMMARY = "A spartan image with the GNSS-SDR binary and required environment"

LICENSE = "MIT"
PR = "r2"

require version-image.inc

IMAGE_FEATURES += " \
    debug-tweaks \
    splash \
    ssh-server-openssh \
"

IMAGE_INSTALL += " \
    packagegroup-gnss-sdr-bin \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'xauth', '', d)} \
    e2fsprogs-resize2fs \
"

inherit core-image image-buildinfo
