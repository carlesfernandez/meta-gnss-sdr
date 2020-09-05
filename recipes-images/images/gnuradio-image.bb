SUMMARY = "A console-only image with a development/debug \
environment suitable for building GNURadio out of tree blocks installed."

require version-image.inc

IMAGE_FEATURES += "splash ssh-server-openssh \
                   debug-tweaks \
                  "

EXTRA_IMAGE_FEATURES += "package-management"

LICENSE = "MIT"

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

#    zeroc-ice

#SDK_NAME = "${BPN}-${MACHINE}"

inherit core-image image-buildinfo
