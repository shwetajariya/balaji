package com.sur.sms.gateway.sms;

public class TestSms {

	private static String port = "COM29"; // Modem Port.
	private static int bitRate = 115200; // this is also optional. leave as it
											// is.
	private static String modemName = "ZTE"; // this is optional.
	private static String modemPin = null; // Pin code if any have assigned to
											// the modem.
	private static String SMSC = "+919827002222"; // Message Center Number ex.
													// Mobitel

	public static void main(String[] args) throws Exception {
		SendSMS gsmModem = new SendSMS();
		SendSMS.configModem(port, bitRate, modemName, modemPin, SMSC);
		System.out.println(" configure");
		gsmModem.startService();
		for (int i = 0; i < 2; i++) {
			gsmModem.Sender("+919039344397", "Test msg"); // (tp, msg)
		}
		System.out.println(" send");
		gsmModem.stopService();
		// PropertiesUtil obj = new PropertiesUtil();
		// obj.getProperty("");
	}
}