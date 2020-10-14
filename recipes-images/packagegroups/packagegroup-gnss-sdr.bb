SUMMARY = "Packagegroup definitions to help the GNSS-SDR community build \
 images they like."

LICENSE = "MIT"
PR = "r3"

inherit packagegroup

PACKAGES = " \
    packagegroup-gnss-sdr-base \
    packagegroup-gnss-sdr-drivers \
    packagegroup-gnss-sdr-base-extended \
    packagegroup-gnss-sdr-buildessential \
    packagegroup-gnss-sdr-bin \
"

PROVIDES = "${PACKAGES}"

SUMMARY_packagegroup-gnss-sdr-base = "Required packages."
RDEPENDS_packagegroup-gnss-sdr-base = " \
    armadillo \
    boost \
    gflags \
    gflags-bash-completion \
    glog \
    gnss-sdr-monitor \
    gnss-simulator \
    gnuplot \
    gnuplot-x11 \
    gnuradio \
    gnutls \
    gpstk \
    gtest \
    hdf5 \
    lapack \
    libpcap \
    log4cpp \
    matio \
    protobuf \
    pugixml \
    python3-mako \
    volk \
"

SUMMARY_packagegroup-gnss-sdr-bin = "GNSS-SDR binary."
RDEPENDS_packagegroup-gnss-sdr-bin = " \
    gnss-sdr \
"

SUMMARY_packagegroup-gnss-sdr-drivers = "RF front-end drivers and utilities."
RDEPENDS_packagegroup-gnss-sdr-drivers = " \
    ezdma \
    gqrx \
    gr-osmosdr \
    gr-iio \
    iio-oscilloscope \
    libad9361-iio \
    libad9361-iio-dev \
    libhackrf \
    libiio \
    libiio-iiod \
    libiio-tests \
    rtl-sdr \
"

SUMMARY_packagegroup-gnss-sdr-base-extended = "Basic packages for an image with regular UNIX utilities."
RDEPENDS_packagegroup-gnss-sdr-base-extended = "\
    alsa-utils \
    base-passwd \
    bash \
    bind \
    bzip2 \
    ca-certificates \
    cifs-utils \
    coreutils \
    cpio \
    devmem2 \
    dhcp-client \
    diffutils \
    directfb-examples \
    dnsmasq \
    e2fsprogs \
    file \
    findutils \
    gawk \
    gdb \
    git \
    gpsd \
    grep \
    gzip \
    hostapd \
    htop \
    i2c-tools \
    inetutils \
    iperf3 \
    iproute2 \
    iw \
    kmod \
    less \
    liberation-fonts \
    libsodium \
    libudev \
    libuio \
    lighttpd \
    linux-firmware \
    lsuio \
    nano \
    ncurses \
    net-tools \
    nfs-utils-client \
    ntp \
    ntp-utils \
    ntpdate \
    openssh-sftp \
    openssh-sftp-server \
    parted \
    patch \
    perf \
    pm-utils \
    procps \
    psmisc \
    python3 \
    python3-distutils \
    python3-pip \
    python3-pyyaml \
    rsync \
    screen \
    sed \
    shadow \
    sqlite3 \
    sshfs-fuse \
    tar \
    tcpdump \
    time \
    unzip \
    util-linux \
    vim \
    vim-vimrc \
    wget \
    which \
    wpa-supplicant \
    xinput-calibrator \
    xserver-xorg \
    xz \
    zip \
    zlib \
    ${@bb.utils.contains("DISTRO_FEATURES", "systemd", "", "debianutils-run-parts", d)} \
    ${@bb.utils.contains("DISTRO_FEATURES", "systemd", "", "dhcp-server", d)} \
    ${@bb.utils.contains("DISTRO_FEATURES", "systemd", "", "dpkg-start-stop", d)} \
    ${@bb.utils.contains("DISTRO_FEATURES", "systemd", "", "ifupdown", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "keyboard", "kbd", "", d)} \
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
    cmake \
    make \
    ninja \
    libgfortran \
    libgfortran-dev \
    libstdc++ \
    libstdc++-dev \
    libtool \
    pkgconfig \
"
