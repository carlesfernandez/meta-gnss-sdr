SUMMARY = "Minimal docker image"
DESCRIPTION = "This image is not meant to be booted. It is intended to be \
 loaded by docker via the docker load command."
LICENSE = "MIT"

IMAGE_INSTALL = " \
    packagegroup-core-docker-container \
"

IMAGE_CLASSES += "image_type_docker"
IMAGE_FSTYPES = "docker"

inherit core-image

# set a meaningful name and tag for the docker output image
DOCKER_IMAGE_TAG = "latest"
DOCKER_IMAGE_NAME_EXPORT = "core-image-docker-container:${DOCKER_IMAGE_TAG}"
