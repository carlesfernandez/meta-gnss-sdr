# packagegroup definitions to help the GNSS-SDR community build images
# they like.

LICENSE = "MIT"

inherit packagegroup

PACKAGES = "\
    packagegroup-gnss-sdr-base \
    packagegroup-gnss-sdr-bin \
"

PROVIDES = "${PACKAGES}"

SUMMARY_packagegroup-gnss-sdr-base = "Required packages."
RDEPENDS_packagegroup-gnss-sdr-base = "\
    gnuradio \
    python-mako \
    python-six \
    openssh \
    gr-ettus \
    gr-osmosdr \
    uhd \
    rtl-sdr \
    libbladerf \
    libbladerf-bin \
    gflags \
    glog \
    armadillo \
    gtest \
"

SUMMARY_packagegroup-gnss-sdr-bin = "GNSS-SDR binary"
DEPENDS_packagegroup-gnss-sdr-bin = "\
    gnuradio \
    python-mako \
    python-six \
    gr-ettus \
    gr-osmosdr \
    uhd \
    rtl-sdr \
    libbladerf \
    libbladerf-bin \
    gflags \
    glog \
    armadillo \
    gnss-sdr \
"

