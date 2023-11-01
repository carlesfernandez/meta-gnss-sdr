SUMMARY = "Recipe for building an external dma-proxy Linux kernel module"
HOMEPAGE = "https://github.com/Xilinx-Wiki-Projects/software-prototypes/tree/master/linux-user-space-dma"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"
PR = "r1"

inherit module
inherit create-spdx

SRC_URI = " \
    file://Makefile \
    file://dma-proxy.c \
    file://dma-proxy.h \
	file://LICENSE \
"

S = "${WORKDIR}"

# The inherit of module.bbclass will automatically name module packages with
# "kernel-module-" prefix as required by the oe-core build environment.

KERNEL_MODULE_AUTOLOAD += "dma-proxy"
