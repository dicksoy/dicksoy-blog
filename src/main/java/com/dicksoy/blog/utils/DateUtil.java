package com.dicksoy.blog.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	private static SimpleDateFormat SIMPLE_DATE_FORMAT;
	
	public static void main(String[] args) {
		System.out.println(dateCalculate(new Date(), 1, 1, 1));
		System.out.println(dateFormat(new Date(), "yyyyMMdd"));
	}

	/**
	 * 日期计算工具类
	 * @param date 指定日期
	 * @param year 需要增(+)减(-)的年
	 * @param month 需要增(+)减(-)的月
	 * @param day 需要增(+)减(-)的日
	 * @return
	 */
	public static Date dateCalculate(Date date, int year, int month, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, year);
		calendar.add(Calendar.MONTH, month);
		calendar.add(Calendar.DAY_OF_YEAR, day);
		Date newDate = calendar.getTime();
		return newDate;
	}
	
	/**
	 * 格式化日期
	 * @param date 指定日期
	 * @param pattern 定义格式
	 * @return
	 */
	public static String dateFormat(Date date, String pattern) {
		SIMPLE_DATE_FORMAT = new SimpleDateFormat(pattern);
		return SIMPLE_DATE_FORMAT.format(date);
	}
}
