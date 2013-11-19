package common;

public class Status {
	public static final int PENDING = 1;
	public static final int AWAITING_ACK = 2;
	public static final int SENT = 3;
	public static final int ERROR = 4;
	public static final int OTHER = 5;

	public static int getStatusCode(String status) {
		if ("PENDING".equalsIgnoreCase(status)) {
			return PENDING;
		} else if ("AWAITING_ACK".equalsIgnoreCase(status)) {
			return AWAITING_ACK;
		} else if ("SENT".equalsIgnoreCase(status)) {
			return SENT;
		} else if ("ERROR".equalsIgnoreCase(status)) {
			return ERROR;
		} else {
			return OTHER;
		}
	}

	public static String getString(int statusCode) {
		switch (statusCode) {
		case PENDING:
			return "PENDING";
		case AWAITING_ACK:
			return "AWAITING_ACK";
		case SENT:
			return "SENT";
		case ERROR:
			return "ERROR";
		case OTHER:
		default:
			return "OTHER";
		}
	}
}
