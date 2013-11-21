package com.sur.sms.gateway.sms;

import org.smslib.AGateway;
import org.smslib.IOutboundMessageNotification;
import org.smslib.OutboundMessage;
import org.smslib.Service;
import org.smslib.modem.SerialModemGateway;

public class ModemGateway {

	public SerialModemGateway gateway;

	public void addGateway(Modem modem) throws Exception {
		ModemGateway.OutboundNotification outboundNotification = new ModemGateway.OutboundNotification(
				this);
		// System.out.println("Send message from a serial gsm modem.");
		// System.out.println(Library.getLibraryDescription());
		// System.out.println("Version: " + Library.getLibraryVersion());
		gateway = new SerialModemGateway("modem.com1", modem.getPort(),
				modem.getBitrate(), modem.getModemName(), "");
		gateway.setInbound(true);
		gateway.setOutbound(true);
		gateway.setSimPin(modem.getModemPin());
		gateway.setSmscNumber(modem.getSmsc());
		Service.getInstance().setOutboundMessageNotification(
				outboundNotification);
		Service.getInstance().addGateway(gateway);
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

	}

	public void Sender(String contact, String message) throws Exception {
		OutboundMessage msg = new OutboundMessage(contact, message);
		Service.getInstance().getGateway(this.gateway.getGatewayId())
				.sendMessage(msg);
		System.out.println(msg);
	}

	class OutboundNotification implements IOutboundMessageNotification {
		public OutboundNotification(ModemGateway paramGsmModem) {
		}

		public void process(AGateway gateway, OutboundMessage msg) {
			System.out.println("Outbound handler called from Gateway: "
					+ gateway.getGatewayId());
			System.out.println(msg);
		}
	}
}
