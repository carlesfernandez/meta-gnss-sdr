FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_raspberrypi3 = " file://0001-Fix-kernel-blacklist.patch"
