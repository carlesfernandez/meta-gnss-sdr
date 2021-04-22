FORTRAN = ",fortran"

PACKAGES += "\
    libgfortran \
    libgfortran-dev \
    libgfortran-staticdev \
"

FILES_libgfortran += "${libdir}/libgfortran.so.*"

FILES_libgfortran-dev += "\
    ${libdir}/libgfortran*.so \
    ${libdir}/libgfortran.spec \
    ${libdir}/libgfortran.la \
    ${libdir}/gcc/${TARGET_SYS}/${BINV}/libgfortranbegin.* \
    ${libdir}/gcc/${TARGET_SYS}/${BINV}/finclude/ \
"

FILES_libgfortran-staticdev += "\
    ${libdir}/libgfortran.a \
    ${libdir}/gcc/${TARGET_SYS}/${BINV}/libcaf_single.a \
"
