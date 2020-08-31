SUMMARY = "A GNSS-SDR monitor based on Qt"
AUTHOR = "Alvaro Cebrian Juan <acebrianjuan@gmail.com>"
HOMEPAGE = "https://github.com/acebrianjuan/gnss-sdr-monitor"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

DEPENDS = "boost protobuf protobuf-native qtbase qtdeclarative qtquickcontrols qtquickcontrols2 qtlocation qtcharts"

PV = "1.0.git"

SRCREV = "4af0d8d3e385cde52a7c5146fb17c5b9daf1f963"

inherit qmake5 cmake_qt5

OECMAKE_FIND_ROOT_PATH_MODE_PROGRAM = "BOTH"

# Make it easy to test against branches
GIT_BRANCH = "master"

SRC_URI = "git://github.com/acebrianjuan/gnss-sdr-monitor.git;branch=${GIT_BRANCH};protocol=https "

S="${WORKDIR}/git"

PACKAGES = "gnss-sdr-monitor"
