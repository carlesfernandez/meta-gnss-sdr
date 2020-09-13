SUMMARY = "A GTK widget to display large sets of data as dots (or lines)"
HOMEPAGE = "https://github.com/erikd/gtkdatabox"
LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=7fbc338309ac38fefcd64b04bb903e34"

GIT_BRANCH = "GTK2"
SRC_URI = "git://git.code.sf.net/p/gtkdatabox/git;branch=${GIT_BRANCH} "
SRCREV = "e877aecac861042b4da5bf209dc9178583d7d2f7"

SRC_URI += "file://remove_examples.patch;patchdir=${S};md5=6b0db4cc368edad1a53fdcaaf2a8f845"

S = "${WORKDIR}/git"

DEPENDS += " pkgconfig gtk+ gtk-doc pango cairo libglade"

#EXTRA_OECONF_append=" --host=arm-non-eabi"
inherit autotools pkgconfig



