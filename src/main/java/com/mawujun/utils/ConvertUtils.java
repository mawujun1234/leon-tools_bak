package com.mawujun.utils;

import java.util.Date;

import org.apache.commons.beanutils.converters.DateConverter;

/**
 * 类型转换工具类
 * @author admin
 *
 */
public class ConvertUtils extends org.apache.commons.beanutils.ConvertUtils {
	static {
		DateConverter dc = new DateConverter();
		dc.setUseLocaleFormat(true);
		//dc.setPatterns(new String[] { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss","HH:mm:ss" });
		dc.setPatterns(DateUtils.getDatePatterns());
		ConvertUtils.register(dc, Date.class);
		
	}
	
	/**
	 * 添加了枚举类型转换支持
	 * 支持日期，日期时间，时间格式，"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss","HH:mm:ss"
	 * @param value
	 * @param clazz
	 * @return
	 */
	public static Object convert(String value, Class clazz) {
		if(clazz.isEnum()) {
			return EnumUtils.getEnum(clazz, value);
		}
		
		
		return org.apache.commons.beanutils.ConvertUtils.convert(value, clazz);
    }
	/**
	 * 添加了枚举类型的支持
	 *  支持日期，日期时间，时间格式，"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss","HH:mm:ss"
	 * @param value
	 * @param clazz
	 * @return
	 */
	public static Object convert(Object value, Class clazz) {
		if(clazz.isEnum()) {
			return EnumUtils.getEnum(clazz, value.toString());
		}
		
		
		return org.apache.commons.beanutils.ConvertUtils.convert(value, clazz);
    }

}
