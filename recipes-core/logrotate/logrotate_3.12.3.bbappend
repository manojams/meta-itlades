do_compile_prepend() {
    #to fix do_install error:
    #"install: cannot stat ‘examples/logrotate-default’: No such file or directory"
    cp -fr ${S}/examples ${B}/
}