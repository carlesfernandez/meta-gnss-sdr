PACKAGECONFIG[iio] = "-DENABLE_GR_IIO=ON,-DENABLE_GR_IIO=OFF,libad9361-iio libiio bison-native, "

GR_PACKAGES += "gnuradio-iio"

FILES:${PN}-iio = "${PYTHON_SITEPACKAGES_DIR}/gnuradio/iio \
                   ${datadir}/gnuradio/iio"

# Do not use python3-pyqt5, python3-sip3 until fix
PACKAGECONFIG[qtgui5] = "-DENABLE_GR_QTGUI=ON \
                 ,-DENABLE_GR_QTGUI=OFF,qtbase qwt-qt5 \
                 , "