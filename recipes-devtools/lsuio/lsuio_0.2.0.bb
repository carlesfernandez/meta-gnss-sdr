DESCRIPTION = "Lists available userspace I/O (UIO) devices"
SECTION = "tools"
LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"
PR = "r2"

HOMEPAGE="https://www.osadl.org/UIO-Archives.uio-archives.0.html"
SRC_URI="https://www.osadl.org/uploads/media/lsuio-${PV}.tar.gz"
SRC_URI[md5sum] = "8da82b681c24e6c5b3518c99e7f961d7"
SRC_URI[sha256sum] = "c88b3850248b2d3419e025abd7b9b0991c8bd33a2d4983f9608408a29900bfb5"

# Make sure our source directory (for the build) matches the directory structure in the tarball
S = "${WORKDIR}/lsuio-${PV}"

PACKAGES = "lsuio-dbg lsuio"

FILES_${PN}-dbg += " \
    /usr/bin/.debug \
    /usr/share \
"

inherit autotools
