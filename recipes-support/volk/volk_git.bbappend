PV = "3.2.0+git${SRCPV}"
SRCREV = "a1da2495861f2045b911c8050902734f92227b54"
SRC_URI = "gitsm://github.com/gnuradio/volk.git;branch=main;protocol=https \
           file://0001-Do-not-compile-compiler-flags-into-volk.-This-leaks-.patch \
           file://run-ptest \
          "
