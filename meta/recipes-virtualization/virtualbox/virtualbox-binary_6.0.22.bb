SUMMARY = "VirtualBox is a powerful x86 and AMD64/Intel64 virtualization product for enterprise as well as home use."

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/install/LICENSE;md5=e197d5641bb35b29d46ca8c4bf7f2660"

SRC_URI = "https://download.virtualbox.org/virtualbox/6.0.22/VirtualBox-6.0.22-137980-Linux_amd64.run"
SRC_URI += "file://0001-busybox-compatible.patch;patchdir=${BUILD_DIR}"
SRC_URI += "file://vboxdrv.service"
SRC_URI += "file://60-vboxdrv.rules"

SRC_URI[md5sum] = "9b5fdc45a5563961bd047925503d4786"
SRC_URI[sha256sum] = "aaf4c0ddab09735b309dd34cd81b9d5f924bae425550f1be9e9e39b14ed3aa17"

S = "${WORKDIR}"
BUILD_DIR = "${WORKDIR}/build_dir"

# Uncomment below to disable parallel build
#DISABLE_PARALLEL_BUILD = "VBOX_NOJOBS=1"

inherit module useradd systemd relative_symlinks

RDEPENDS_${PN} = "procps"

do_unpack_append() {
    bb.build.exec_func("unpack", d)
}

unpack() {
    /bin/sh "${WORKDIR}/VirtualBox-6.0.22-137980-Linux_amd64.run" --keep --noexec

    mkdir -p "${BUILD_DIR}"
    tar -xvf install/VirtualBox.tar.bz2 -C "${BUILD_DIR}"
}

EXTRA_OEMAKE += " \
    -C '${BUILD_DIR}/src/vboxhost' \
    KERN_DIR='${STAGING_KERNEL_DIR}' \
    KERN_VER='${KERNEL_VERSION}' \
    INSTALL_MOD_PATH='${D}' \
    ${DISABLE_PARALLEL_BUILD} \
    DEBUG=1 \
    KBUILD_VERBOSE=1 \
    VBOX_LNX_VERBOSE=1 \
"

do_compile() {
    # cross build kernel modules
    oe_runmake
}

INSTALL_DIR = "/opt/VirtualBox"
do_install() {
    # https://www.virtualbox.org/manual/ch02.html#install-linux-manual
    # (2.3.3.3. Performing a Manual Installation)

    oe_runmake install

    install -d "${D}/${INSTALL_DIR}"
    tar -xvf install/VirtualBox.tar.bz2 -C "${D}/${INSTALL_DIR}"

    # Set setuid and setgid bits
    chmod 6755 "${D}/${INSTALL_DIR}/VBoxHeadless"
    chmod 6755 "${D}/${INSTALL_DIR}/VBoxNetAdpCtl"
    chmod 6755 "${D}/${INSTALL_DIR}/VBoxNetDHCP"
    chmod 6755 "${D}/${INSTALL_DIR}/VBoxNetNAT"
    chmod 6755 "${D}/${INSTALL_DIR}/VBoxSDL"
    chmod 6755 "${D}/${INSTALL_DIR}/VBoxVolInfo"
    chmod 6755 "${D}/${INSTALL_DIR}/VirtualBox"
    chmod 6755 "${D}/${INSTALL_DIR}/VirtualBoxVM"

    # SonicCoreX: use patched version
    install "${BUILD_DIR}/VBox.sh" "${D}/${INSTALL_DIR}/VBox.sh"
    install "${BUILD_DIR}/vboxdrv.sh" "${D}/${INSTALL_DIR}/vboxdrv.sh"

    # /dev/vboxdrv can only be created at runtime by vboxdrv.sh, because major:minor are
    # queried after running vboxdrv driver.

    install -d "${D}/${base_sbindir}"
    install "${D}/${INSTALL_DIR}/vboxdrv.sh" "${D}/${base_sbindir}/rcvboxdrv"

    install -d "${D}/${sysconfdir}/vbox"
    echo "INSTALL_DIR=${INSTALL_DIR}" > vbox.cfg
    install -m 0644 vbox.cfg "${D}/${sysconfdir}/vbox/vbox.cfg"

    install -d "${D}/${bindir}"
    lnr "${D}/${INSTALL_DIR}/VBox.sh" "${D}/${bindir}/VirtualBox"
    lnr "${D}/${INSTALL_DIR}/VBox.sh" "${D}/${bindir}/virtualbox"
    lnr "${D}/${INSTALL_DIR}/VBox.sh" "${D}/${bindir}/VBoxManage"
    lnr "${D}/${INSTALL_DIR}/VBox.sh" "${D}/${bindir}/vboxmanage"
    lnr "${D}/${INSTALL_DIR}/VBox.sh" "${D}/${bindir}/VBoxHeadless"
    lnr "${D}/${INSTALL_DIR}/VBox.sh" "${D}/${bindir}/vboxheadless"

    # SonicCoreX: use systemd to bring up drivers
    install -d "${D}${systemd_unitdir}/system"
    install -m 0644 vboxdrv.service "${D}/${systemd_unitdir}/system/vboxdrv.service"

    install -d "${D}/${baselib}/udev/rules.d"
    install -m 0644 60-vboxdrv.rules "${D}/${baselib}/udev/rules.d/60-vboxdrv.rules"

    # SonicCoreX: Quick hack to get binaries working
    install -d "${D}/lib64"
    lnr "${D}/${base_libdir}/ld-linux-x86-64.so.2" "${D}/lib64/ld-linux-x86-64.so.2"
}

INSANE_SKIP_${PN} += "already-stripped arch libdir"

FILES_${PN} += "${INSTALL_DIR}"
FILES_${PN} += "${base_sbindir}/rcvboxdrv"
FILES_${PN} += "${sysconfdir}/vbox/vbox.cfg"
FILES_${PN} += "${bindir}/VirtualBox"
FILES_${PN} += "${bindir}/virtualbox"
FILES_${PN} += "${bindir}/VBoxManage"
FILES_${PN} += "${bindir}/vboxmanage"
FILES_${PN} += "${bindir}/VBoxHeadless"
FILES_${PN} += "${bindir}/vboxheadless"
FILES_${PN} += "/lib64/ld-linux-x86-64.so.2"
FILES_${PN} += "${baselib}/udev/rules.d/60-vboxdrv.rules"

USERADD_PACKAGES = "${PN}"
GROUPADD_PARAM_${PN} = "-r -f vboxusers"

SYSTEMD_SERVICE_${PN} = "vboxdrv.service"
