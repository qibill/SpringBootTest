package com.qibill.common.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description: 时间的工具类
 * @author: qibill
 * @date: 2018/11/12 11:22
 **/
public class DateUtil {

	public static final String DAY = "yyyy-MM-dd";
	public static final String HOUR = "yyyy-MM-dd HH";
	public static final String MINUTE = "yyyy-MM-dd HH:mm";
	public static final String SECOND = "yyyy-MM-dd HH:mm:ss";

	//公用事业类不应该有公共构造函数
	private DateUtil() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 *  验证一个字符串是否为合法的日期格式
	 * @param date
	 * @param format
	 * @return
	 */
	public static boolean isValidDate(String date, String format) {
		// 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		// 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
		simpleDateFormat.setLenient(false);
		try {
			simpleDateFormat.parse(date);
		} catch (ParseException e) {
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			return false;
		}
		return true;
	}

	/**
	 * 验证一个字符串是否为合法的,精确到分的日期格式
	 * @param date
	 * @return
	 */
	public static boolean isValidMinuteDate(String date){
		return isValidDate(date, MINUTE);
	}

	/**
	 * 测试方法
	 * @param args
	 */
	public static void main(String[] args){
		System.out.println(isValidMinuteDate("1992/10/30 10:50"));
	}

	public static Date strToDate(String strDate){
		if (strDate == null || "".equals(strDate)){
			return null;
		}
		SimpleDateFormat formatter;
		if(strDate.contains(":")){
			formatter = new SimpleDateFormat(MINUTE);
		}else {
			formatter = new SimpleDateFormat(DAY);
		}
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}

	public static Timestamp strToTimestamp(String strDate){
		Date strtodate = strToDate(strDate);
		return new Timestamp(strtodate.getTime());
	}
}
