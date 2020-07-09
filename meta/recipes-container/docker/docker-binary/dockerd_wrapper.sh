#!/bin/bash

# Workaround for overlayfs (docker storage driver overlay2) on overlayfs (/var) limit
# https://lkml.org/lkml/2018/1/8/81 (Using overlay on top of overlay)

DATA_ROOT=/data/docker

if [ ! -e /var/lib/docker ]
then
  # Create symlink in case some program has hardcoded /var/lib/docker.
  # Symlink on overlayfs is fine.
  ln -s "${DATA_ROOT}" /var/lib/docker
fi

exec /usr/bin/dockerd --data-root "${DATA_ROOT}" -H fd://
