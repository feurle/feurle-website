#!/usr/bin/env bash

if [ $# -ne 2 ]; then
  echo "Usage: $0 <image_name> <container_name>"
  exit 1
fi


echo "redeploy ..."
echo "docker image $1"
echo "container name $2"

podman pull $1
podman stop $2
podman system prune -f
podman run -d --name $2 -p 8083:8080 $1