SUMMARY = "A spartan image with the GNSS-SDR binary \
and required environment"

LICENSE = "MIT"

require version-image.inc

IMAGE_FEATURES += "splash ssh-server-openssh \
                   debug-tweaks \
                  "

EXTRA_IMAGE_FEATURES += "package-management"

CORE_IMAGE_EXTRA_INSTALL += " \
    gnss-sdr \
    packagegroup-sdr-base-extended \
    packagegroup-sdr-hardware \
    packagegroup-gnss-sdr-base \
    packagegroup-gnss-sdr-drivers \
    packagegroup-gnss-sdr-base-extended \
    xauth \
    e2fsprogs-resize2fs \
"

inherit core-image image-buildinfo
