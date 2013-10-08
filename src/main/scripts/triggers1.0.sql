USE sms;

-- drop trigger insert_contact_trigger;
-- drop trigger update_contact_trigger;
-- drop trigger delete_contact_trigger;

delimiter $$
CREATE TRIGGER insert_contact_trigger
AFTER INSERT ON Contact
FOR EACH ROW
	INSERT INTO ContactAudit (operation, contactId, mobileNumber, emailAddress, modifierId, modifiedOn)
	VALUES ('INSERT', NEW.contactId, NEW.mobileNumber, NEW.emailAddress, NEW.modifierId, NEW.modifiedOn);
$$
;

delimiter $$
CREATE TRIGGER update_contact_trigger
AFTER UPDATE ON Contact
FOR EACH ROW
	IF (NEW.mobileNumber <> OLD.mobileNumber) or (NEW.emailAddress <> OLD.emailAddress)
	THEN  
	  INSERT INTO ContactAudit (operation, contactId, mobileNumber, emailAddress, modifierId, modifiedOn)
	  VALUES ('UPDATE', NEW.contactId, NEW.mobileNumber, NEW.emailAddress, NEW.modifierId, NEW.modifiedOn);
	END IF;
$$
;

delimiter $$
CREATE TRIGGER delete_contact_trigger
AFTER DELETE ON Contact
FOR EACH ROW
	INSERT INTO ContactAudit (operation, contactId, mobileNumber, emailAddress, modifierId, modifiedOn)
	VALUES ('DELETE', OLD.contactId, OLD.mobileNumber, OLD.emailAddress, OLD.modifierId, OLD.modifiedOn);
$$
;

