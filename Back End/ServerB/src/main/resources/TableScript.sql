create database mini_project_database;
use mini_project_database;

create table treatment(
	t_id VARCHAR(300) PRIMARY KEY,
	d_username VARCHAR(300) REFERENCES doctor(doctor_id),
	p_username VARCHAR(300) REFERENCES patient(patient_id),
	problem VARCHAR(300) NOT NULL,
	progess VARCHAR(300),
	desp VARCHAR(300)
);

create table sharing(
	p_username VARCHAR(300) NOT NULL,
	d_username VARCHAR(300) NOT NULL
);


create table doctor(
	d_username VARCHAR(300) PRIMARY KEY,
	password VARCHAR(300) NOT NULL,
	doctor_name VARCHAR(300) NOT NULL,
	qualification VARCHAR(300) NOT NULL,
	age VARCHAR(300) NOT NULL,
	phone_no VARCHAR(300) UNIQUE NOT NULL,
	specialist VARCHAR(300) NOT NULL
);

create table patient(
	p_username VARCHAR(300) PRIMARY KEY,
	password VARCHAR(300) NOT NULL,
	patient_name VARCHAR(300) NOT NULL,
	age VARCHAR(300) NOT NULL,
	phone_no VARCHAR(300) NOT NULL,
	proof_id VARCHAR(300) UNIQUE NOT NULL,
	dob VARCHAR(300) NOT NULL
);

create table helper(
	username VARCHAR(300) PRIMARY KEY,
	typee VARCHAR(300) NOT NULL
);


