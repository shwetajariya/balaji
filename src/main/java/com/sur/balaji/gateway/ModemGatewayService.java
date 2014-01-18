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

@org.springframework.stereotype.Service
public class ModemGatewayService {

	public SerialModemGateway gateway;
	protected final Logger log = Logger.getLogger(ModemGatewayService.class);

	public ModemGatewayService() {
	}

	@PostConstruct
	public void init() {
		int totalModem = Integer.parseInt(PropertiesUtil.getProperty(Constent.totalModem));
		for (int i = 1; i <= totalModem; i++) {
			try {
				Modem modem = new Modem();
				modem.setPort(PropertiesUtil.getProperty(Constent.totalModem + i));
				modem.setBitrate(Integer.parseInt(PropertiesUtil.getProperty(Constent.prefixBitRate + i)));
				modem.setModemName(PropertiesUtil.getProperty(Constent.prefixModemName + i));
				modem.setModemPin(PropertiesUtil.getProperty(Constent.prefixModemPin + i));
				modem.setSmsc(PropertiesUtil.getProperty(Constent.prefixSMSC + i));
				
				log.info("Adding modem gateway: " + modem);
				this.addGateway(modem);
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
	}

	public void startService() throws TimeoutException, GatewayException, SMSLibException, IOException,
			InterruptedException {
		Service.getInstance().startService();
	}

	public void stopService() throws TimeoutException, GatewayException, SMSLibException, IOException,
			InterruptedException {
		Service.getInstance().stopService();
	}

	public void addGateway(Modem modem) throws Exception {
		ModemGatewayService.OutboundNotification outboundNotification = new ModemGatewayService.OutboundNotification(this);
		log.info("Configuring serial modem gateway using properties: " + modem);
		gateway = new SerialModemGateway("modem.com1", modem.getPort(), modem.getBitrate(), modem.getModemName(), "");
		gateway.setInbound(true);
		gateway.setOutbound(true);
		gateway.setSimPin(modem.getModemPin());
		gateway.setSmscNumber(modem.getSmsc());
		
		Service.getInstance().setOutboundMessageNotification(outboundNotification);
		Service.getInstance().addGateway(gateway);

		try{
			log.info("Modem Information:");
			log.info("  Manufacturer: " + gateway.getManufacturer());
			log.info("  Model: " + gateway.getModel());
			log.info("  Serial No: " + gateway.getSerialNo());
			log.info("  SIM IMSI: " + gateway.getImsi());
			log.info("  Signal Level: " + gateway.getSignalLevel());
			log.info("  Battery Level: " + gateway.getBatteryLevel());
		} catch (Exception ex) {
			log.warn("Error while configuring modem: ", ex);
		}
	}

	public void sendSMS(String contact, String message) throws Exception {
		OutboundMessage msg = new OutboundMessage(contact, message);
		Service.getInstance().getGateway(this.gateway.getGatewayId()).sendMessage(msg);
		log.info(">> Sent message:" + msg);
	}

	class OutboundNotification implements IOutboundMessageNotification {
		public OutboundNotification(ModemGatewayService paramGsmModem) {
		}

		public void process(AGateway gateway, OutboundMessage msg) {
			log.info("Outbound handler called from Gateway: " + gateway.getGatewayId());
			log.info(msg);
		}
	}
}
