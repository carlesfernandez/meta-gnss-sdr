SUMMARY = "GNSS-SDR: An open source software defined GNSS receiver"
AUTHOR = "Carles Fernandez-Prades <carles.fernandez@cttc.es>"
HOMEPAGE = "https://gnss-sdr.org"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=31f43bdb1ab7b19dae6e891241ca0568"
PR = "r7"

DEPENDS = "armadillo boost gflags glog gnuradio gpstk gtest git git-native gnutls \
     libad9361-iio libiio libpcap matio pkgconfig protobuf protobuf-native pugixml \
     python3-mako-native volk"

RDEPENDS_${PN} = "gnuplot gnss-simulator"

PACKAGECONFIG ??= " \
     osmosdr \
     zeromq \
     ${@bb.utils.contains("SOC_FAMILY", "zynq", "fpga", "", d)} \
     ${@bb.utils.contains("SOC_FAMILY", "zynqmp", "fpga", "", d)} "

PACKAGECONFIG[alltests] = "-DENABLE_UNIT_TESTING_EXTRA=ON, -DENABLE_UNIT_TESTING_EXTRA=OFF "
PACKAGECONFIG[fpga] = "-DENABLE_FPGA=ON,-DENABLE_FPGA=OFF "
PACKAGECONFIG[gr-iio] = "-DENABLE_FMCOMMS2=ON,-DENABLE_FMCOMMS2=OFF,gr-iio, "
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

SRCREV = "7ce4f623448069f3374197f1f32971d1221483fd"

# Make it easy to test against branches
GIT_BRANCH = "next"

SRC_URI = "git://github.com/gnss-sdr/gnss-sdr.git;branch=${GIT_BRANCH};protocol=https"

S = "${WORKDIR}/git"

PACKAGES = "gnss-sdr-dbg gnss-sdr"

INSANE_SKIP_gnss-sdr_append = "already-stripped"

FILES_${PN} = "${bindir}/ \
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

FILES_${PN}-dbg += " \
     ${prefix}/src/debug/gnss-sdr/* \
     ${bindir}/.debug/volk_gnsssdr-config-info \
     ${bindir}/.debug/gnss-sdr \
     ${bindir}/.debug/volk_gnsssdr_profile \
     ${bindir}/.debug/front-end-cal \
"
