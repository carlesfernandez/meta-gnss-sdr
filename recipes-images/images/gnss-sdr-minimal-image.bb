SUMMARY = "A spartan image with the GNSS-SDR binary and required environment"

LICENSE = "MIT"
PR = "r1"

require version-image.inc

IMAGE_FEATURES += "splash ssh-server-openssh \
                   debug-tweaks \
                  "

EXTRA_IMAGE_FEATURES += "package-management"

CORE_IMAGE_EXTRA_INSTALL += " \
    gnss-sdr \
    packagegroup-gnss-sdr-base \
    packagegroup-gnss-sdr-base-extended \
    packagegroup-gnss-sdr-drivers \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'xauth', '', d)} \
    e2fsprogs-resize2fs \
"

inherit core-image image-buildinfo
