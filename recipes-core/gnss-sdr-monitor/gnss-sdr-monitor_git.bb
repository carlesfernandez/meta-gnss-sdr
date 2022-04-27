SUMMARY = "A GNSS-SDR monitor based on Qt5"
DESCRIPTION = "A graphical user interface developed with Qt5 for monitoring the status of GNSS-SDR in real time."
AUTHOR = "Alvaro Cebrian Juan <acebrianjuan@gmail.com>"
HOMEPAGE = "https://github.com/acebrianjuan/gnss-sdr-monitor"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"
PR = "r3"

DEPENDS = "boost protobuf protobuf-native qtbase qtdeclarative \
    qtquickcontrols qtquickcontrols2 qtlocation qtcharts \
"

PV = "1.0.git"

SRCREV = "bd25e434a11d8640a5eb74b9ec70943d7926914c"

inherit qmake5 cmake_qt5

# Make it easy to test against branches
GIT_BRANCH = "master"

SRC_URI = "git://github.com/acebrianjuan/gnss-sdr-monitor.git;branch=${GIT_BRANCH};protocol=https"

S = "${WORKDIR}/git"

PACKAGES = "gnss-sdr-monitor gnss-sdr-monitor-dbg"

FILES:${PN} += " ${bindir}/gnss-sdr-monitor"

FILES:${PN}-dbg += " \
     ${bindir}/.debug/* \
"
