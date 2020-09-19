inherit distutils3-base cmake pkgconfig python3native

DEPENDS = "git boost python3-mako python3-mako-native python3-six-native"

SRCREV = "3f3c91ee3ce51a31d8c23398124df74d3aa42955"

FILES_${PN} += " /usr/lib/python3/dist-packages/volk_modtool/* "
