# Allow users belonging group 'sudo' to use sudo if they know the password

do_install_append () {
    echo "%sudo ALL=(ALL) ALL" >> ${D}${sysconfdir}/sudoers
}
