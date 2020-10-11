SUMMARY = "An image that builds a Docker image file with GNSS-SDR."
DESCRIPTION = "An image that builds a Docker image of the environment for GNSS-SDR testing purposes."
LICENSE = "MIT"
PR = "r0"

EXTRA_IMAGE_FEATURES += "tools-debug tools-profile tools-sdk dev-pkgs"

require core-image-docker-container.bb
require base-gnss-sdr-dev-image.bb

IMAGE_INSTALL = " \
    packagegroup-core-docker-container \
    packagegroup-gnss-sdr-base \
    packagegroup-gnss-sdr-drivers \
"

CORE_IMAGE_EXTRA_INSTALL += " \
    packagegroup-gnss-sdr-buildessential \
    packagegroup-gnss-sdr-base \
    packagegroup-gnss-sdr-drivers \
    packagegroup-gnss-sdr-base-extended \
"

IMAGE_CLASSES += "image_type_docker"
IMAGE_FSTYPES = "docker"

inherit core-image

# set a meaningful name and tag for the docker output image
DOCKER_IMAGE_TAG = "latest"
DOCKER_IMAGE_NAME_EXPORT = "gnsssdr-dev-arm32v7:${DOCKER_IMAGE_TAG}"
