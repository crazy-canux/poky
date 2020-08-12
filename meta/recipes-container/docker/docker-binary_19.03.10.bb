SUMMARY = "Linux container runtime - binary release"

LICENSE = "CLOSED"

inherit useradd systemd

SRC_URI = "https://download.docker.com/linux/static/stable/x86_64/docker-${PV}.tgz"
SRC_URI += "file://dockerd_wrapper.sh"
SRC_URI += "file://daemon.json"

# https://raw.githubusercontent.com/moby/moby/v19.03.10/contrib/init/systemd/docker.service
SRC_URI += "file://docker.service"

# Modified https://raw.githubusercontent.com/moby/moby/v19.03.10/contrib/init/systemd/docker.socket
SRC_URI += "file://docker.socket"

# Modified https://sonicgit.eng.sonicwall.com/soniccore/componentsx/soniccorex-layers/meta-virtualization/blob/MASTER/soniccorex/7.0.0/master/recipes-containers/containerd/files/containerd.service
SRC_URI += "file://containerd.service"

SRC_URI[md5sum] = "41e5083d1d8205b961546fe7d01344f1"
SRC_URI[sha256sum] = "7c1576a0bc749418d1423d2b78c8920b5d61f849789904612862dd118742e82b"

S = "${WORKDIR}/docker"

# https://docs.docker.com/engine/install/binaries/#prerequisites
RDEPENDS_${PN} = "iptables (>= 1.4) git (>= 1.7) procps xz (>= 4.9)"

do_configure[noexec] = "1"
do_compile[noexec] = "1"

do_install () {
    install -d "${D}/${bindir}"
    install "${S}"/* "${D}/${bindir}"
    install "${WORKDIR}/dockerd_wrapper.sh" "${D}/${bindir}/dockerd_wrapper.sh"

    install -d "${D}${systemd_unitdir}/system"
    install -m 0644 "${WORKDIR}/docker.service" "${D}/${systemd_unitdir}/system/docker.service"
    install -m 0644 "${WORKDIR}/docker.socket" "${D}/${systemd_unitdir}/system/docker.socket"
    install -m 0644 "${WORKDIR}/containerd.service" "${D}/${systemd_unitdir}/system/containerd.service"

    install -d "${D}${sysconfdir}/docker"
    install -m 0644 "${WORKDIR}/daemon.json" "${D}/${sysconfdir}/docker/daemon.json"
}

INSANE_SKIP_${PN} += "already-stripped"

FILES_${PN} += "${sysconfdir}/docker/daemon.json"
FILES_${PN} += "${systemd_unitdir}/system/docker.service"
FILES_${PN} += "${systemd_unitdir}/system/docker.socket"
FILES_${PN} += "${systemd_unitdir}/system/containerd.service"

USERADD_PACKAGES = "${PN}"
GROUPADD_PARAM_${PN} = "-f -r docker"

SYSTEMD_SERVICE_${PN} = "docker.service"
SYSTEMD_AUTO_ENABLE_${PN} = "enable"

SYSTEMD_SERVICE_${PN}_containerd = "containerd.service"
SYSTEMD_AUTO_ENABLE_${PN}_containerd = "enable"
