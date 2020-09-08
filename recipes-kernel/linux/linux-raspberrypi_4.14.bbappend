FILESEXTRAPATHS_prepend := "${THISDIR}/:"

SRC_URI_append_raspberrypi3 = " file://fix-kprobes.patch"
