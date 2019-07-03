package com.mawujun.exception.exceptions;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

import com.mawujun.exception.DefaulExceptionCode;
import com.mawujun.exception.ExceptionCode;
import com.mawujun.exception.IntErrorCode;

/**
 * 真个系统的异常总类，整个系统都可以使用这个异常
 * @author mawujun
 *
 */
public class BizException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public static BizException wrap(Throwable exception, ExceptionCode errorCode) {
        if (exception instanceof BizException) {
            BizException se = (BizException)exception;
        	if (errorCode != null && errorCode != se.getErrorCode()) {
                return new BizException(exception.getMessage(), exception, errorCode);
			}
			return se;
        } else {
            return new BizException(exception.getMessage(), exception, errorCode);
        }
    }
    
    public static BizException wrap(Throwable exception) {
    	return wrap(exception, null);
    }
    
    private ExceptionCode errorCode;
    private final Map<String,Object> properties = new TreeMap<String,Object>();
    
    public BizException(ExceptionCode errorCode) {
		this.errorCode = errorCode;
	}
    
    public BizException(String message) {
		this(message,DefaulExceptionCode.SYSTEM_EXCEPTION);
	}

	public BizException(String message, ExceptionCode errorCode) {
		super(message);
		this.errorCode = errorCode;
	}
	
	public BizException(String msg, int errorCode) {
		super(msg);
		this.errorCode = new IntErrorCode(errorCode);
	}

	public BizException(Throwable cause, ExceptionCode errorCode) {
		super(cause);
		this.errorCode = errorCode;
	}
	
	public BizException(String message, Throwable cause) {
		super(message, cause);
	}

	public BizException(String message, Throwable cause, ExceptionCode errorCode) {
		super(message, cause);
		this.errorCode = errorCode;
	}
	
	public ExceptionCode getErrorCode() {
        return errorCode;
    }
	
	public BizException setErrorCode(ExceptionCode errorCode) {
        this.errorCode = errorCode;
        return this;
    }
	
	public Map<String, Object> getProperties() {
		return properties;
	}
	
    @SuppressWarnings("unchecked")
	public <T> T get(String name) {
        return (T)properties.get(name);
    }
	
    public BizException set(String name, Object value) {
        properties.put(name, value);
        return this;
    }
    
    public void printStackTrace(PrintStream s) {
        synchronized (s) {
            printStackTrace(new PrintWriter(s));
        }
    }

    public void printStackTrace(PrintWriter s) { 
        synchronized (s) {
            s.println(this);
            s.println("\t-------------------------------");
            if (errorCode != null) {
	        	s.println("\t" + errorCode + ":" + errorCode.getClass().getName()); 
			}
            for (String key : properties.keySet()) {
            	s.println("\t" + key + "=[" + properties.get(key) + "]"); 
            }
            s.println("\t-------------------------------");
            StackTraceElement[] trace = getStackTrace();
            for (int i=0; i < trace.length; i++)
                s.println("\tat " + trace[i]);

            Throwable ourCause = getCause();
            if (ourCause != null) {
                ourCause.printStackTrace(s);
            }
            s.flush();
        }
    }
    
}
