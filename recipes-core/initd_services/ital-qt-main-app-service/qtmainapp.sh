#! /bin/bash

LOOPFILE=$1
SCRIPT=$2

ERRNAME=qterr
LOGDIR=/sdcard/log/
LOGERR=$ERRNAME.log
ERRFILE=$LOGDIR$LOGERR

logger -s "LOOPFILE: $LOOPFILE"
logger -s "SCRIPT: $SCRIPT"
logger -s "ERRFILE: $ERRFILE"

cmd() {
  $SCRIPT > /dev/null 2>$ERRFILE
}

LOOP=$(cat "$LOOPFILE")
while [ $LOOP == "true" ]; do
  logger -s "LOOP: $LOOP"
  logger -s "CMD: $CMD"
  cmd
  sleep 3
  LOOP=$(cat "$LOOPFILE")
done

rm "$LOOPFILE"