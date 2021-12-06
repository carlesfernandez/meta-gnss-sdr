DEPENDS = "boost python3-mako-native python3-six-native"

inherit python3native cmake pkgconfig

PACKAGECONFIG ??= ""
PACKAGECONFIG[orc] = "-DENABLE_ORC=ON,-DENABLE_ORC=OFF,orc, "
PACKAGECONFIG[staticlibs] = "-DENABLE_STATIC_LIBS=ON,-DENABLE_STATIC_LIBS=OFF "

export BUILD_SYS
export HOST_SYS="${MULTIMACH_TARGET_SYS}"
export STAGING_LIBDIR

PV = "2.2.1"
SRC_URI = "git://github.com/gnuradio/volk.git;branch=main;protocol=https \
           file://0001-Check-for-lib64-verus-lib-and-set-LIB_SUFFIX-accordi.patch \
          "
SRC_URI_append_ettus-e300 = "file://volk_config"

S = "${WORKDIR}/git"

SRCREV = "aae9fed1cd15f0f1695d5adad04c65cf8bbd3cc0"
