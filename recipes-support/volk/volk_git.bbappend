DEPENDS = "git boost python3-mako-native python3-six-native"
SRCREV = "3f3c91ee3ce51a31d8c23398124df74d3aa42955"
EXTRA_OECMAKE += " -DPYTHON_EXECUTABLE=/usr/bin/python3 "
FILES_${PN} += " /usr/lib/python3/dist-packages/volk_modtool/* "
