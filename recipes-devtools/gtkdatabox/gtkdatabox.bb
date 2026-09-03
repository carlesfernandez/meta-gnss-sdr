SUMMARY = "A GTK widget to display large sets of data as dots (or lines)"
HOMEPAGE = "https://github.com/erikd/gtkdatabox"
LICENSE = "LGPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6f256a235d543063c2bfb726feda0a13"
PR = "r0"

PV = "1.0"

SRC_URI = "https://sourceforge.net/projects/gtkdatabox/files/gtkdatabox-1/gtkdatabox-1.0.0.tar.gz \
          file://0001-remove-example.patch \
          "

SRC_URI[md5sum] = "db3a37a4495e18533cfed42f556a59f6"
SRC_URI[sha256sum] = "8bee70206494a422ecfec9a88d32d914c50bb7a0c0e8fedc4512f5154aa9d3e3"

S = "${UNPACKDIR}/gtkdatabox-1.0.0"

DEPENDS = "pkgconfig gtk+3 gtk-doc-native glade pango cairo glib-2.0 glib-2.0-native"

inherit autotools pkgconfig
