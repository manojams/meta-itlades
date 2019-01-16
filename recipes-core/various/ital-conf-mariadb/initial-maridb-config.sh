#!/bin/sh

echo -e "\n\n Started script mariadb \n\n"

mysql -u root -Bse "UPDATE mysql.user SET Password=PASSWORD('%>L3spx3HKYQ,(sP') WHERE User='root';
DELETE FROM mysql.user WHERE User='root' AND Host NOT IN ('localhost', '127.0.0.1', '::1');
DELETE FROM mysql.user WHERE User='';
DELETE FROM mysql.db WHERE Db='test' OR Db='test_%';
CREATE DATABASE bna_db;
GRANT ALL PRIVILEGES ON bna_db.* TO 'qt_user'@'localhost' IDENTIFIED BY 'e?5!t=~y@SuU.Dr(' WITH GRANT OPTION;
GRANT SELECT ON bna_db.* TO 'helpdesk'@'%' IDENTIFIED BY 'helpdesk_pwd';
FLUSH PRIVILEGES;"
