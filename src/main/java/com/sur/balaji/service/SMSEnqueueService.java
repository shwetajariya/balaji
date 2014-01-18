package com.sur.balaji.service;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.sur.balaji.dao.ContactHome;
import com.sur.balaji.dao.GroupsHome;
import com.sur.balaji.gateway.ModemGatewayService;
import com.sur.balaji.model.Contact;
import com.sur.balaji.model.ContactGroupMapping;
import com.sur.balaji.model.Groups;
import com.sur.balaji.model.SMSMessage;
import com.sur.balaji.model.SMSMessageEntry;
import com.sur.balaji.service.sms.ExecutorService;
import com.sur.balaji.service.sms.SMSPushTask;

@Service
public class SMSEnqueueService {

	protected final Log log = LogFactory.getLog(SMSEnqueueService.class);
	private GroupsHome groupsHome;
	private ContactHome contactHome;
	private ExecutorService executorService;
	private ModemGatewayService gatewayService;

	@Autowired
	public void setGroupsHome(GroupsHome groupsHome) {
		this.groupsHome = groupsHome;
	}

	@Autowired
	public void setContactHome(ContactHome contactHome) {
		this.contactHome = contactHome;
	}

	@Autowired
	public void setSMSDeliveryService(ExecutorService deliveryService) {
		this.executorService = deliveryService;
	}
	
	@Autowired
	public void setModemGatewayService(ModemGatewayService gatewayService){
		this.gatewayService = gatewayService;
	}

	public void sendSMSMessage(SMSMessage smsMessage) {
		try {
			Set<Contact> contactSet = getAllContacts(smsMessage);
			String[] numbers = getAllNumbers(smsMessage);

			for (Contact contact : contactSet) {
				SMSMessageEntry smsMessageEntry = new SMSMessageEntry();
				smsMessageEntry.setContact(contact);
				smsMessageEntry.setSmsText(smsMessage.getMessageText());

				SMSPushTask smsTask = new SMSPushTask(smsMessageEntry, gatewayService);
				executorService.execute(smsTask);
			}

			for (String number : numbers) {
				SMSMessageEntry smsMessageEntry = new SMSMessageEntry();
				smsMessageEntry.setMobileNumber(number);
				smsMessageEntry.setSmsText(smsMessage.getMessageText());

				SMSPushTask smsTask = new SMSPushTask(smsMessageEntry, gatewayService);
				executorService.execute(smsTask);
			}
		} catch (Exception ex) {
			log.error("sendSMSMessage() - " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	private Set<Contact> getAllContacts(SMSMessage smsMessage) {
		Set<Contact> contactSet = new ConcurrentSkipListSet<Contact>();

		if (smsMessage.getSelectedGroups() != null
				&& smsMessage.getSelectedGroups().size() > 0) {

			for (String groupStr : smsMessage.getSelectedGroups()) {
				Long groupId = Long.valueOf(groupStr);
				Groups group = groupsHome.findById(groupId);
				Set<ContactGroupMapping> contactGroupMappings = group
						.getContactGroupMappings();

				for (ContactGroupMapping contactGroupMapping : contactGroupMappings) {
					Contact contact = contactGroupMapping.getContact();
					contactSet.add(contact);
				}
			}
		}

		if (smsMessage.getSelectedContacts() != null
				&& smsMessage.getSelectedContacts().size() > 0) {

			for (String contactIdStr : smsMessage.getSelectedContacts()) {
				Long contactId = Long.valueOf(contactIdStr);
				Contact contact = contactHome.findById(contactId);

				contactSet.add(contact);
			}
		}

		return contactSet;
	}

	private String[] getAllNumbers(SMSMessage smsMessage) {
		String[] numbers;

		if (StringUtils.hasText(smsMessage.getMobileNumbers())) {
			numbers = StringUtils.delimitedListToStringArray(
					smsMessage.getMobileNumbers(), ",");
		} else {
			numbers = new String[0];
		}

		return numbers;
	}
}
