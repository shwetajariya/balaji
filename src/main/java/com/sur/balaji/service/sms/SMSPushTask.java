package com.sur.balaji.service.sms;

import org.apache.log4j.Logger;

import com.sur.balaji.gateway.ModemGatewayService;
import com.sur.balaji.model.SMSMessageEntry;

public class SMSPushTask implements Runnable {

	private SMSMessageEntry smsMessageEntry;
	protected final Logger log = Logger.getLogger(SMSPushTask.class);
	private ModemGatewayService modemService;

	public SMSPushTask(SMSMessageEntry smsMessageEntry, ModemGatewayService modemService) {
		this.smsMessageEntry = smsMessageEntry;
		this.modemService = modemService;
	}

	@Override
	public void run() {

		log.info("Sending SMS Message - " + smsMessageEntry);
		try {
			modemService.sendSMS(smsMessageEntry.getMobileNumber(), smsMessageEntry.getSmsText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
