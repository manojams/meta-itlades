SUMMARY = "Copy Italdes common files "
DESCRIPTION = "Copy Italdes common files"
LICENSE = "CLOSED"

SRC_URI = "file://YT2.480.0618CX_V3.1B01012.S \
           file://YT2.480.0622CX_V2.001B1xd_ME1003A001_V2.1000B60.bin \
         "

S = "${WORKDIR}"

do_install () {
	install -d ${D}/home/root/grg/firmware
	install -m 0444 ${WORKDIR}/YT2.480.0618CX_V3.1B01012.S ${D}/home/root/grg/firmware/YT2.480.0618CX_V3.1B01012.S
  install -m 0444 ${WORKDIR}/YT2.480.0622CX_V2.001B1xd_ME1003A001_V2.1000B60.bin ${D}/home/root/grg/firmware/YT2.480.0622CX_V2.001B1xd_ME1003A001_V2.1000B60.bin
}


pkg_postinst_${PN} () {
    #!/bin/sh -e

    firmw_name_main=YT2.480.0618CX_V3.1B01012.S
    firmw_name_nv=YT2.480.0622CX_V2.001B1xd_ME1003A001_V2.1000B60.bin
    #firmw_name_fpga=xxx

    firmw_path=/home/root/grg/firmware
    log_pre=log_ca10_fw_dow

    #do not touch!
    timestamp=$(date +%Y%m%d_%H%M%S)
    log_filename_main=${log_pre}_main_${firmw_name_main}_${timestamp}.txt
    log_filename_nv=${log_pre}_nv_${firmw_name_nv}_${timestamp}.txt
    log_filename_fpga=${log_pre}_fpga_${firmw_name_fpga}_${timestamp}.txt

    echo 'Executing script'

    if [ x"$D" = "x" ]; then
         # Actions to carry out on the device go here

         if [[ -n $firmw_name_main ]]; then
          echo 'Updating Firmware Main'
          /home/root/blackarm --ca10 --fwdown --fwmain --fwpath $firmw_path/$firmw_name_main | tee -a b $log_filename_main
         fi

         if [[ -n $firmw_name_nv ]]; then
          echo 'Updating Firmware NV'
          /home/root/blackarm --ca10 --fwdown --fwnv --fwpath $firmw_path/$firmw_name_nv | tee -a b $log_filename_nv
         fi

         if [[ -n $firmw_name_fpga ]]; then
          echo 'Updating Firmware fpga'
          /home/root/blackarm --ca10 --fwdown --fwfpga --fwpath $firmw_path/$firmw_name_fpga | tee -a b $log_filename_fpga
         fi

    else
        echo 'Should never reach here'
        exit 1
    fi
}

PACKAGES = "${PN}"
FILES_${PN} += "home/root/grg/firmware"
