# digilent-apps

This represents a sub-module that includes all of the Petalinux/Linux apps that are provided by Digilent.

A list of the apps and short description of each follows:

--libuio
  A user space library for interfacing with uio devices
  uio devices can be found in /sys/class/uio
  Can be used with #include <libuio.h> and -luio as a compiler flag
  
--libvrc
  A user space library for controlling video resolution output
  Can be used with #include <libvrc.h> and -lvrc as a compiler flag
  
--libgpio
  A user space library for interfacing with GPIO controllers in the FPGA fabric using UIO drivers
  Can be used with #include <libgpio.h> and -lgpio as a compiler flag

--libpwm
  A user space library for interfacing with the PWM controller provided by Digilent as an ip-core
  Can be used with #include <libpwm.h> and -lpwm as a compiler flag

--kmsdemo
  A demo program that demonstrates the functionality of libvrc
  
--gpioutil
  A command line gpio utility built using libgpio

--pwmdemo
  A demo program that demonstrates the functionality of libpwm
