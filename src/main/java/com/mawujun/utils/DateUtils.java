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

public class DateUtils {
//	static SimpleDateFormat yyyy_MM_dd;
//	static HashMap<String,SimpleDateFormat> format_cache=new HashMap<String,SimpleDateFormat>();
//	static {
//		yyyy_MM_dd=new SimpleDateFormat("yyyy-MM-dd");
//		format_cache.put("yyyy-MM-dd", yyyy_MM_dd);
//	}
//	
//	public static String format(Date date,String format) {
//		if(date==null){
//			return null;
//		}
//		if(format_cache.get(format)!=null){
//			return format_cache.get(format).format(date);
//		} else {
//			SimpleDateFormat yyyy_MM_dd=new SimpleDateFormat(format);
//			String r= yyyy_MM_dd.format(date);
//			format_cache.put(format, yyyy_MM_dd);
//			return r;
//		}
//	}
//	/**
//	 * 默认的格式yyyy-MM-dd
//	 * @author mawujun email:160649888@163.com qq:16064988
//	 * @param date
//	 * @return
//	 */
//	public static String format(Date date) {
//		if(date==null){
//			return null;
//		}
//		return yyyy_MM_dd.format(date);
//	}
//	
//
//	
//	
//	 //-----------------------------------------------------------------------
//    /**
//     * <p>Parses a string representing a date by trying a variety of different parsers.</p>
//     * 
//     * <p>The parse will try each parse pattern in turn.
//     * A parse is only deemed successful if it parses the whole of the input string.
//     * If no parse patterns match, a ParseException is thrown.</p>
//     * The parser will be lenient toward the parsed date.
//     * 
//     * @param str  the date to parse, not null
//     * @param parsePatterns  the date format patterns to use, see SimpleDateFormat, not null
//     * @return the parsed date
//     * @throws IllegalArgumentException if the date string or pattern array is null
//     * @throws ParseException if none of the date patterns were suitable (or there were none)
//     */
//    public static Date parseDate(String str, String... parsePatterns) throws ParseException {
//        return parseDateWithLeniency(str, parsePatterns, true);
//    }
//	
//	   /**
//     * <p>Parses a string representing a date by trying a variety of different parsers.</p>
//     * 
//     * <p>The parse will try each parse pattern in turn.
//     * A parse is only deemed successful if it parses the whole of the input string.
//     * If no parse patterns match, a ParseException is thrown.</p>
//     * 
//     * @param str  the date to parse, not null
//     * @param parsePatterns  the date format patterns to use, see SimpleDateFormat, not null
//     * @param lenient Specify whether or not date/time parsing is to be lenient.
//     * @return the parsed date
//     * @throws IllegalArgumentException if the date string or pattern array is null
//     * @throws ParseException if none of the date patterns were suitable
//     * @see java.util.Calender#isLenient()
//     */
//    private static Date parseDateWithLeniency(
//            String str, String[] parsePatterns, boolean lenient) throws ParseException {
//        if (str == null || parsePatterns == null) {
//            throw new IllegalArgumentException("Date and Patterns must not be null");
//        }
//        
//        SimpleDateFormat parser = new SimpleDateFormat();
//        parser.setLenient(lenient);
//        ParsePosition pos = new ParsePosition(0);
//        for (String parsePattern : parsePatterns) {
//
//            String pattern = parsePattern;
//
//            // LANG-530 - need to make sure 'ZZ' output doesn't get passed to SimpleDateFormat
//            if (parsePattern.endsWith("ZZ")) {
//                pattern = pattern.substring(0, pattern.length() - 1);
//            }
//            
//            parser.applyPattern(pattern);
//            pos.setIndex(0);
//
//            String str2 = str;
//            // LANG-530 - need to make sure 'ZZ' output doesn't hit SimpleDateFormat as it will ParseException
//            if (parsePattern.endsWith("ZZ")) {
//                str2 = str.replaceAll("([-+][0-9][0-9]):([0-9][0-9])$", "$1$2"); 
//            }
//
//            Date date = parser.parse(str2, pos);
//            if (date != null && pos.getIndex() == str2.length()) {
//                return date;
//            }
//        }
//        throw new ParseException("Unable to parse the date: " + str, -1);
//    }
    
    
	//private static IIIllllIIlIIIlII _$1 = new IIIllllIIlIIIlII();
    
    private static Logger logger = LoggerFactory.getLogger(DateUtils.class);
	/**
	 * yyyy-MM-dd
	 */
	public static final Integer DATE_SHORT = 0;
	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	public static final Integer DATE_TIME=1;
	static HashMap<Integer,SimpleDateFormat> _$1=new HashMap<Integer,SimpleDateFormat>();
	static {

		_$1.put(DATE_SHORT, new SimpleDateFormat("yyyy-MM-dd"));
		_$1.put(DATE_TIME, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
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
		return date == null ? " " : _$1.get(format).format(date);
	}

	public static String date2String(Date date, String format) {
		SimpleDateFormat var2 = new SimpleDateFormat(format);
		return var2.format(date);
	}


	/**
	 * 默认返回时间格式为yyyy-MM-dd HH:mm:ss
	 * @param var0
	 * @return
	 */
	public static String date2String(Date var0) {
		return _$1.get(DATE_TIME).format(var0);
	}

    
	public static long string2Long(String var0, int var1) {
		return date2Long(string2Date(var0, var1));
	}

	public static Date getDateNow() {
		Calendar var0 = Calendar.getInstance();
		return var0.getTime();
	}
	/**
	 * 默认返回时间格式为yyyy-MM-dd HH:mm:ss
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
		return _$1.get(format).format(var1.getTime());
	}

	public static long getLongNow() {
		return date2Long(getDateNow());
	}
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

			DateFormat var8 = _$1.get(var1);
			Date var3 = null;

			String var5;
			try {
				var3 = var8.parse(var0);
			} catch (ParseException var6) {
				var5 = "解析日期{" + var0 + "}格式{" + ((SimpleDateFormat) var8).toPattern() + "}异常!";
				if (logger.isDebugEnabled()) {
					logger.error(var5, var6);
				} else {
					logger.error(var5);
				}
			} catch (Exception var7) {
				var3 = Calendar.getInstance().getTime();
				var5 = "转换日期{" + var0 + "}为{" + ((SimpleDateFormat) var8).toPattern() + "}是格式时异常!";
				if (logger.isDebugEnabled()) {
					logger.error(var5, var7);
				} else {
					logger.error(var5);
				}
			}

			return var3;
		}
	}
	
	public static int compareDate(Date var0, int var1) {
		return compareDate(var0, Calendar.getInstance().getTime(), var1);
	}

	public static Date addDate(Date var0, int var1, int var2) {
		if (var1 < 0) {
			logger.warn("日期增减操作时不支持类型:" + var1);
			return var0;
		} else {
			Calendar var3 = Calendar.getInstance();
			var3.setTime(var0);
			var3.add(var1, var2);
			return var3.getTime();
		}
	}

	public static Date addTodayDate(int var0, int var1) {
		return addDate(getDateNow(), var0, var1);
	}

	/**
	 * 比较两个日期相差的时间
	 * @param var0
	 * @param var1
	 * @param var2 Calendar.MINUTE,Calendar。HOUR，Calendar。DAY_OF_MONTH等
	 * @return
	 */
	public static int compareDate(Date var0, Date var1, int var2) {
		double var3 = (double) (var1.getTime() - var0.getTime());
		if (var2 == Calendar.MINUTE) {
			var3 = fixDouble2(var3 / 60000.0D);
		} else if (var2 == Calendar.HOUR) {
			var3 = fixDouble2(var3 / 3600000.0D);
		} else if (var2 == Calendar.DAY_OF_MONTH) {
			var3 = fixDouble2(var3 / 8.64E7D);
		}

		return (int) var3;
	}
	private static DecimalFormat decimalFormat =new DecimalFormat("#.00");
	public static double fixDouble2(double var0) {
		return fixDouble(var0, 2);
	}

	public static double fixDouble(double var0, int var2) {
		if (var2 < 0) {
			var2 = 2;
		}

		DecimalFormat var3 = null;
		if (var2 == 2) {
			var3 = decimalFormat;
		} else {
			String var4 = String.valueOf((int) Math.pow(10.0D, (double) var2));
			var3 = new DecimalFormat(var2 == 0 ? "#" : "#." + var4.substring(1));
		}

		return Double.parseDouble(var3.format(var0));
	}
	
}
