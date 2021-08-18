SUMMARY = "C++ library that implements commandline flags processing"
DESCRIPTION = "The gflags package contains a C++ library that implements \
 commandline flags processing. It includes built-in support for standard types \
 such as string and the ability to define flags in the source file in which \
 they are used"

HOMEPAGE = "https://github.com/gflags/gflags"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING.txt;md5=c80d1a3b623f72bb85a4c75b556551df"
PR = "r1"

SRC_URI = "git://github.com/gflags/gflags.git;protocol=https"
SRCREV = "827c769e5fc98e0f2a34c47cef953cc6328abced"
S = "${WORKDIR}/git"

FILES:${PN}-dev += "${libdir}/cmake"

inherit cmake

EXTRA_OECMAKE = "-DBUILD_SHARED_LIBS=ON -DREGISTER_INSTALL_PREFIX=OFF -DLIB_INSTALL_DIR=${baselib}"

PACKAGES =+ "${PN}-bash-completion"
FILES:${PN}-bash-completion += "${bindir}/gflags_completions.sh"
RDEPENDS:${PN}-bash-completion = "bash-completion bash"

BBCLASSEXTEND = "native nativesdk"
