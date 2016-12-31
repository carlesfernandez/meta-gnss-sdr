do_install_prepend() {
        mkdir -p  ${WORKDIR}/image/boot/spl
}

do_deploy_prepend() {
        mkdir -p ${WORKDIR}/deploy-u-boot-xlnx/spl
}
