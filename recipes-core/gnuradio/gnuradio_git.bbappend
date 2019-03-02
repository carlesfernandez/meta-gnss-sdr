DEPENDS += " python3-mako python3-mako-native python3-six python3-six-native bison "

EXTRA_OECMAKE += " -DPYTHON_EXECUTABLE=/usr/bin/python3 "
OECMAKE_GENERATOR = "Unix Makefiles"
TARGET_CFLAGS += " -mfpu=auto "

SRCREV = "0ab1a75a8181e2d89d82b499913d5e30b2bca018"
GIT_BRANCH = "master"

SRC_URI = "gitsm://github.com/gnuradio/gnuradio.git;branch=${GIT_BRANCH};protocol=https \
          "
