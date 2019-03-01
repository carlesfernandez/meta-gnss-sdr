DEPENDS = "git boost python3-mako-native python3-six-native"
SRCREV = "dd5e293c85975d4db6718aef685b1a15de88a74f"
EXTRA_OECMAKE += " -DPYTHON_EXECUTABLE=/usr/bin/python3 "
FILES_${PN} += " /usr/lib/python3/dist-packages/volk_modtool/* "
