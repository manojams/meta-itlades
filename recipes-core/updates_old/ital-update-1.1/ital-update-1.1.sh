#!/bin/sh

before() {
  echo "1.1" > /home/root/updates/before.txt
}

after(){
  echo "1.1" > /home/root/updates/after.txt
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
