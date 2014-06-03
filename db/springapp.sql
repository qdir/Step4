CREATE DATABASE springapp;

GRANT ALL ON springapp.* TO springappuser@'%' IDENTIFIED BY 'pspringappuser';
GRANT ALL ON springapp.* TO springappuser@localhost IDENTIFIED BY 'pspringappuser';

USE springapp;


CREATE TABLE payments(
	identifier VARCHAR(30),
	expiringdate VARCHAR(20) PRIMARY KEY,
	paid BOOLEAN,
	fee REAL
	 );
