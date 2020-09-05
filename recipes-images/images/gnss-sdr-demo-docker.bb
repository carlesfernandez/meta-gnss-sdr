SUMMARY = "An image that builds a Docker image containing GNSS-SDR."
EXTRA_IMAGE_FEATURES += "tools-debug tools-profile tools-sdk dev-pkgs"
LICENSE = "MIT"

require core-image-container.bb
require gnuradio-dev-image.bb

RDEPENDS_packagegroup-sdr-base-python += " python3-six"

SDK_EXTRA_TOOLS += "nativesdk-python3-six"

IMAGE_INSTALL += " \
                 packagegroup-gnss-sdr-base \
                 packagegroup-gnss-sdr-drivers \
                 packagegroup-gnss-sdr-bin \
                "

# set a meaningful name  and tag for the docker output image
DOCKER_IMAGE_TAG = "latest"
DOCKER_IMAGE_NAME_EXPORT = "gnsssdr-demo-arm32v7:${DOCKER_IMAGE_TAG}"
