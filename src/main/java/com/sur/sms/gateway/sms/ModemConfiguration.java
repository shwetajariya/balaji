package com.sur.sms.gateway.sms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.smslib.GatewayException;
import org.smslib.SMSLibException;
import org.smslib.Service;
import org.smslib.TimeoutException;

public class ModemConfiguration {

	public static List<ModemGateway> listModemGetway;

	static {
		listModemGetway = new ArrayList<ModemGateway>();
		int totalModem = Integer.parseInt(PropertiesUtil
				.getProperty(Constent.totalModem));
		listModemGetway = new ArrayList<ModemGateway>();
		for (int i = 1; i <= totalModem; i++) {
			Modem modem = new Modem();
			modem.setPort(PropertiesUtil.getProperty(Constent.totalModem + i));
			modem.setBitrate(Integer.parseInt(PropertiesUtil
					.getProperty(Constent.prefixBitRate + i)));
			modem.setModemName(PropertiesUtil
					.getProperty(Constent.prefixModemName + i));
			modem.setModemPin(PropertiesUtil
					.getProperty(Constent.prefixModemPin + i));
			modem.setSmsc(PropertiesUtil.getProperty(Constent.prefixSMSC + i));
			ModemGateway modemGateway = new ModemGateway();
			try {
				modemGateway.addGateway(modem);
				listModemGetway.add(modemGateway);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public void startService() throws TimeoutException, GatewayException,
			SMSLibException, IOException, InterruptedException {
		Service.getInstance().startService();

	}

	public void stopService() throws TimeoutException, GatewayException,
			SMSLibException, IOException, InterruptedException {
		Service.getInstance().stopService();

	}

}
