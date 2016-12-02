RUNTIMETARGET += "libgfortran"

#do_install_append() {
#   install -m 0644 libgfrortran.a ${D}${libdir}
#}

FILES_${PN}-dev += "${prefix}/lib/libgfortran.a \
  ${prefix}/lib//libgfortran.spec \
  ${prefix}/lib/libgfortran.so.3 \
  ${prefix}/lib/libgfortran.so \
  ${prefix}/lib/libgfortran.so.3.0.0 \
  ${prefix}/lib/libgfortran.la \
  ${prefix}/lib/gcc/arm-oe-linux-gnueabi/5.2.0/libcaf_single.la \
  ${prefix}/lib/gcc/arm-oe-linux-gnueabi/5.2.0/libgfortranbegin.a \
  ${prefix}/lib/gcc/arm-oe-linux-gnueabi/5.2.0/libgfortranbegin.la \
  ${prefix}/lib/gcc/arm-oe-linux-gnueabi/5.2.0/libcaf_single.a \
  ${prefix}/lib//gcc/arm-oe-linux-gnueabi/5.2.0/finclude \
  ${prefix}/lib//gcc/arm-oe-linux-gnueabi/5.2.0/finclude/ieee_arithmetic.mod \
  ${prefix}/lib/gcc/arm-oe-linux-gnueabi/5.2.0/finclude/ieee_exceptions.mod \
  ${prefix}/lib/gcc/arm-oe-linux-gnueabi/5.2.0/finclude/ieee_features.mod"
