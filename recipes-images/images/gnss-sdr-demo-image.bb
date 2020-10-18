require base-gnss-sdr-dev-image.bb

SUMMARY = "An image with the GNSS-SDR binary and required environment"
LICENSE = "MIT"
PR = "r3"

IMAGE_INSTALL += " \
    packagegroup-xfce-extended \
    packagegroup-gnss-sdr-bin \
"
