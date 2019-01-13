package com.mawujun.exception;

public class IntErrorCode implements ExceptionCode {

	public IntErrorCode(int number) {
		super();
		this.number = number;
	}
	private int number;
	@Override
	public int getNumber() {
		// TODO Auto-generated method stub
		return number;
	}

}
