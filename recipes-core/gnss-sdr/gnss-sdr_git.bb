SUMMARY = "GNSS-SDR: An open source software defined GNSS receiver"
AUTHOR = "Carles Fernandez-Prades <carles.fernandez@cttc.es>"
HOMEPAGE = "https://gnss-sdr.org"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=31f43bdb1ab7b19dae6e891241ca0568"
PR = "r9"

DEPENDS = "abseil-cpp armadillo boost git git-native gnsstk gnuplot gnuradio gnutls \
     googletest libpcap matio pkgconfig protobuf protobuf-native \
     pugixml python3-mako-native volk"

RDEPENDS:${PN} = "gnss-simulator gnuplot-x11"

GNSSSDR_DRIVER_DEPS = "${@bb.utils.contains("SOC_FAMILY", "zynq", "ad9361 max2771", "fmcomms2 logging osmosdr plutosdr uhd", d)} "

PACKAGECONFIG ??= " \
     zeromq \
     ${@bb.utils.contains("SOC_FAMILY", "zynqmp", "ad9361 max2771", "${GNSSSDR_DRIVER_DEPS}", d)} "

# General flags
PACKAGECONFIG[alltests] = "-DENABLE_UNIT_TESTING_EXTRA=ON, -DENABLE_UNIT_TESTING_EXTRA=OFF "
PACKAGECONFIG[logging] = "-DENABLE_LOG=ON,-DENABLE_LOG=OFF "

# Signal sources
PACKAGECONFIG[customplutosdr] = "-DENABLE_AD936X_SDR=ON,-DENABLE_AD936X_SDR=OFF,libiio libad9361-iio "
PACKAGECONFIG[fmcomms2] = "-DENABLE_FMCOMMS2=ON,-DENABLE_FMCOMMS2=OFF,libiio libad9361-iio "
PACKAGECONFIG[osmosdr] = "-DENABLE_OSMOSDR=ON,-DENABLE_OSMOSDR=OFF,rtl-sdr gr-osmosdr, "
PACKAGECONFIG[plutosdr] = "-DENABLE_PLUTOSDR=ON,-DENABLE_PLUTOSDR=OFF,libiio libad9361-iio "
PACKAGECONFIG[uhd] = "-DENABLE_UHD=ON,-DENABLE_UHD=OFF "
PACKAGECONFIG[zeromq] = "-DENABLE_ZMQ=ON,-DENABLE_ZMQ=OFF "

# Signal sources for FPGA
PACKAGECONFIG[ad9361] = "-DENABLE_FPGA=ON -DENABLE_AD9361=ON,-DENABLE_AD9361=OFF,libiio libad9361-iio "
PACKAGECONFIG[max2771] = "-DENABLE_FPGA=ON -DENABLE_MAX2771=ON,-DENABLE_MAX2771=OFF "

inherit setuptools3-base cmake pkgconfig

EXTRA_OECMAKE += " \
     -DENABLE_SYSTEM_TESTING_EXTRA=ON \
     -DCMAKE_INSTALL_PREFIX=/usr \
     -DENABLE_RAW_UDP=ON \
     -DENABLE_INSTALL_TESTS=ON \
     -DENABLE_PACKAGING=ON \
     -DENABLE_GNSS_SIM_INSTALL=OFF \
"

PV = "0.0.19.git"

SRCREV = "85f935afe9cb3b8990c9e4352122449550fc44c0"

# Make it easy to test against branches
GIT_BRANCH = "next"

SRC_URI = "git://github.com/gnss-sdr/gnss-sdr.git;branch=${GIT_BRANCH};protocol=https"

S = "${WORKDIR}/git"

PACKAGES = "gnss-sdr-dbg gnss-sdr"

INSANE_SKIP:gnss-sdr:append = "already-stripped"

FILES:${PN} = "${bindir}/ \
     ${bindir}/gnss-sdr \
     ${bindir}/volk_gnsssdr_profile \
     ${bindir}/volk_gnsssdr-config-info \
     ${bindir}/front-end-cal \
     ${bindir}/run_tests \
     ${bindir}/position_test \
     ${bindir}/ttff \
     ${bindir}/rinex2assist \
     ${bindir}/obsdiff \
     ${datadir}/man/man1/volk_gnsssdr-config-info.1.gz \
     ${datadir}/man/man1/gnss-sdr.1.gz \
     ${datadir}/man/man1/front-end-cal.1.gz \
     ${datadir}/man/man1/volk_gnsssdr_profile.1.gz \
     ${datadir}/gnss-sdr/conf/* \
     ${datadir}/doc/gnss-sdr/* \
     ${datadir}/gnss-sdr/signal_samples/* \
     ${datadir}/gnss-sdr/data/* \
"

FILES:${PN}-dbg += " \
     ${prefix}/src/debug/gnss-sdr/* \
     ${bindir}/.debug/volk_gnsssdr-config-info \
     ${bindir}/.debug/gnss-sdr \
     ${bindir}/.debug/volk_gnsssdr_profile \
     ${bindir}/.debug/front-end-cal \
"

do_configure[network] = "1"
