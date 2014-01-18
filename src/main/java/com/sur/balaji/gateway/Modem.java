package com.sur.balaji.gateway;

public class Modem {

	private String port;
	private int bitrate;
	private String modemName;
	private String modemPin;
	private String smsc;

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public int getBitrate() {
		return bitrate;
	}

	public void setBitrate(int bitrate) {
		this.bitrate = bitrate;
	}

	public String getModemName() {
		return modemName;
	}

	public void setModemName(String modemName) {
		this.modemName = modemName;
	}

	public String getModemPin() {
		return modemPin;
	}

	public void setModemPin(String modemPin) {
		this.modemPin = modemPin;
	}

	public String getSmsc() {
		return smsc;
	}

	public void setSmsc(String smsc) {
		this.smsc = smsc;
	}

	@Override
	public String toString() {
		return "Modem [port=" + port + ", bitrate=" + bitrate + ", modemName="
				+ modemName + ", modemPin=" + modemPin + ", smsc=" + smsc + "]";
	}

}
