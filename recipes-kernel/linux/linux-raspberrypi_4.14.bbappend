COMPATIBLE_MACHINE = "raspberrypi3"
FILESEXTRAPATHS_prepend := "${THISDIR}/:"
SRC_URI += "file://fix-kprobes.patch"
