FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI += " file://geniux_banner "
FILES:${PN} += " /etc/ssh/geniux_banner "
PR = "r1"

do_install:append() {
    install -d ${D}${sysconfdir}/ssh
    install -m 0644 ${WORKDIR}/geniux_banner ${D}${sysconfdir}/ssh/geniux_banner
    echo "Banner /etc/ssh/geniux_banner" >> ${D}${sysconfdir}/ssh/sshd_config
}
