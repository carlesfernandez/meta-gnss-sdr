LINUX_VERSION = "4.14"
ADI_VERSION = "adi_2019"
KBRANCH = "2019_R1"

# needed for offline build
SRCREV = "${@ "b6e379910a11af77e6500ed8b0895006e471a279" if bb.utils.to_boolean(d.getVar('BB_NO_NETWORK')) else d.getVar('AUTOREV')}"
require linux-adi.inc
