PACKAGECONFIG[iio] = "-DENABLE_GR_IIO=ON,-DENABLE_GR_IIO=OFF,libad9361-iio libiio bison-native, "

GR_PACKAGES += "gnuradio-iio"

FILES:${PN}-iio = "${PYTHON_SITEPACKAGES_DIR}/gnuradio/iio \
    ${datadir}/gnuradio/iio"

# Do not use removed recipe python3-sip3
PACKAGECONFIG[qtgui5] = "-DENABLE_GR_QTGUI=ON \
    ,-DENABLE_GR_QTGUI=OFF,qtbase python3-pyqt qwt-qt5, "
