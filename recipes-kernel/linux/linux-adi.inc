require recipes-kernel/linux/linux-xlnx.inc

DESCRIPTION = "ADI kernel"
# Default to latest revision
SRCREV ?= "${AUTOREV}"
PV = "${LINUX_VERSION}-${ADI_VERSION}+git${SRCPV}"

SRC_URI = "git://github.com/analogdevicesinc/linux.git;protocol=https;branch=${KBRANCH}"

# override kernel config file
KBUILD_DEFCONFIG_zynq = "zynq_xcomm_adv7511_defconfig"
KBUILD_DEFCONFIG_zynqmp = "adi_zynqmp_defconfig"
KBUILD_DEFCONFIG_microblaze = "adi_mb_defconfig"
