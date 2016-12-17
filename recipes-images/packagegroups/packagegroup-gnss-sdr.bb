# packagegroup definitions to help the GNSS-SDR community build images
# they like.

LICENSE = "MIT"

inherit packagegroup

PACKAGES = "\
    packagegroup-gnss-sdr-base \
"

PROVIDES = "${PACKAGES}"

SUMMARY_packagegroup-gnss-sdr-base = "Required packages."
RDEPENDS_packagegroup-gnss-sdr-base = "\
    gnuradio \
    gr-ettus \
    gr-osmosdr \
    uhd \
    rtl-sdr \
    libbladerf \
    libbladerf-bin \
    gflags \
    glog \ 
    armadillo \
"


