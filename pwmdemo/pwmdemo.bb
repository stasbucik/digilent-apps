#
# This file is the pwmdemo recipe.
#

SUMMARY = "Simple pwmdemo application"
SECTION = "PETALINUX/apps"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

DEPENDS = "libpwm libuio glibc"
RDEPENDS_${PN} = "libpwm libuio glibc"

SRC_URI = "git://github.com/mitchellorsucci/pwmdemo.git \
		  "
SRCREV = "84b5baa9c5ebd7dfc01b55eb65dfd54a18ddfb5f"
S = "${WORKDIR}/git"

TARGET_CC_ARCH += "${LDFLAGS}"

do_compile() {
	     ${CC} ${CFLAGS} pwmdemo.c -lpwm -luio -o pwmdemo
}

do_install() {
	     install -d ${D}${bindir}
	     install -m 0755 pwmdemo ${D}${bindir}
}

FILES_${PN} += "${bindir}/pwmdemo"
