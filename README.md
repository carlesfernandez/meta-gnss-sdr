# meta-gnss-sdr
-------

A layer for [gnss-sdr](https://gnss-sdr.org) on embedded devices.


## How to use this layer

The process described below is based on [OpenEmbedded](http://www.openembedded.org) (a build framework for embedded Linux) and the [Yocto Project](https://www.yoctoproject.org/) (a complete embedded Linux development environment covering several build profiles across multiple architectures including ARM, PPC, MIPS, x86, and x86-64). In order to set up a build host, you will need a machine with a minimum of 100 Gbytes of free disk space and running a supported Linux distribution. In general, if you have the current release minus one of Ubuntu, Fedora, openSUSE, CentOS or Debian you should have no problems. For a more detailed list of distributions that support the Yocto Project, see the [Supported Linux Distributions](https://www.yoctoproject.org/docs/latest/ref-manual/ref-manual.html#detailed-supported-distros) section in the Yocto Project Reference Manual, and check out the [list of required packages for each host operating system](https://www.yoctoproject.org/docs/latest/ref-manual/ref-manual.html#required-packages-for-the-build-host).

### Tested Environment

Ubuntu 16.04 64 bits in a Virtual Machine

```
$ sudo apt-get install build-essential xz-utils python3 curl git automake \
  libtool g++ gawk wget diffstat unzip texinfo gcc-multilib \
  chrpath libsdl1.2-dev xterm
```

Configure Git:

```
$ git config --global user.name "Your Name"
$ git config --global user.email your.name@example.com
```


### Getting Started

1.  Install Repo.

    Download the Repo script.

        $ curl https://storage.googleapis.com/git-repo-downloads/repo > repo

    Make it executable.

        $ chmod a+x repo

    Move it on to your system path.

        $ sudo mv repo /usr/local/bin/

2.  Initialize a Repo client.

    Create an empty directory to hold your working files.

        $ mkdir oe-repo
        $ cd oe-repo

    Tell Repo where to find the manifest

        $ repo init -u git://github.com/carlesfernandez/oe-gnss-sdr-manifest.git -b warrior

    A successful initialization will end with a message stating that Repo is
    initialized in your working directory. Your client directory should now
    contain a .repo directory where files such as the manifest will be kept.

    To learn more about repo, look at https://source.android.com/source/using-repo.html

3.  Fetch all the repositories.

        $ repo sync

    Now go put on the coffee machine as this may take 20 minutes depending on
    your connection.

4.  Initialize the OpenEmbedded Environment.

        $ TEMPLATECONF=`pwd`/meta-gnss-sdr/conf source ./oe-core/oe-init-build-env ./build ./bitbake

    This copies default configuration information into the `./build/conf`
    directory and sets up some environment variables for OpenEmbedded.  You may
    wish to edit the configuration options at this point. The default target is `MACHINE=zedboard-zynq7` but you can override that defining an environment variable:

        $ export MACHINE=raspberrypi3

5.  Build an image.

    This process downloads several gigabytes of source code and then proceeds to
    do an awful lot of compilation so make sure you have plenty of space (25 GB
    minimum). Go drink some beer.

        $ bitbake gnss-sdr-dev-image

    If everything goes well, you should have a compressed root filesystem
    tarball as well as kernel and bootloader binaries available in your
    *work/deploy* directory.

6.  Build an SDK for cross compiling GNSS-SDR on an x86 machine.

    Run:

        $ bitbake -c populate_sdk gnss-sdr-dev-image

    When this completes the SDK is in `./tmp-glibc/deploy/sdk/` as an .sh file
    you copy to the machine you want to cross compile on and run the file.
    It will default to installing the SDK in `/usr/local`, and you can ask it to
    install anywhere you have write access to.

7.  Build a Docker container

    Run:

        $ bitbake gnss-sdr-dev-docker

    This will create a .docker file under `./tmp-glibc/deploy/images/` that can be ingested by Docker as:

        $ cd tmp-glibc/deploy/images/
        $ docker load -i ./filename.docker


Instructions on how to use this layer: https://github.com/carlesfernandez/oe-gnss-sdr-manifest.git
