

DEPENDS += " python3-mako python3-mako-native python3-six python3-six-native "

EXTRA_OECMAKE += " -DPYTHON_EXECUTABLE=/usr/bin/python3 "

SRCREV = "0ac820cb4de25ef7791f1c0c540b5d5a748eb90a"
GIT_BRANCH = "fix_fir_filter"

SRC_URI = "git://github.com/carlesfernandez/gnuradio.git;branch=${GIT_BRANCH};protocol=https \
          "
