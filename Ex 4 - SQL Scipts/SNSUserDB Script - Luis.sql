create table SNS_USer (
CC number(8,0) constraint pk_SNSU PRIMARY KEY constraint check_CC check (CC > 9999999),
Password varchar(20) constraint nn NOT NULL,
Email VARCHAR(50),
Phone_Number number(9,0) constraint check_PN check (Phone_Number > 99999999) constraint nn_PN NOT NULL
);