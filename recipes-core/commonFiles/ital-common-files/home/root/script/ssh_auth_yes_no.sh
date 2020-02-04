#!/bin/bash

USAGE='[YES] or [NO] to enabling or disabling ssh Authentication settings'

auth_yes(){
	for config in sshd_config sshd_config_readonly; do
		if [ -e /etc/ssh/$config ]; then
			echo "*****SET [PermitRootLogin yes] in /etc/ssh/$config **********"
			sed -i 's/^[#[:space:]]*PermitRootLogin.*/PermitRootLogin yes/' /etc/ssh/$config
			echo "*****SET [PasswordAuthentication yes] in /etc/ssh/$config **********"
			#remove [:space:] beacuse get a conflict in a comment in file
			sed -i 's/^[#]*PasswordAuthentication.*/PasswordAuthentication yes/' /etc/ssh/$config
			echo "*****SET [PasswordAuthentication yes] in /etc/ssh/$config **********"
			sed -i 's/^[#[:space:]]*PermitEmptyPasswords.*/PermitEmptyPasswords yes/' /etc/ssh/$config
		fi
	done
}



auth_no(){

	for config in sshd_config sshd_config_readonly; do
		if [ -e /etc/ssh/$config ]; then
			echo "*****SET [PermitRootLogin no] in /etc/ssh/$config **********"
			sed -i 's/^[#[:space:]]*PermitRootLogin.*/PermitRootLogin no/' /etc/ssh/$config
			echo "*****SET [PasswordAuthentication no] in /etc/ssh/$config **********"
			#remove [:space:] beacuse get a conflict in a comment in file
			sed -i 's/^[#]*PasswordAuthentication.*/PasswordAuthentication no/' /etc/ssh/$config
			echo "*****SET [PasswordAuthentication no] in /etc/ssh/$config **********"
			sed -i 's/^[#[:space:]]*PermitEmptyPasswords.*/PermitEmptyPasswords no/' /etc/ssh/$config
		fi
	done

}

echo "***********START ENABLE AUTHENTICATION**********"

if [ $# -gt 0 ];then

	if [ $1 = 'YES' ];then
		
		auth_yes

	elif [ $1 = 'NO' ];then

			
		auth_no

	else

	echo "ERROR ! wrong argument --> Usage: $0 $USAGE"
		
	fi
else
	echo "no argument: defaut YES ssh Authentication settings"

	 auth_yes

fi









