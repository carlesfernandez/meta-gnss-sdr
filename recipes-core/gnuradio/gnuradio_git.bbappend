# Update GNU Radio recipe so we can build gr-uhd

SRC_URI = "git://github.com/${GITHUB_USER}/gnuradio.git;branch=${GIT_BRANCH};protocol=https \
           file://0001-Use-python-relative-path-for-swig-so-we-can-find-mod.patch \
           file://0001-For-crossompiling-assume-we-are-using-python3.patch \
           file://0001-When-cross-compiling-gnuradio-change-how-the-test-fi.patch \
           file://run-ptest \
"

SRCREV = "4a84443c3767acf2c088e80822be1d533f07f2aa"
PV = "3.8.2+git${SRCPV}"
