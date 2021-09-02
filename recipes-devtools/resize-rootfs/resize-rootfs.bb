DESCRIPTION = "Resize Rootfs systemd service"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"
PV = "1.0"
PR = "r0"

RDEPENDS_${PN} = "e2fsprogs-resize2fs parted"

SRC_URI = "file://resize-rootfs.sh"

inherit update-rc.d

INITSCRIPT_NAME = "resize-rootfs"
INITSCRIPT_PARAMS = "start 10 S ."

do_install () {
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/resize-rootfs.sh ${D}${sysconfdir}/init.d/${PN}
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
