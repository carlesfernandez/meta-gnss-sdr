inherit image_types

#no need of an bootimg for docker
deltask do_bootimg

#no need for an kernel either
PREFERRED_PROVIDER_virtual/kernel = ""

# need to be capable to run docker
# the building user needs to be part of the docker group and the docker
# daemon needs to be running
IMAGE_CMD_DOCKER ??= "/usr/bin/docker"

# docker container image defaults
DOCKER_IMAGE_NAME ??= "${IMAGE_NAME}${IMAGE_NAME_SUFFIX}.docker"
DOCKER_IMAGE_TAG ??= "latest"
DOCKER_IMAGE_NAME_EXPORT ??= "${IMAGE_NAME}${IMAGE_NAME_SUFFIX}-export.docker:${DOCKER_IMAGE_TAG}"

# command to fetch the container id
DOCKER_CONTAINER_ID = "$(${IMAGE_CMD_DOCKER} ps -aqf 'ancestor=${DOCKER_IMAGE_NAME}')"

IMAGE_CMD:docker (){
	# create a tar archive that we import to docker
	${IMAGE_CMD_TAR} -cvf - -C ${IMAGE_ROOTFS} . 2>&- | ${IMAGE_CMD_DOCKER} import - ${DOCKER_IMAGE_NAME}

	# these are commands which are meant to be run inside the container for setting up internals
	${DOCKER_EXTRA_CMDS}

	# rename the work container to the output target name
	${IMAGE_CMD_DOCKER} tag ${DOCKER_IMAGE_NAME} ${DOCKER_IMAGE_NAME_EXPORT}

	# save the image to a tar achieve
	${IMAGE_CMD_DOCKER} save --output ${DEPLOY_DIR_IMAGE}/${DOCKER_IMAGE_NAME} ${DOCKER_IMAGE_NAME_EXPORT}

	#remove old imported image (from yocto rootfs)
	${IMAGE_CMD_DOCKER} rmi ${DOCKER_IMAGE_NAME}

	# delete image as we now exported it
	${IMAGE_CMD_DOCKER} rmi ${DOCKER_IMAGE_NAME_EXPORT}

	# compress the resulting image
	cd ${DEPLOY_DIR_IMAGE} && ln -sf ${DOCKER_IMAGE_NAME} ${IMAGE_BASENAME}-${MACHINE}.docker
}

do_save_docker_image_changes(){
	${IMAGE_CMD_DOCKER} commit ${DOCKER_CONTAINER_ID} ${DOCKER_IMAGE_NAME}":updated"

	#remove established container
	${IMAGE_CMD_DOCKER} rm -f ${DOCKER_CONTAINER_ID}

	#overwrite old image[tag]
        ${IMAGE_CMD_DOCKER} tag ${DOCKER_IMAGE_NAME}":updated" ${DOCKER_IMAGE_NAME}

	#remove temporary image
	${IMAGE_CMD_DOCKER} rmi ${DOCKER_IMAGE_NAME}":updated"
}

EXPORT_FUNCTIONS do_save_docker_image_changes
