package com.mawujun.exception;

import com.mawujun.exception.ValidationCode;
import com.mawujun.exception.exceptions.BizException;

public class SystemExceptionExample2 {

	private static final int MIN_LENGTH = 10;

	public static void main(String[] args) {
		validate("email", "abc");
	}

	public static void validate(String field, String value) {
		if (value == null || value.length() < MIN_LENGTH) {
			throw new BizException(ValidationCode.VALUE_TOO_SHORT)
			.set("field", field).set("value", value).set("min-length", MIN_LENGTH); 
		}
	}

}
