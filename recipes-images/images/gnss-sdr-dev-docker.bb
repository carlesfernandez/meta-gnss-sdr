require core-image-docker-container.bb
require base-gnss-sdr-dev-image.bb

SUMMARY = "An image that builds a Docker image file with a development environment for GNSS-SDR."
DESCRIPTION = "An image that builds a Docker image of the environment for GNSS-SDR testing purposes."
LICENSE = "MIT"
PR = "r4"

IMAGE_INSTALL += " \
    packagegroup-gnss-sdr-buildessential \
"
IMAGE_FEATURES += "allow-empty-password allow-root-login empty-root-password post-install-logging"

IMAGE_CLASSES += "image_type_docker"
IMAGE_FSTYPES = "docker"

inherit core-image

# set a meaningful name and tag for the docker output image
DOCKER_IMAGE_TAG = "latest"
DOCKER_IMAGE_NAME_EXPORT = "gnsssdr-dev-${MACHINE_ARCH}:${DOCKER_IMAGE_TAG}"
