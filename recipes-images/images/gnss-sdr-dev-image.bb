SUMMARY = "A console-only image with a development/debug \
environment suitable for building GNURadio out of tree blocks installed."

#EXTRA_IMAGE_FEATURES += "tools-debug tools-profile tools-sdk dev-pkgs dbg-pkgs"
LICENSE = "MIT"

#EXTRA_IMAGE_FEATURES_remove_ettus-e1xx = "tools-profile"

require gnuradio-dev-image.bb

CORE_IMAGE_EXTRA_INSTALL += "\
    packagegroup-gnss-sdr-base \
"

FORTRAN_TOOLS = " \
    gfortran \
    gfortran-symlinks \
    libgfortran \
    libgfortran-dev \
 "

#IMAGE_INSTALL += "${FORTRAN_TOOLS}"



#require recipes-images/images/native-sdk.inc
#require gnuradio-image.bb

