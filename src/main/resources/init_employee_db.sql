create database employee_db;
use employee_db;
create table employee (id int(100) not null auto_increment,
firstname varchar(64) not null,
lastname varchar(64) not null,
primary key (id));
