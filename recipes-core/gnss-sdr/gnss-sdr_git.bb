SUMMARY = "GNSS-SDR: An open source software defined GNSS receiver"
AUTHOR = "Carles Fernandez-Prades <carles.fernandez@cttc.es>"
HOMEPAGE = "https://gnss-sdr.org"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=31f43bdb1ab7b19dae6e891241ca0568"
PR = "r5"

DEPENDS = "armadillo boost gflags git git-native glog gnsstk gnuplot gnuradio gnutls \
     googletest libad9361-iio libiio libpcap matio pkgconfig protobuf protobuf-native \
     pugixml python3-mako-native volk"

RDEPENDS:${PN} = "gnss-simulator gnuplot-x11"

PACKAGECONFIG ??= " \
     osmosdr \
     zeromq \
     ${@bb.utils.contains("SOC_FAMILY", "zynq", "fpga", "", d)} \
     ${@bb.utils.contains("SOC_FAMILY", "zynqmp", "fpga", "", d)} "

PACKAGECONFIG[alltests] = "-DENABLE_UNIT_TESTING_EXTRA=ON, -DENABLE_UNIT_TESTING_EXTRA=OFF "
PACKAGECONFIG[fpga] = "-DENABLE_FPGA=ON,-DENABLE_FPGA=OFF "
PACKAGECONFIG[logging] = "-DENABLE_LOG=ON,-DENABLE_LOG=OFF "
PACKAGECONFIG[osmosdr] = "-DENABLE_OSMOSDR=ON,-DENABLE_OSMOSDR=OFF,rtl-sdr gr-osmosdr, "
PACKAGECONFIG[zeromq] = "-DENABLE_ZMQ=ON,-DENABLE_ZMQ=OFF "

inherit distutils3-base cmake pkgconfig python3native

EXTRA_OECMAKE += " \
     -DENABLE_SYSTEM_TESTING_EXTRA=ON \
     -DCMAKE_INSTALL_PREFIX=/usr \
     -DENABLE_PLUTOSDR=ON \
     -DENABLE_FMCOMMS2=ON \
     -DENABLE_AD9361=ON \
     -DENABLE_RAW_UDP=ON \
     -DENABLE_INSTALL_TESTS=ON \
     -DENABLE_PACKAGING=ON \
     -DENABLE_GNSS_SIM_INSTALL=OFF \
"

PV = "0.0.19.git"

SRCREV = "9c6a312226e9bf906d38760329faf9b481b5c103"

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
