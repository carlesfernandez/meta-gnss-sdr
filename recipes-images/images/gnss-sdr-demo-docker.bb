SUMMARY = "An image that builds a Docker image containing GNSS-SDR."
EXTRA_IMAGE_FEATURES += "tools-debug tools-profile tools-sdk dev-pkgs"
LICENSE = "MIT"

require core-image-container.bb
require gnuradio-dev-image.bb

RDEPENDS_packagegroup-sdr-base-python += " python3-six"

SDK_EXTRA_TOOLS += "nativesdk-python3-six"

IMAGE_INSTALL = " \
                 packagegroup-core-container \
                 packagegroup-gnss-sdr-base \
                "

CORE_IMAGE_EXTRA_INSTALL += " \
    gnss-sdr \
"

IMAGE_CLASSES += "image_type_docker"
IMAGE_FSTYPES = "docker"

inherit core-image

# set a meaningful name  and tag for the docker output image
DOCKER_IMAGE_TAG = "latest"
DOCKER_IMAGE_NAME_EXPORT = "gnsssdr-dev-arm32v7:${DOCKER_IMAGE_TAG}"
