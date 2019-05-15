#!/bin/sh

OUTFILE=/tmp/vpu_mem_error




while [ 1 ]; do	
	#dmesg | grep "msdos:" | grep "disagrees about version of symbol"
	#dmesg | grep "ERROR" | grep "v4l2 capture: slave not found!"
	#dmesg | grep "main" | grep "OS Product"
	dmesg | grep "mxc_vpu" | grep "Physical memory allocation error"
	ret_value=$?
	if [ $ret_value -eq 0 ]; then
		touch $OUTFILE
		#echo "VPU MEMORY ERROR" >> $OUTFILE
		#exit 1

	fi
	sleep 5
done	

exit 0



