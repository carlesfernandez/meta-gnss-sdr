DESCRIPTION = "Resize Rootfs systemd service"
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0-or-later;md5=fed54355545ffd980b814dab4a3b312c"
PV = "1.0"
PR = "r0"

RDEPENDS:${PN} = "e2fsprogs-resize2fs parted"

SRC_URI = "file://resize-rootfs.sh"

inherit update-rc.d

INITSCRIPT_NAME = "resize-rootfs"
INITSCRIPT_PARAMS = "start 10 S ."

do_install () {
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/resize-rootfs.sh ${D}${sysconfdir}/init.d/${PN}
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
