SUMMARY = "This packagegroup provides the minimun needed for an docker container"
LICENSE = "MIT"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

RDEPENDS_${PN} = "\
		busybox \
		base-files \
		base-passwd \
		"
