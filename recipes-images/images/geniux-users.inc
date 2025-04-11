inherit extrausers

# All passwords set to 'geniux' (without quotes)
# Encrypt password from commandline:
# mkpasswd -m sha-512 -S `pwgen 12 1` 'mypassword' | sed 's/\$/\\$/g'

EXTRA_USERS_PARAMS = " \
    usermod -p '\$6\$ainie6Mee7xi\$nw3Jfaq0k3C9EUPfVU5b/V9oBAz17q9ZEEZa7b3uNY87wBznnNM3MZ597U5Slr9kfVp.39NJp6L2Sx.QHZYEg1' root; \
    useradd -p '\$6\$fu3ieZier3di\$Ch0Gl3g9BHa9c7CJ10Krxru5gtfIYq0Lp8a8nZrWS2e5UPwI62vOpuQ1P1lMzm92rk2L.LH/sP03BNRdWkvaj/' geniux; \
    usermod -a -G sudo geniux; \
"

EXTRA_USERS_PARAMS:append:rpi = " \
    useradd -p '\$6\$ohJ0wo2pheib\$Y.T.u9SxLEqEm7d3iJ5XT5AJ4L6utWWfcBDeaLKEynLpyLx9w356q9Bj/SwHrHdzfuBG2Bj.gbpu/s9T3YdTU0' pi; \
    usermod -a -G sudo pi; \
"

IMAGE_INSTALL:append = " sudo"
