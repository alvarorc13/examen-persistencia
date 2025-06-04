package main.java.exception;

public class CentralException extends Exception {

	public CentralException() {
	}

	public CentralException(String message) {
		super(message);
	}

	public CentralException(Throwable cause) {
		super(cause);
	}

	public CentralException(String message, Throwable cause) {
		super(message, cause);
	}

	public CentralException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
