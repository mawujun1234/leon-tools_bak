package com.mawujun.utils;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateUtils extends org.apache.commons.lang3.time.DateUtils{

    
    private static Logger logger = LoggerFactory.getLogger(DateUtils.class);
	/**
	 * yyyy-MM-dd
	 */
	public static final Integer DATE_SHORT = 0;
	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static final Integer DATE_TIME=1;
	static HashMap<Integer,SimpleDateFormat> cache_format=new HashMap<Integer,SimpleDateFormat>();
	static {

		cache_format.put(DATE_SHORT, new SimpleDateFormat("yyyy-MM-dd"));
		cache_format.put(DATE_TIME, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
	}
	

	public static Date long2Date(long var0) {
		Calendar var2 = Calendar.getInstance();
		var2.setTimeInMillis(var0);
		return var2.getTime();
	}

	public static String long2String(long var0) {
		return date2String(long2Date(var0), DATE_TIME);
	}

	public static long date2Long(Date var0) {
		Calendar var1 = Calendar.getInstance();
		var1.setTime(var0);
		return var1.getTimeInMillis();
	}

	/**
	 * 
	 * @param date
	 * @param format DateUtils.DATE_TIME
	 * @return
	 */
	public static String date2String(Date date, int format) {
		return date == null ? " " : cache_format.get(format).format(date);
	}

	public static String date2String(Date date, String format) {
		SimpleDateFormat var2 = new SimpleDateFormat(format);
		return var2.format(date);
	}


	/**
	 * 输出指定的日期时间格式 yyy-MM-dd HH:mm:ss
	 * @param var0
	 * @return
	 */
	public static String date2String(Date var0) {
		return cache_format.get(DATE_TIME).format(var0);
	}

    
	public static long string2Long(String var0, int var1) {
		return date2Long(string2Date(var0, var1));
	}

	public static Date getDateNow() {
		Calendar var0 = Calendar.getInstance();
		return var0.getTime();
	}
	/**
	 * 获取当前的日期时间  yyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String getStringNow() {
		return date2String(getDateNow(), DATE_TIME);
	}

	/**
	 * 
	 * @param DateUtils.DATE_TIME
	 * @return
	 */
	public static String getStringNow(int format) {
		Calendar var1 = Calendar.getInstance();
		return cache_format.get(format).format(var1.getTime());
	}

	public static long getLongNow() {
		return date2Long(getDateNow());
	}
	/**
	 * 把指定格式的日期转换为日期类型
	 * @param var0
	 * @param var1
	 * @return
	 */
	public static Date string2Date(String var0, int var1) {
		if (var0==null || "".equals(var0)) {
			return Calendar.getInstance().getTime();
		} else {
			if (var1 == -1) {
				int var2 = var0.indexOf("-");
				if (var2 > 0) {
					var2 = var0.indexOf(":");
					if (var2 > 0) {
						var1 = 1;
					} else if (var0.indexOf("-", var2 + 1) > 0) {
						var1 = 0;
					} else {
						var1 = 8;
					}
				} else {
					var2 = var0.indexOf(":");
					if (var2 <= 0) {
						return Calendar.getInstance().getTime();
					}

					var1 = 2;
				}
			}

			DateFormat var8 = cache_format.get(var1);
			Date var3 = null;

			String var5;
            try {
                var3 = var8.parse(var0);
            } catch (ParseException var6) {
                var5 = "解析日期{" + var0 + "}格式{" + ((SimpleDateFormat)var8).toPattern() + "}异常!";
                if (logger.isDebugEnabled()) {
                	logger.error(var5, var6);
                } else {
                	logger.error(var5);
                }
            } catch (Exception var7) {
                var3 = Calendar.getInstance().getTime();
                var5 = "转换日期{" + var0 + "}为{" + ((SimpleDateFormat)var8).toPattern() + "}是格式时异常!";
                if (logger.isDebugEnabled()) {
                	logger.error(var5, var7);
                } else {
                	logger.error(var5);
                }
            }

			return var3;
		}
	}
	/**
	 * 把当前日期和参数日期进行比较，当前时间减去参数的时间
	 * 第二个参数是Calendar.SECOND,Calendar.MINUTE,Calendar.HOUR,Calendar.DAY_OF_MONTH
	 * @param var0
	 * @param var1
	 * @return
	 */
	public static int compareDate(Date date, int var1) {
		return compareDate(date, Calendar.getInstance().getTime(), var1);
	}

	/**
	 * 
	 * @param date
	 * @param field Calendar.SECOND,Calendar.MINUTE,Calendar.HOUR,Calendar.DAY_OF_MONTH
	 * @param var2
	 * @return
	 */
	public static Date addDate(Date date, int field, int var2) {
		if (field < 0) {
			logger.warn("日期增减操作时不支持类型:" + field);
			return date;
		} else {
			Calendar var3 = Calendar.getInstance();
			var3.setTime(date);
			var3.add(field, var2);
			return var3.getTime();
		}
	}

	public static Date addTodayDate(int var0, int var1) {
		return addDate(getDateNow(), var0, var1);
	}

	/**
	 *  比较两个日期的差距，后面一个日期减去前面的一个日期
	 * @param var0
	 * @param var1
	 * @param var2 Calendar.SECOND,Calendar.MINUTE,Calendar.HOUR,Calendar.DAY_OF_MONTH
	 * @return
	 */
	public static int compareDate(Date var0, Date var1, int var2) {
		long var3 = var1.getTime() - var0.getTime();
		if (var2 == Calendar.MINUTE) {
			var3 = var3 / 60000;
		} else if (var2 == Calendar.HOUR) {
			var3 = var3 / 3600000;
		} else if (var2 == Calendar.DAY_OF_MONTH) {
			var3 = var3 / 86400000;
		} else if (var2 == Calendar.SECOND) {
			var3 = var3 / 1000;
		}

		return (int) var3;
		
//		double var3 = (double) (var1.getTime() - var0.getTime());
//		if (var2 == Calendar.MINUTE) {
//			var3 = fixDouble2(var3 / 60000.0D);
//		} else if (var2 == Calendar.HOUR) {
//			var3 = fixDouble2(var3 / 3600000.0D);
//		} else if (var2 == Calendar.DAY_OF_MONTH) {
//			var3 = fixDouble2(var3 / 8.64E7D);
//		} else if (var2 == Calendar.SECOND) {
//			var3 = var3 / 1000;
//		}
//
//		return (int) var3;
	}
//	private static DecimalFormat decimalFormat =new DecimalFormat("#.00");
//	public static double fixDouble2(double var0) {
//		return fixDouble(var0, 2);
//	}
//
//	public static double fixDouble(double var0, int var2) {
//		if (var2 < 0) {
//			var2 = 2;
//		}
//
//		DecimalFormat var3 = null;
//		if (var2 == 2) {
//			var3 = decimalFormat;
//		} else {
//			String var4 = String.valueOf((int) Math.pow(10.0D, (double) var2));
//			var3 = new DecimalFormat(var2 == 0 ? "#" : "#." + var4.substring(1));
//		}
//
//		return Double.parseDouble(var3.format(var0));
//	}
	
}
