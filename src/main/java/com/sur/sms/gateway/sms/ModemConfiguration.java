package com.sur.sms.gateway.sms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.smslib.GatewayException;
import org.smslib.SMSLibException;
import org.smslib.Service;
import org.smslib.TimeoutException;

import com.sur.balaji.gateway.Constent;
import com.sur.balaji.gateway.Modem;
import com.sur.balaji.gateway.ModemGatewayService;
import com.sur.balaji.gateway.PropertiesUtil;

public class ModemConfiguration {

	public static List<ModemGatewayService> listModemGetway;

	public void configure() {
		listModemGetway = new ArrayList<ModemGatewayService>();
		int totalModem = Integer.parseInt(PropertiesUtil
				.getProperty(Constent.totalModem));
		listModemGetway = new ArrayList<ModemGatewayService>();
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
			ModemGatewayService modemGateway = new ModemGatewayService();
			try {
				modemGateway.addGateway(modem);
				listModemGetway.add(modemGateway);
			} catch (Exception e) {
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
