#! /bin/bash

LOOPFILE=$1
SCRIPT=$2
LOGFILE=$3

logger -s "LOOPFILE: $LOOPFILE"
logger -s "LOGFILE: $LOGFILE"
logger -s "SCRIPT: $SCRIPT"

cmd() {
  $SCRIPT &> $LOGFILE
}

LOOP=$(cat "$LOOPFILE")
while [ $LOOP == "true" ]; do
  logger -s "LOOP: $LOOP"
  logger -s "CMD: $CMD"
  cmd
  LOOP=$(cat "$LOOPFILE")
done

rm "$LOOPFILE"
