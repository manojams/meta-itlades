#! /bin/bash

LOOPFILE=$1
SCRIPT=$2
LOGFILE=$3

logger -s "LOOPFILE: $LOOPFILE"
logger -s "SCRIPT: $SCRIPT"

#  $SCRIPT &> sed '/^WARNING: cipher_setiv/d' > $LOGFILE

LOOP=$(cat "$LOOPFILE")
while [ $LOOP == "true" ]; do
  logger -s "LOOP: $LOOP"
  $SCRIPT
  sleep 3
  LOOP=$(cat "$LOOPFILE")
done

rm "$LOOPFILE"
