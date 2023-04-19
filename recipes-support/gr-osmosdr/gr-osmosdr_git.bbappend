SRC_URI = "git://gitea.osmocom.org/sdr/gr-osmosdr;protocol=https;branch=master"

# Disable Python until fix
EXTRA_OECMAKE = "-DENABLE_DEFAULT=OFF -DENABLE_PYTHON=OFF"