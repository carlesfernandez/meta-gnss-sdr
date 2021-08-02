DESCRIPTION = "FFTW"
SECTION = "libs"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"
PR = "r0"

SRC_URI = " \
    http://www.fftw.org/fftw-${PV}.tar.gz \
    file://0001-disable-neon.patch \
"
SRC_URI[md5sum] = "50145bb68a8510b5d77605f11cadf8dc"
SRC_URI[sha256sum] = "bf2c7ce40b04ae811af714deb512510cc2c17b9ab9d6ddcf49fe4487eea7af3d"

inherit autotools pkgconfig

# we had multiple recipes in the past
PROVIDES = "fftwl fftwf"

EXTRA_OECONF = "--disable-fortran --enable-shared --enable-threads"

CFLAGS += "-D_GNU_SOURCE"

# neon is optional for arm version < 8 -> check tune features
# FFTW_NEON = "${@bb.utils.contains('TUNE_FEATURES', 'neon', '--enable-neon', '', d)}"
# neon is suppored for arm version = 8 -> enable
# FFTW_NEON_aarch64 = "--enable-neon"

FFTW_NEON = ""
FFTW_NEON_class-native = ""

do_configure() {
    # configure fftw
    rm -rf ${WORKDIR}/build-fftw
	mkdir -p ${B}
    cd ${B}
    # full (re)configure
    autotools_do_configure
    mv ${B} ${WORKDIR}/build-fftw

    # configure fftwl
    rm -rf ${WORKDIR}/build-fftwl
	mkdir -p ${B}
    cd ${B}
    # configure only
    oe_runconf  --enable-long-double
    mv ${B} ${WORKDIR}/build-fftwl

    # configure fftwf
    rm -rf ${WORKDIR}/build-fftwf
	mkdir -p ${B}
    cd ${B}
    # configure only
    oe_runconf --enable-single ${FFTW_NEON}
    mv ${B} ${WORKDIR}/build-fftwf
}

do_compile() {
    for lib in fftw fftwl fftwf; do
        cd ${WORKDIR}/build-$lib
        autotools_do_compile
    done
}

do_install() {
    for lib in fftw fftwl fftwf; do
        cd ${WORKDIR}/build-$lib
        autotools_do_install
    done
}


PACKAGES =+ "libfftw libfftwl libfftwf"
FILES_libfftw = "${libdir}/libfftw3.so.* ${libdir}/libfftw3_*.so.*"
FILES_libfftwl = "${libdir}/libfftw3l.so.* ${libdir}/libfftw3l_*.so.*"
FILES_libfftwf = "${libdir}/libfftw3f.so.* ${libdir}/libfftw3f_*.so.*"

PACKAGES =+ "fftw-wisdom fftwl-wisdom fftwf-wisdom fftw-wisdom-to-conf"
FILES_fftw-wisdom = "${bindir}/fftw-wisdom"
FILES_fftwl-wisdom = "${bindir}/fftwl-wisdom"
FILES_fftwf-wisdom = "${bindir}/fftwf-wisdom"
FILES_fftw-wisdom-to-conf = "${bindir}/fftw-wisdom-to-conf"

FILES_${PN}-dev += "${libdir}/cmake"
RDEPENDS_${PN}-dev = "libfftw libfftwl libfftwf"

BBCLASSEXTEND = "native"
