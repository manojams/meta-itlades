#!/bin/bash

LOGDIR=/sdcard/log/
FILENAME=/sdcard/log/free.log
TEMP_FILE=/sys/class/thermal/thermal_zone0/temp

PREV_TOTAL=0
PREV_IDLE=0

if [ ! -d $LOGDIR ]; then
    mkdir $LOGDIR
fi

while [ true ]; do
	echo "$(date)" >> $FILENAME
	free >> $FILENAME

	#get CPU temperature 
	# bc not work in yocto
	#TEMP=$(echo "scale=2; `cat $TEMP_FILE`/1000"|bc)
	let "TEMP=`cat $TEMP_FILE`/1000"
	echo "CPU_temp °C: " $TEMP >> $FILENAME
	


  	CPU=(`cat /proc/stat | grep '^cpu '`) # Get the total CPU statistics.
  	unset CPU[0]                          # Discard the "cpu" prefix.
  	IDLE=${CPU[4]}                        # Get the idle CPU time.

  	# Calculate the total CPU time.
  	TOTAL=0

  	for VALUE in "${CPU[@]:0:4}"; do
    	let "TOTAL=$TOTAL+$VALUE"
  	done

  	# Calculate the CPU usage since we last checked.
  	let "DIFF_IDLE=$IDLE-$PREV_IDLE"
  	let "DIFF_TOTAL=$TOTAL-$PREV_TOTAL"
  	let "DIFF_USAGE=(1000*($DIFF_TOTAL-$DIFF_IDLE)/$DIFF_TOTAL+5)/10"
  	#echo -en "\rCPU: $DIFF_USAGE%  \b\b"
  	echo "CPU_usage %: " $DIFF_USAGE >> $FILENAME

  	# Remember the total and idle CPU times for the next check.
  	PREV_TOTAL="$TOTAL"
  	PREV_IDLE="$IDLE"



  	echo "" >> $FILENAME


	sleep 60
done
