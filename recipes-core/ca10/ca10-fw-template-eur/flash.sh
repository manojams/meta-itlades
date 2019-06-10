#!/bin/sh


blackarmPATH=/opt/bin/blackarm

firmw_name_main=YT2.480.0618CX_V3.1B02006.S
firmw_name_nv=YT2.480.0622CX_CA10_V2.C01B001_M71004A017_201802271655.bin
#firmw_name_fpga=xxx

firmw_path=/home/root/grg/firmware/v1-1/
log_pre=log_ca10_fw_dow

#do not touch!
timestamp=$(date +%Y%m%d_%H%M%S)
log_filename_main=${log_pre}_main_${firmw_name_main}_${timestamp}.txt
log_filename_nv=${log_pre}_nv_${firmw_name_nv}_${timestamp}.txt
log_filename_fpga=${log_pre}_fpga_${firmw_name_fpga}_${timestamp}.txt

echo 'Executing script' >&2
retVal=100
sleep=10


 if [[ -n $firmw_name_main ]]; then
  echo 'Updating Firmware Main' >&2
  $blackarmPATH --ca10 --fwdown --fwmain --fwpath $firmw_path/$firmw_name_main
  retVal=$?
 fi

 if [ $retVal -ne 0 ]; then
 echo "Error retval != 0" >&2
   exit $retVal
 fi

 #TODO: check previous returned value to == 0
 if [[ -n $firmw_name_nv ]]; then
  echo 'Sleeping' >&2
  sleep $sleep
  echo 'Updating Firmware NV' >&2
  $blackarmPATH --ca10 --fwdown --fwnv --fwpath $firmw_path/$firmw_name_nv
  retVal=$?
 fi

 if [ $retVal -ne 0 ]; then
 echo "Error retval != 0" >&2
  exit $retVal
fi

 if [[ -n $firmw_name_fpga ]]; then
   echo 'Sleeping' >&2
   sleep $sleep
  echo 'Updating Firmware fpga' >&2
  $blackarmPATH --ca10 --fwdown --fwfpga --fwpath $firmw_path/$firmw_name_fpga
  retVal=$?
 fi

 if [ $retVal -ne 0 ]; then
    echo "Error retval != 0" >&2
 else
      echo "retavl = 0" >&2
 fi

 exit $retVal
