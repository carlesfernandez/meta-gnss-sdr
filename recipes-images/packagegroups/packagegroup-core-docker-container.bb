SUMMARY = "This packagegroup provides the minimun needed for a docker container"
LICENSE = "MIT"
PR = "r1"

PACKAGE_ARCH = "${TUNE_PKGARCH}"

inherit packagegroup

RDEPENDS:${PN} = "\
    busybox \
    base-files \
    base-passwd \
"
