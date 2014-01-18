package com.sur.balaji.service.sms;

import org.apache.log4j.Logger;

import com.sur.balaji.model.SMSMessageEntry;

public class SMSPushTask implements Runnable {

	private SMSMessageEntry smsMessageEntry;
	protected final Logger log = Logger.getLogger(SMSPushTask.class);

	public SMSPushTask(SMSMessageEntry smsMessageEntry) {
		this.smsMessageEntry = smsMessageEntry;
	}

	@Override
	public void run() {

		log.info("Sending SMS Message - " + smsMessageEntry);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
