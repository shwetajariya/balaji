CREATE SCHEMA IF NOT EXISTS balaji;
USE balaji;

CREATE TABLE IF NOT EXISTS User (
	userId SERIAL PRIMARY KEY,	
	loginName VARCHAR(25) NOT NULL UNIQUE,
	firstName VARCHAR(25),
	lastName VARCHAR(25),
	password VARCHAR(25),
	emailAddress VARCHAR(50),
	lastLogin TIMESTAMP
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS Company (
	companyId SERIAL PRIMARY KEY,
	companyName VARCHAR(25)
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS Groups (
	groupId SERIAL PRIMARY KEY,
	groupName VARCHAR(25)
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS Designation (
	designationId SERIAL PRIMARY KEY,
	designation VARCHAR(25),
	priority INT
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS Department (
	departmentId SERIAL PRIMARY KEY,
	departmentName VARCHAR(25)
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS Section (
	sectionId SERIAL PRIMARY KEY,
	sectionName VARCHAR(25)
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS Contact (
	contactId SERIAL PRIMARY KEY,
	employeeId VARCHAR(25),
	companyId BIGINT UNSIGNED,
	designationId BIGINT UNSIGNED,
	departmentId BIGINT UNSIGNED,
	sectionId BIGINT UNSIGNED,	
	firstName VARCHAR(25),
	lastName VARCHAR(25),
	priority INT,
	officePhoneNumber VARCHAR(15),
	mobileNumber VARCHAR(15),
	residencePhoneNumber VARCHAR(15),
	emailAddress VARCHAR(50),
	modifierId BIGINT UNSIGNED,
	modifiedOn TIMESTAMP,
	FOREIGN KEY (companyId) REFERENCES Company(companyId),
	FOREIGN KEY (designationId) REFERENCES Designation(designationId),
	FOREIGN KEY (departmentId) REFERENCES Department(departmentId),
	FOREIGN KEY (sectionId) REFERENCES Section(sectionId),
	FOREIGN KEY (modifierId) REFERENCES User(userId)
)ENGINE=INNODB;

-- Auto update this table by trigger
CREATE TABLE IF NOT EXISTS ContactAudit (
	operation VARCHAR(15),
	contactId BIGINT UNSIGNED,
	mobileNumber VARCHAR(15),
	emailAddress VARCHAR(50),
	modifierId BIGINT UNSIGNED,
	modifiedOn TIMESTAMP
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS ContactGroupMapping (
	contactId BIGINT UNSIGNED,
	groupId BIGINT UNSIGNED,
	FOREIGN KEY (contactId) REFERENCES Contact(contactId),
	FOREIGN KEY (groupId) REFERENCES Groups(groupId)
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS MessageTemplate (
	templateId SERIAL PRIMARY KEY,
	text VARCHAR(140)
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS MessageLog (
	messageLogId SERIAL PRIMARY KEY,
	userId BIGINT UNSIGNED,
	messageText VARCHAR(255),
	timeoutMilliSec LONG,
	startTime TIMESTAMP,
	endTime TIMESTAMP,
	FOREIGN KEY (userId) REFERENCES User(userId)
)ENGINE=INNODB;

CREATE TABLE IF NOT EXISTS MessageStatus (
	messageLogId BIGINT UNSIGNED,
	contactId BIGINT UNSIGNED,
	contactNumber VARCHAR(50), -- Used in case of sending directly by number... 
	statusCode INT,
	FOREIGN KEY (contactId) REFERENCES Contact(contactId),
	FOREIGN KEY (messageLogId) REFERENCES MessageLog(messageLogId)
)ENGINE=INNODB;

/*
Notes:
 1) SERIAL is an alias for BIGINT UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE
 2) Findout which MySQL version is free on commercial level deployment
*/

