DESCRIPTION = "Python library to make python 2 and 3 programs more compatible."
HOMEPAGE = "http://pysnmp.sourceforge.net/"
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=530f34047c21ad45b3199946dd90bea5"
DEPENDS = "python"

SRC_URI = "https://pypi.python.org/packages/source/s/six/six-${PV}.tar.gz"
SRC_URI[md5sum] = "322b86d0c50a7d165c05600154cecc0a"
SRC_URI[sha256sum] = "fc6beeffdd8fc76b783287eb77d093425d0710920aae2c70acd693c52d7e8cf8"

S = "${WORKDIR}/six-${PV}"

inherit setuptools

RDEPENDS_${PN} += "python-lang python-shell python-io"
BBCLASSEXTEND = "native nativesdk"

