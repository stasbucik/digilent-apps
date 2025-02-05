#
# This file is the kmsdemo recipe.
#

SUMMARY = "Simple kmsdemo application"
SECTION = "PETALINUX/apps"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
DEPENDS = "libvrc glibc"
RDEPENDS:${PN} = "libvrc glibc"

SRC_URI = "git://github.com/digilent/kmsdemo.git;protocol=https;branch=master \
		  "

SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"
TARGET_CC_ARCH += "${LDFLAGS}"

do_compile() {
	     ${CC} ${CFLAGS} kmsutil.c -lvrc -o kmsdemo
}

do_install() {
	     install -d ${D}${bindir}
	     install -m 0755 kmsdemo ${D}${bindir}
}
