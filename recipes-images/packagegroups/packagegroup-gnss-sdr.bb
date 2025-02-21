SUMMARY = "Packagegroup definitions to help the GNSS-SDR community build \
 images they like."

LICENSE = "MIT"
PR = "r8"

PACKAGE_ARCH = "${TUNE_PKGARCH}"

inherit packagegroup

PACKAGES = " \
    packagegroup-gnss-sdr-base \
    packagegroup-gnss-sdr-drivers \
    packagegroup-gnss-sdr-base-extended \
    packagegroup-gnss-sdr-buildessential \
    packagegroup-gnss-sdr-bin \
"

PROVIDES = "${PACKAGES}"

SUMMARY:packagegroup-gnss-sdr-base = "Required packages."
RDEPENDS:packagegroup-gnss-sdr-base = " \
    abseil-cpp \
    armadillo \
    boost \
    fmt \
    gnsstk-dev \
    gnss-simulator \
    gnuplot \
    gnuplot-x11 \
    gnuradio \
    gnutls \
    googletest \
    hdf5 \
    lapack \
    libpcap \
    matio \
    protobuf \
    pugixml \
    python3-mako \
    spdlog \
    volk \
"

SUMMARY:packagegroup-gnss-sdr-bin = "GNSS-SDR binary."
RDEPENDS:packagegroup-gnss-sdr-bin = " \
    gnss-sdr \
"

SUMMARY:packagegroup-gnss-sdr-drivers = "RF front-end drivers and utilities."
RDEPENDS:packagegroup-gnss-sdr-drivers = " \
    gr-osmosdr \
    iio-oscilloscope \
    libad9361-iio \
    libad9361-iio-dev \
    libhackrf \
    libiio \
    libiio-iiod \
    libiio-tests \
    rtl-sdr \
    uhd \
"

SUMMARY:packagegroup-gnss-sdr-base-extended = "Basic packages for an image with regular UNIX utilities."
RDEPENDS:packagegroup-gnss-sdr-base-extended = "\
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
    diffutils \
    directfb-examples \
    dnsmasq \
    e2fsprogs \
    fftw-wisdom \
    fftw-wisdom-to-conf \
    fftwf-wisdom \
    fftwl-wisdom \
    file \
    findutils \
    gawk \
    gdb \
    git \
    git-perltools \
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
    lttng-modules \
    lttng-tools \
    lttng-ust \
    nano \
    ncurses \
    net-tools \
    nfs-utils-client \
    ntp \
    ntp-utils \
    openssh-sftp \
    openssh-sftp-server \
    openssh-sshd \
    parted \
    patch \
    pm-utils \
    procps \
    psmisc \
    pv \
    python3 \
    python3-cython \
    python3-matplotlib \
    python3-modules \
    python3-numpy \
    python3-pip \
    python3-pyyaml \
    rsync \
    screen \
    sed \
    shadow \
    swig \
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
    ${@bb.utils.contains("DISTRO_FEATURES", "systemd", "", "kea", d)} \
    ${@bb.utils.contains("DISTRO_FEATURES", "systemd", "", "dhcpcd", d)} \
    ${@bb.utils.contains("DISTRO_FEATURES", "systemd", "", "dpkg-start-stop", d)} \
    ${@bb.utils.contains("DISTRO_FEATURES", "systemd", "", "ifupdown", d)} \
    ${@bb.utils.contains("DISTRO_FEATURES", "systemd", "", "resolvconf", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "keyboard", "kbd", "", d)} \
"

SUMMARY:packagegroup-gnss-sdr-buildessential = "Essential build dependencies"
RDEPENDS:packagegroup-gnss-sdr-buildessential = "\
    autoconf \
    automake \
    binutils \
    binutils-symlinks \
    cmake \
    cpp \
    cpp-symlinks \
    g++ \
    g++-symlinks \
    gcc \
    gcc-symlinks \
    gettext \
    glib-2.0 \
    libgfortran \
    libgfortran-dev \
    libstdc++ \
    libstdc++-dev \
    libtool \
    make \
    ninja \
    pkgconfig \
"
