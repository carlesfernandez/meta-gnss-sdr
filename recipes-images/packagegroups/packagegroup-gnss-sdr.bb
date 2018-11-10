# packagegroup definitions to help the GNSS-SDR community build images
# they like.

LICENSE = "MIT"

inherit packagegroup

PACKAGES = " \
    packagegroup-gnss-sdr-base \
    packagegroup-gnss-sdr-bin \
    packagegroup-gnss-sdr-drivers \
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
    uhd \
    python3-mako \
    python3-six \
    pugixml \
    rtl-sdr \
    libbladerf \
    libbladerf-bin \
    libpcap \
    gr-osmosdr \
    gr-iio \
    gnuplot \
    gpstk \
    gnss-simulator \
"

SUMMARY_packagegroup-gnss-sdr-bin = "GNSS-SDR binary."
DEPENDS_packagegroup-gnss-sdr-bin = " \
    gnss-sdr \
"

SUMMARY_packagegroup-gnss-sdr-drivers = "RF front-end drivers."
DEPENDS_packagegroup-gnss-sdr-drivers = " \
    uhd \
    rtl-sdr \
    libbladerf \
    libbladerf-bin \
    gr-osmosdr \
    gr-iio \
"
