create database db_health_records;

use db_health_records;

create table patient_health_records(
                                       id int auto_increment primary key,
                                       patient_id int not null,
                                       body_temperature decimal(5,2));