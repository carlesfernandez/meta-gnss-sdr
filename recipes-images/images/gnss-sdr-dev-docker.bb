require core-image-docker-container.bb
require base-gnss-sdr-dev-image.bb

SUMMARY = "An image that builds a Docker image file with a development environment for GNSS-SDR."
DESCRIPTION = "An image that builds a Docker image of the environment for GNSS-SDR testing purposes."
LICENSE = "MIT"
PR = "r2"

EXTRA_IMAGE_FEATURES += "tools-debug tools-profile tools-sdk dev-pkgs"

IMAGE_INSTALL = " \
    packagegroup-core-docker-container \
    packagegroup-gnss-sdr-base \
    packagegroup-gnss-sdr-base-extended \
    packagegroup-gnss-sdr-drivers \
"

CORE_IMAGE_EXTRA_INSTALL += " \
    packagegroup-gnss-sdr-buildessential \
"

IMAGE_CLASSES += "image_type_docker"
IMAGE_FSTYPES = "docker"

inherit core-image

# set a meaningful name and tag for the docker output image
DOCKER_IMAGE_TAG = "latest"
DOCKER_IMAGE_NAME_EXPORT = "gnsssdr-dev-arm32v7:${DOCKER_IMAGE_TAG}"
