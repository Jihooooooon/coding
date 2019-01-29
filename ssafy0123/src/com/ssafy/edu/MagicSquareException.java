package com.ssafy.edu;

public class MagicSquareException extends Exception {

	public MagicSquareException() {
		// TODO Auto-generated constructor stub
		super("이런 마방진은 존재하지 않습니다");
	}

	public MagicSquareException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public MagicSquareException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public MagicSquareException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public MagicSquareException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
