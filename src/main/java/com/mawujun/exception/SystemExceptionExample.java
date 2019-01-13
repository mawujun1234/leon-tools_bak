package com.mawujun.exception;


import com.mawujun.exception.PaymentCode;
import com.mawujun.exception.BizException;

public class SystemExceptionExample {

	public static void main(String[] args) {
		try {
			throw new BizException(PaymentCode.CREDIT_CARD_EXPIRED);
		} catch (BizException e) {
			if (e.getErrorCode() == PaymentCode.CREDIT_CARD_EXPIRED) {
				System.out.println("Credit card expired");
			}
		}
	}

}
