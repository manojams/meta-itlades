#!/bin/sh

before() {
  return 0
}

after(){
  /home/root/grg/firmware/v1-1/flash.sh

  return $?
}

case "$1" in
  before)
    before
    ;;
  after)
    after
    ;;
  *)
    echo "Usage: $0 {start|stop|restart|uninstall}"
esac
