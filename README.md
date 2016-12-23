meta-example
============

yocto example meta layer

Use this example by following the steps described in the user manual for creating your own custom meta-layer.


local.conf
============
PACKAGECONFIG_append = " sql-sqlite "
PACKAGECONFIG_append = " dbus "

# Possible provider: cacao-initial-native and jamvm-initial-native
PREFERRED_PROVIDER_virtual/java-initial-native = "cacao-initial-native"

# Possible provider: cacao-native and jamvm-native
PREFERRED_PROVIDER_virtual/java-native = "jamvm-native"

# Optional since there is only one provider for now
PREFERRED_PROVIDER_virtual/javac-native = "ecj-bootstrap-native"
