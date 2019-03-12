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

    blackarmPATH=/opt/bin/blackarm

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

    echo 'Executing script' >&2
    retVal=100
    if [ x"$D" = "x" ]; then
         # Actions to carry out on the device go here

         if [[ -n $firmw_name_main ]]; then
          echo 'Updating Firmware Main' >&2
          $blackarmPATH --ca10 --fwdown --fwmain --fwpath $firmw_path/$firmw_name_main
          retVal=$?
         fi

         if [[ -n $firmw_name_nv ]]; then
          echo 'Updating Firmware NV' >&2
          $blackarmPATH --ca10 --fwdown --fwnv --fwpath $firmw_path/$firmw_name_nv
          retVal=$?
         fi

         if [[ -n $firmw_name_fpga ]]; then
          echo 'Updating Firmware fpga' >&2
          $blackarmPATH --ca10 --fwdown --fwfpga --fwpath $firmw_path/$firmw_name_fpga
          retVal=$?
         fi

         if [ $retVal -ne 0 ]; then
            echo "retval != 0" >&2
            echo "ca10-firmware-test" >> /home/root/results
         else
              echo "retavl 0" >&2
         fi
    else
        echo 'Should never reach here'
        exit 0
    fi
}

PACKAGES = "${PN}"
FILES_${PN} += "home/root/grg/firmware"
