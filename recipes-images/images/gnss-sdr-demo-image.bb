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

IMAGE_INSTALL_append = " kernel-modules"

PACKAGE_EXCLUDE_raspberrypi3 = "linux-firmware-raspbian-broadcom-license linux-firmware-raspbian-bcm43430"

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
