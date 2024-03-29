#!/bin/sh

set -e

do_expand_rootfs() {
    ROOT_PART=$(cat /proc/cmdline | tr " " "\n" | grep "root=" | cut -f 2 -d '='| cut -f 3 -d '/')
    ROOT_DEV="/dev/$(dirname $(readlink /sys/class/block/${ROOT_PART}) | grep -o '[^/]*$')"
    BASE_DEV=${ROOT_DEV//p*}
    PART_NUM=${ROOT_PART#*p}

    LAST_PART_NUM=$(parted ${BASE_DEV} -ms unit s p | tail -n 1 | cut -f 1 -d:)
    if [ "$LAST_PART_NUM" != "$PART_NUM" ]; then
      echo "/dev/disk/by-label/rootfs is not the last partition. Don't know how to expand"
      return 4
    fi

    # Get the starting offset of the root partition
    PART_START=$(parted ${BASE_DEV} -ms unit s p | grep "^${PART_NUM}" | cut -f 2 -d:)
    # Remove suffix:
    PART_START=${PART_START%s}
    echo "resizing root partition, starts at offset: $PART_START"
    [ "$PART_START" ] || return 5

    # Return value will likely be error for fdisk as it fails to reload the
    # partition table because the root fs is mounted
    fdisk ${BASE_DEV} <<EOF > /dev/null 2>&1
p
d
$PART_NUM
n
p
$PART_NUM
$PART_START

p
w
EOF

  sync
  echo "Probing the partition table... "
  partprobe

  echo "Resizing the partition... "
  resize2fs ${ROOT_DEV}p${PART_NUM} || return $?
}

case "$1" in
  start)
    reboot=false

    echo "Expanding rootfs..."

    if do_expand_rootfs  ;
    then
      echo "Expanding partition success"
    else
      echo "Expanding rootfs has failed, see log files. Error code: $?"
    fi

    update-rc.d -f resize-rootfs remove >/dev/null 2>&1

  ;;

  *)
    echo "Usage: $0 {start}" >&2
    exit 1
  ;;
esac

exit 0
