SUMMARY = "A console-only image with a development/debug \
environment suitable for building GNSS-SDR."

#EXTRA_IMAGE_FEATURES += "tools-debug tools-profile tools-sdk dev-pkgs dbg-pkgs"
LICENSE = "MIT"

#TOOLCHAIN_HOST_TASK_append = "libquadmath"
#EXTRA_IMAGE_FEATURES_remove_ettus-e1xx = "tools-profile"

require gnuradio-dev-image.bb

CORE_IMAGE_EXTRA_INSTALL += "\
    packagegroup-gnss-sdr-base \
"
