#!/bin/sh

blackarmPATH=/opt/bin/blackarm

#firmw_name_main=YT2.480.0618CX_V3.1B01012.S
firmw_name_nv=YT2.480.0622CX_V2.C01B101_Mf1137B004_V2.1000B60.bin
#firmw_name_fpga=xxx

firmw_path=/home/root/grg/firmware/v-fake/
log_pre=log_ca10_fw_dow

#do not touch!
timestamp=$(date +%Y%m%d_%H%M%S)
log_filename_main=${log_pre}_main_${firmw_name_main}_${timestamp}.txt
log_filename_nv=${log_pre}_nv_${firmw_name_nv}_${timestamp}.txt
log_filename_fpga=${log_pre}_fpga_${firmw_name_fpga}_${timestamp}.txt

echo 'Executing script' >&2
retVal=100
sleep=10


 if [[ -n $firmw_name_nv ]]; then
  echo 'Sleeping' >&2
  sleep $sleep
  echo 'Updating Firmware NV' >&2
  $blackarmPATH --ca10 --fwdown --fwnv --billFake --fwpath $firmw_path/$firmw_name_nv
  retVal=$?
 fi


 if [ $retVal -ne 0 ]; then
    echo "Error retval != 0" >&2
 else
      echo "retavl = 0" >&2
 fi

 exit $retVal
