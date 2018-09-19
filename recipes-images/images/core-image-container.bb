SUMMARY = "Minimal docker image"
DESCRIPTION = "This image is not meant to be booted. It is intended to be loaded by docker via the docker load command."
LICENSE = "MIT"

IMAGE_INSTALL = " \
	         packagegroup-core-container \
		"

COMPATIBLE_MACHINE = "${MACHINE_ARCH}"

IMAGE_CLASSES += "image_type_docker"
IMAGE_FSTYPES = "docker"

inherit core-image
