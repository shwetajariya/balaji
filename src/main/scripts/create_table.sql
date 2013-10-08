CREATE SCHEMA IF NOT EXISTS sms;
USE sms;

DROP TABLE IF EXISTS Employee;

CREATE TABLE IF NOT EXISTS Employee (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	employeeNumber INT,
	firstName VARCHAR(25),
	lastName VARCHAR(25),
	company VARCHAR(25),
	designation VARCHAR(25),
	department VARCHAR(25),
	section VARCHAR(25),
	mobileNumber VARCHAR(25),
	ipContactNumber VARCHAR(25),
	priority VARCHAR(25),
	email VARCHAR(50),
	address VARCHAR(50),
	area VARCHAR(25)
)ENGINE=INNODB;
