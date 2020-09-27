DESCRIPTION = "The glog library implements application-level logging. This \
library provides logging APIs based on C++-style streams and various helper \
macros."
HOMEPAGE = "https://github.com/google/glog"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=dc9db360e0bbd4e46672f3fd91dd6c4b"
PR = "r0"

DEPENDS = "libunwind"

SRC_URI = " \
    git://github.com/google/glog.git;protocol=https \
"

SRCREV = "2063b387080c1e7adffd33ca07adff0eb346ff1a"

S = "${WORKDIR}/git"

PACKAGECONFIG ??= "gflags"
PACKAGECONFIG[gflags] = ",--without-gflags,gflags,"

inherit autotools pkgconfig
