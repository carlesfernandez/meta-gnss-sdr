require version-image.inc

SUMMARY = "An image with the GNSS-SDR binary and the Xfce desktop environment"
LICENSE = "MIT"
PR = "r4"

inherit core-image image-buildinfo

IMAGE_FEATURES += " \
    debug-tweaks \
    ssh-server-openssh \
    splash \
"

EXTRA_IMAGE_FEATURES += " \
    package-management \
    tools-profile \
"

IMAGE_INSTALL:append = " kernel-modules"

CORE_IMAGE_EXTRA_INSTALL += " \
    packagegroup-core-boot \
    packagegroup-gnss-sdr-bin \
    packagegroup-gnss-sdr-base \
    packagegroup-gnss-sdr-base-extended \
    packagegroup-gnss-sdr-drivers \
    packagegroup-xfce-extended \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'xauth', '', d)} \
    e2fsprogs-resize2fs \
"

IMAGE_FSTYPES:append = " wic.xz wic.bmap"
WKS_FILE ??= "${TOPDIR}/../meta-gnss-sdr/wic/sdimage-geniux.wks"
