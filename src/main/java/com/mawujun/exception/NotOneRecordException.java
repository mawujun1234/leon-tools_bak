package com.mawujun.exception;
/**
 * 查询结果超过一条的记录
 * @author mawujun
 *
 */
public class NotOneRecordException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5466319083190647059L;

	public NotOneRecordException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NotOneRecordException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public NotOneRecordException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public NotOneRecordException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public NotOneRecordException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	

}
