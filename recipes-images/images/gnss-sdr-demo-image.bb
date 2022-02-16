require version-image.inc

SUMMARY = "An image with the GNSS-SDR binary and the Xfce desktop environment"
LICENSE = "MIT"
PR = "r6"

inherit core-image image-buildinfo

require recipes-images/images/geniux-users.inc

IMAGE_FEATURES += " \
    ssh-server-openssh \
    splash \
"

EXTRA_IMAGE_FEATURES += " \
    package-management \
    tools-profile \
"

IMAGE_INSTALL:append = " kernel-modules resize-rootfs"

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

IMAGE_INSTALL:append:zedboard-zynq7 = " u-boot-zynq-uenv"
IMAGE_FSTYPES:append = " wic.xz wic.bmap"
IMAGE_FSTYPES:remove:qemuall = "wic.xz wic.bmap"
WKS_FILE ??= "${TOPDIR}/../meta-gnss-sdr/wic/sdimage-geniux.wks"
