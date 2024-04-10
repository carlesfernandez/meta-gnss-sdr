#!/bin/sh
# Update all branches from the upstream repository
#
# Usage: ./update-from-upstream.sh
#
# SPDX-FileCopyrightText: 2023 Carles Fernandez-Prades <cfernandez(at)cttc.es>
# SPDX-License-Identifier: MIT

version="1.0"
branches="master scarthgap nanbield mickledore langdale kirkstone honister hardknott gatesgarth dunfell zeus warrior thud sumo rocko"

if ! [ -x "$(command -v git)" ]; then
    echo "Please install git before using this script."
    exit 1
fi

display_usage() {
    echo "update-from-upstream.sh v$version - This script pulls all branches from the upstream repo."
    echo " Supported branches: $branches"   
    echo " Usage:"
    echo "  ./update-from-upstream.sh remote"
    echo "  where:"
    echo "   remote   [optional] upstream remote name (or full URL)"
}

if [ "$1" = "--help" ] || [ "$1" = "-h" ]; then
    display_usage
    exit 0
fi

if [ "$1" = "--version" ] || [ "$1" = "-v" ]; then
    echo "update-from-upstream.sh v$version"
    exit 0
fi

if [ "$#" -gt 1 ]; then
   echo "Error: wrong number of parameters."
   display_usage
   exit 1
fi

upstream="https://github.com/carlesfernandez/meta-gnss-sdr"
currentbranch=$(git rev-parse --abbrev-ref HEAD 2> /dev/null)

if [ -z "$currentbranch" ]; then
    echo "We are not in a git repository. Exiting."
    exit 1
fi

echo "Running update-from-upstream.sh v$version ..."

for branch in $branches; do
    git checkout "$branch"
    git pull "$upstream" "$branch"
done

git checkout "$currentbranch"
echo "update-from-upstream.sh v$version executed successfully."
