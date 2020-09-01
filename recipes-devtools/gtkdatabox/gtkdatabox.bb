SUMMARY = "A GTK widget to display large sets of data as dots (or lines)"
HOMEPAGE = "https://github.com/erikd/gtkdatabox"
LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=7fbc338309ac38fefcd64b04bb903e34"

PV = "0.9.3.1.GTK2"

GIT_BRANCH = "GTK2"
SRC_URI = "git://git.code.sf.net/p/gtkdatabox/git;branch=${GIT_BRANCH};protocol=https \
           file://0001-remove-example.patch \
           "
SRCREV = "e877aecac861042b4da5bf209dc9178583d7d2f7"

S = "${WORKDIR}/git"

DEPENDS += " pkgconfig gtk+ gtk-doc pango cairo"

inherit autotools pkgconfig
