#
# This file is the libvrc recipe.
#

SUMMARY = "Simple libvrc application"
SECTION = "libs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://github.com/digilent/libvrc.git;protocol=https;branch=master \
		  "

SRCREV = "${AUTOREV}"

RDEPENDS:${PN} = "glibc"
DEPENDS = "glibc"

FILES:${PN} = "${libdir}/*.so.* ${includedir}/* ${libdir}/*.so"

FILES_SOLIBSDEV = ""
FILES:${PN}-dev = ""
INSANE_SKIP:${PN} += "dev-so"
SOLIBS = ".so"


S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
PROVIDES = "libvrc"
TARGET_CC_ARCH += "${LDFLAGS}"

do_install() {
		install -d ${D}${libdir}
		oe_libinstall -so libvrc ${D}${libdir}
		
		install -d ${D}${includedir}
	   	install -m 0644 ${S}/libvrc.h ${D}${includedir}

		install -m 0644 libvrc.so ${D}${libdir}

}

