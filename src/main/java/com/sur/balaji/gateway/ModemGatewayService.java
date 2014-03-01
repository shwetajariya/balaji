package com.sur.balaji.gateway;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.smslib.AGateway;
import org.smslib.GatewayException;
import org.smslib.IOutboundMessageNotification;
import org.smslib.OutboundMessage;
import org.smslib.SMSLibException;
import org.smslib.Service;
import org.smslib.TimeoutException;
import org.smslib.modem.SerialModemGateway;

import com.sur.balaji.model.SMSMessageEntry;

@org.springframework.stereotype.Service
public class ModemGatewayService {

	public static SerialModemGateway[] gateway;
	protected final Logger log = Logger.getLogger(ModemGatewayService.class);

	public ModemGatewayService() {
	}

	@PostConstruct
	public void init() {
		int totalModem = Integer.parseInt(PropertiesUtil
				.getProperty(Constent.totalModem));
		gateway = new SerialModemGateway[2];
		for (int i = 1; i <= totalModem; i++) {
			try {
				Modem modem = new Modem();
				modem.setPort(PropertiesUtil
						.getProperty(Constent.prefixModemPort + i));
				modem.setBitrate(Integer.parseInt(PropertiesUtil
						.getProperty(Constent.prefixBitRate + i)));
				modem.setModemName(PropertiesUtil
						.getProperty(Constent.prefixModemName + i));
				modem.setModemPin(PropertiesUtil
						.getProperty(Constent.prefixModemPin + i));
				modem.setSmsc(PropertiesUtil.getProperty(Constent.prefixSMSC
						+ i));
				modem.setGatewayName(PropertiesUtil
						.getProperty(Constent.prefixGatewayName + i));

				log.info("Adding modem gateway: " + modem);
				this.addGateway(modem, i - 1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		try {
			log.info("Starting Modem service...");
			startService();
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (GatewayException e) {
			e.printStackTrace();
		} catch (SMSLibException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		try {
			for (int j = 0; j <= 1; j++) {
				log.info("Modem Information:");
				log.info("  Manufacturer: " + gateway[j].getManufacturer());
				log.info("  Model: " + gateway[j].getModel());
				log.info("  Serial No: " + gateway[j].getSerialNo());
				log.info("  SIM IMSI: " + gateway[j].getImsi());
				log.info("  Signal Level: " + gateway[j].getSignalLevel());
				log.info("  Battery Level: " + gateway[j].getBatteryLevel());
			}
		} catch (Exception ex) {
			log.warn("Error while configuring modem: ", ex);
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

	public void addGateway(Modem modem, int j) throws Exception {
		ModemGatewayService.OutboundNotification outboundNotification = new ModemGatewayService.OutboundNotification(
				this);
		log.info("Configuring serial modem gateway using properties: " + modem);
		gateway[j] = new SerialModemGateway("modem.com1", modem.getPort(),
				modem.getBitrate(), modem.getModemName(), "");
		gateway[j].setInbound(true);
		gateway[j].setOutbound(true);
		gateway[j].setSimPin(modem.getModemPin());
		gateway[j].setSmscNumber(modem.getSmsc());

		Service.getInstance().setOutboundMessageNotification(
				outboundNotification);
		Service.getInstance().addGateway(gateway[j]);
	}

	public void sendSMS(SMSMessageEntry entry) throws Exception {
		// change method call for test
				this.sendSMS(entry.getMobileNumberImpl(), entry.getSmsText(),
						entry.getGatewayID());
	}

	@SuppressWarnings("unused")
	private void sendSMS(String contact, String message) throws Exception {
		OutboundMessage msg = new OutboundMessage(contact, message);
		// Service.getInstance().getGateway(this.gateway.getGatewayId()).sendMessage(msg);
		Service.getInstance().queueMessage(msg);
		log.info(">> Queued SMS message:" + msg);
	}

	class OutboundNotification implements IOutboundMessageNotification {
		public OutboundNotification(ModemGatewayService paramGsmModem) {
		}

		public void process(AGateway gateway, OutboundMessage msg) {
			log.info("Outbound handler called from Gateway: "
					+ gateway.getGatewayId());
			log.info("SMS Delivery Report:- " + msg);
		}
	}

	private void sendSMS(String contact, String message, String gatewayId)
			throws Exception {
		OutboundMessage msg = new OutboundMessage(contact, message);
		// Service.getInstance().getGateway(this.gateway.getGatewayId()).sendMessage(msg);
		Service.getInstance().getGateway(gatewayId).sendMessage(msg);
	}

}
