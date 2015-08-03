package com.mawujun.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class DateUtils {
	static SimpleDateFormat yyyy_MM_dd;
	static HashMap<String,SimpleDateFormat> format_cache=new HashMap<String,SimpleDateFormat>();
	static {
		yyyy_MM_dd=new SimpleDateFormat("yyyy-MM-dd");
		format_cache.put("yyyy-MM-dd", yyyy_MM_dd);
	}
	public static String format(Date date,String format) {
		if(date==null){
			return null;
		}
		if(format_cache.get(format)!=null){
			return format_cache.get(format).format(date);
		} else {
			SimpleDateFormat yyyy_MM_dd=new SimpleDateFormat(format);
			String r= yyyy_MM_dd.format(date);
			format_cache.put(format, yyyy_MM_dd);
			return r;
		}
	}
	/**
	 * 默认的格式yyyy-MM-dd
	 * @author mawujun email:160649888@163.com qq:16064988
	 * @param date
	 * @return
	 */
	public static String format(Date date) {
		if(date==null){
			return null;
		}
		return yyyy_MM_dd.format(date);
	}
	
}
