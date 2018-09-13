FORTRAN = ",fortran"

PACKAGES += "\
    libgfortran \
    libgfortran-dev \
    libgfortran-staticdev \
"

FILES_libgfortran += "/usr/lib/libgfortran.so.*"

FILES_libgfortran-dev += "\
    /usr/lib/libgfortran*.so \
    /usr/lib/libgfortran.spec \
    /usr/lib/libgfortran.la \
    /usr/lib/gcc/${TARGET_SYS}/${BINV}/libgfortranbegin.* \
    /usr/lib/gcc/${TARGET_SYS}/${BINV}/finclude/ \
"

FILES_libgfortran-staticdev += "\
    /usr/lib/libgfortran.a \
    /usr/lib/gcc/${TARGET_SYS}/${BINV}/libcaf_single.a \
"
