package com.sur.sms.gateway.sms;

import java.io.IOException;

import org.smslib.AGateway;
import org.smslib.GatewayException;
import org.smslib.IOutboundMessageNotification;
import org.smslib.Library;
import org.smslib.OutboundMessage;
import org.smslib.SMSLibException;
import org.smslib.Service;
import org.smslib.TimeoutException;
import org.smslib.modem.SerialModemGateway;

public class SendSMS {
	private static String port;
	private static int bitrate;
	private static String modem;
	private static String modemPin;
	private static String smsc;
	private static String tp;
	private static String msgBody;

	public static void configModem(String p, int b, String m, String pi,
			String s) {
		port = p;
		bitrate = b;
		modem = m;
		modemPin = pi;
		smsc = s;
	}

	public void Sender(String tpnum, String message) throws Exception {
		tp = tpnum;
		msgBody = message;
		doIt();
	}

	public void startService() throws Exception {
		SendSMS.OutboundNotification outboundNotification = new SendSMS.OutboundNotification(
				this);
		System.out.println("Send message from a serial gsm modem.");
		System.out.println(Library.getLibraryDescription());
		System.out.println("Version: " + Library.getLibraryVersion());
		SerialModemGateway gateway = new SerialModemGateway("modem.com1", port,
				bitrate, modem, "");
		gateway.setInbound(true);
		gateway.setOutbound(true);
		gateway.setSimPin(modemPin);

		gateway.setSmscNumber(smsc);
		Service.getInstance().setOutboundMessageNotification(
				outboundNotification);
		Service.getInstance().addGateway(gateway);
		Service.getInstance().startService();
		System.out.println();
		System.out.println("Modem Information:");
		System.out.println("  Manufacturer: " + gateway.getManufacturer());
		System.out.println("  Model: " + gateway.getModel());
		System.out.println("  Serial No: " + gateway.getSerialNo());
		System.out.println("  SIM IMSI: " + gateway.getImsi());
		System.out.println("  Signal Level: " + gateway.getSignalLevel()
				+ " dBm");
		System.out.println("  Battery Level: " + gateway.getBatteryLevel()
				+ "%");
		System.out.println();

	}

	public void stopService() throws TimeoutException, GatewayException,
			SMSLibException, IOException, InterruptedException {
		Service.getInstance().stopService();

	}

	public void doIt() throws Exception {
		// SendSMS.OutboundNotification outboundNotification = new
		// SendSMS.OutboundNotification(this);
		// System.out.println("Send message from a serial gsm modem.");
		// System.out.println(Library.getLibraryDescription());
		// System.out.println("Version: " + Library.getLibraryVersion());
		// SerialModemGateway gateway = new SerialModemGateway("modem.com1",
		// port,
		// bitrate, modem, "");
		// gateway.setInbound(true);
		// gateway.setOutbound(true);
		// gateway.setSimPin(modemPin);
		//
		// gateway.setSmscNumber(smsc);
		// Service.getInstance().setOutboundMessageNotification(
		// outboundNotification);
		// Service.getInstance().addGateway(gateway);
		// Service.getInstance().startService();
		// System.out.println();
		// System.out.println("Modem Information:");
		// System.out.println("  Manufacturer: " + gateway.getManufacturer());
		// System.out.println("  Model: " + gateway.getModel());
		// System.out.println("  Serial No: " + gateway.getSerialNo());
		// System.out.println("  SIM IMSI: " + gateway.getImsi());
		// System.out.println("  Signal Level: " + gateway.getSignalLevel()
		// + " dBm");
		// System.out.println("  Battery Level: " + gateway.getBatteryLevel()
		// + "%");
		// System.out.println();

		OutboundMessage msg = new OutboundMessage(tp, msgBody);
		Service.getInstance().sendMessage(msg);
		System.out.println(msg);

		// System.out.println("Now Sleeping - Hit <enter> to terminate.");
		// System.in.read();
		// Service.getInstance().stopService();
	}

	class OutboundNotification implements IOutboundMessageNotification {
		public OutboundNotification(SendSMS paramGsmModem) {
		}

		public void process(AGateway gateway, OutboundMessage msg) {
			System.out.println("Outbound handler called from Gateway: "
					+ gateway.getGatewayId());
			System.out.println(msg);
		}
	}
}
