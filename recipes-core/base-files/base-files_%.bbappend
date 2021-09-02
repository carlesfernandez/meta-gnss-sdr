# Add welcome message on login

do_install_append () {
    echo -e "Hello there! \n" > ${D}${sysconfdir}/motd
    echo -e "This is Geniux, an Operating System for developing and running GNSS-SDR\n" >> ${D}${sysconfdir}/motd
    echo -e "on embedded devices.\n\n" >> ${D}${sysconfdir}/motd
    echo -e "  * Please remember to run volk_profile and volk_gnsssdr_profile\n" >> ${D}${sysconfdir}/motd
    echo -e "    if you have not done so yet (only needs to be done once).\n\n" >> ${D}${sysconfdir}/motd
    echo -e "Enjoy and have fun.\n\n" >> ${D}${sysconfdir}/motd
}
