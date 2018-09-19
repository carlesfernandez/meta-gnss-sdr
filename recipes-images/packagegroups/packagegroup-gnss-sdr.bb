# packagegroup definitions to help the GNSS-SDR community build images
# they like.

LICENSE = "MIT"

inherit packagegroup

PACKAGES = " \
    packagegroup-gnss-sdr-base \
    packagegroup-gnss-sdr-bin \
"

PROVIDES = "${PACKAGES}"

SUMMARY_packagegroup-gnss-sdr-base = "Required packages."
RDEPENDS_packagegroup-gnss-sdr-base = " \
    gnuradio \
    gflags \
    glog \
    armadillo \
    gtest \
    gnutls \
    log4cpp \
    matio \
    python3-mako \
    python3-six \
    rtl-sdr \
    libbladerf \
    libbladerf-bin \
    libpcap \
    gr-osmosdr \
    gr-iio \
    gnuplot \
    gpstk \
    pm-utils \
"

SUMMARY_packagegroup-gnss-sdr-bin = "GNSS-SDR binary."
RDEPENDS_packagegroup-gnss-sdr-bin = " \
    packagegroup-gnss-sdr-base \
    gnss-sdr \
"
