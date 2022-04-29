require core-image-docker-container.bb
require base-gnss-sdr-dev-image.bb

SUMMARY = "An image that builds a Docker image file containing GNSS-SDR."
DESCRIPTION = "An image that builds a Docker image file containing GNSS-SDR for testing purposes."
LICENSE = "MIT"
PR = "r3"

IMAGE_INSTALL += " \
    packagegroup-gnss-sdr-bin \
"

# set a meaningful name and tag for the docker output image
DOCKER_IMAGE_TAG = "latest"
DOCKER_IMAGE_NAME_EXPORT = "gnsssdr-demo-${MACHINE_ARCH}:${DOCKER_IMAGE_TAG}"
