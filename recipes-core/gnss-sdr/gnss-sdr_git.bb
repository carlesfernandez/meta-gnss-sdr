SUMMARY = "GNSS-SDR: An open source software defined GNSS receiver"
AUTHOR = "Carles Fernandez-Prades <carles.fernandez@cttc.es>"
HOMEPAGE = "https://gnss-sdr.org"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=31f43bdb1ab7b19dae6e891241ca0568"

DEPENDS = "volk boost gnuradio armadillo gflags glog matio gr-iio libpcap gnutls \
           gtest pugixml gnuplot gpstk git git-native protobuf protobuf-native \
           python3-mako python3-mako-native python3-six python3-six-native"

RDEPENDS_${PN} = "gnss-simulator"

PACKAGECONFIG ??= "osmosdr"

PACKAGECONFIG[osmosdr] = "-DENABLE_OSMOSDR=ON,-DENABLE_OSMOSDR=OFF,rtl-sdr gr-osmosdr, "
PACKAGECONFIG[logging] = "-DENABLE_LOG=ON,-DENABLE_LOG=OFF "

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"

inherit cmake pkgconfig

OECMAKE_FIND_ROOT_PATH_MODE_PROGRAM = "BOTH"

EXTRA_OECMAKE += " -DPYTHON_EXECUTABLE=/usr/bin/python3 \
 -DENABLE_UNIT_TESTING_EXTRA=ON  \
 -DENABLE_SYSTEM_TESTING_EXTRA=ON  \
 -DCMAKE_INSTALL_PREFIX=/usr  \
 -DENABLE_FMCOMMS2=ON  \
 -DENABLE_AD9361=ON  \
 -DENABLE_RAW_UDP=ON  \
 -DENABLE_INSTALL_TESTS=ON \
 -DENABLE_PACKAGING=ON \
 -DENABLE_GNSS_SIM_INSTALL=OFF \
"

PV = "0.0.12.git"

SRCREV = "dcf9bc52c45de51e91b38316e3380900fcbc8264"

# Make it easy to test against branches
GIT_BRANCH = "next"

SRC_URI = "git://github.com/gnss-sdr/gnss-sdr.git;branch=${GIT_BRANCH};protocol=https "

S="${WORKDIR}/git"

PACKAGES = "gnss-sdr-dbg gnss-sdr"

FILES_${PN} = "${bindir}/gnss-sdr \
     ${bindir}/volk_gnsssdr_profile \
     ${bindir}/volk_gnsssdr-config-info \
     ${bindir}/front-end-cal \
     ${bindir}/run_tests \
     ${bindir}/position_test \
     ${bindir}/ttff \
     ${bindir}/rinex2assist \
     ${bindir}/obsdiff \
     /usr/share/man/man1/volk_gnsssdr-config-info.1.gz \
     /usr/share/man/man1/gnss-sdr.1.gz \
     /usr/share/man/man1/front-end-cal.1.gz \
     /usr/share/man/man1/volk_gnsssdr_profile.1.gz \
     /usr/share/gnss-sdr/conf/* \
     /usr/share/doc/gnss-sdr/* \
     /usr/share/gnss-sdr/signal_samples/* \
     /usr/share/gnss-sdr/data/* \
"

FILES_${PN}-dbg += " \
     /usr/src/debug/gnss-sdr/* \
     ${bindir}/.debug/volk_gnsssdr-config-info \
     ${bindir}/.debug/gnss-sdr \
     ${bindir}/.debug/volk_gnsssdr_profile \
     ${bindir}/.debug/front-end-cal \
"
