SUMMARY = "This packagegroup provides the minimun needed for a docker container"
LICENSE = "MIT"
PR = "r1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

RDEPENDS_${PN} = "\
    busybox \
    base-files \
    base-passwd \
"
