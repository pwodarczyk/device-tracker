#create database tracking;
use tracking;

#drop table check_out_log;
#drop table device_user;
#drop table device;
#drop table project;


create table device_user (device_user_id int auto_increment, first_name varchar(50) not null,last_name varchar(50) not null, email varchar (255), phone varchar(255), primary key (device_user_id) ) ENGINE=INNODB;  

create table device (device_id int auto_increment, name varchar(50) not null, description varchar(250), model varchar (50), version varchar(50), qr_code varchar(1000), log_id int, primary key (device_id)) ENGINE=INNODB;

create table check_out_log (log_id int auto_increment , device_user_id int not null, device_id int not null, project_id int not null, check_out datetime not null, check_in datetime, primary key (log_id) ) ENGINE=INNODB;

create table project (project_id int auto_increment, name varchar(50) not null, description varchar(250), primary key (project_id) ) ENGINE=INNODB;


alter table check_out_log add foreign key (device_user_id) references device_user(device_user_id);
alter table check_out_log add foreign key (device_id) references device(device_id);
alter table check_out_log add foreign key (project_id) references project(project_id);
