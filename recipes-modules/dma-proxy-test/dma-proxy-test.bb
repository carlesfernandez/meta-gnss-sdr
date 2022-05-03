SUMMARY = "Simple dma-proxy-test application"
HOMEPAGE = "https://github.com/Xilinx-Wiki-Projects/software-prototypes/tree/master/linux-user-space-dma"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"
PR = "r0"

SRC_URI = " \
	file://dma-proxy-test.c \
	file://dma-proxy.h \
	file://Makefile \
	file://LICENSE \
"

S = "${WORKDIR}"

DEPENDS = "dma-proxy"

CFLAGS += "-pthread"
LDFLAGS += "-lpthread"

EXTRA_OEMAKE = "'CFLAGS=${CFLAGS}' 'LDFLAGS=${LDFLAGS}'"

do_compile() {
	     oe_runmake
}

do_install() {
	     install -d ${D}${bindir}
	     install -m 0755 dma-proxy-test ${D}${bindir}
}
