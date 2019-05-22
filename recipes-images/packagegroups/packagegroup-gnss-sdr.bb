# packagegroup definitions to help the GNSS-SDR community build images
# they like.

LICENSE = "MIT"

inherit packagegroup

PACKAGES = " \
    packagegroup-gnss-sdr-base \
    packagegroup-gnss-sdr-base-extended \
    packagegroup-gnss-sdr-buildessential \
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
    pugixml \
    protobuf \
    rtl-sdr \
    libpcap \
    gr-osmosdr \
    gr-iio \
    gnuplot \
    gnuplot-x11 \
    gpstk \
    pm-utils \
"

SUMMARY_packagegroup-gnss-sdr-bin = "GNSS-SDR binary."
RDEPENDS_packagegroup-gnss-sdr-bin = " \
    packagegroup-gnss-sdr-base \
    gnss-sdr \
"


SUMMARY_packagegroup-gnss-sdr-base-extended = "Basic packages for an image with regular UNIX utilities."
RDEPENDS_packagegroup-gnss-sdr-base-extended = "\
    alsa-utils \
    i2c-tools \
    screen \
    vim \
    vim-vimrc \
    htop \
    iw \
    git \
    sshfs-fuse \
    libudev \
    nano \
    nfs-utils-client \
    cifs-utils \
    openssh-sftp \
    openssh-sftp-server \
    procps \
    protobuf \
    ntp \
    ntpdate \
    ntp-utils \
    linux-firmware \
    libsodium \
    sqlite3 \
    tar \
    wget \
    zip \
    unzip \
    rsync \
    gdb \
    perf \
"

SUMMARY_packagegroup-gnss-sdr-buildessential = "Essential build dependencies"
RDEPENDS_packagegroup-gnss-sdr-buildessential = "\
    autoconf \
    automake \
    binutils \
    binutils-symlinks \
    cpp \
    cpp-symlinks \
    gcc \
    gcc-symlinks \
    g++ \
    g++-symlinks \
    gettext \
    glib-2.0 \
    make \
    ninja \
    libstdc++ \
    libstdc++-dev \
    libtool \
    pkgconfig \
"
