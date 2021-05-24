package com.it.java8demo.javabase.OftenUserClass;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @CLassName FormatDemo
 * @Description: TODO
 * @date: 2020/12/14 17:48
 * @Version 1.0
 */
public class FormatDemo {
	/**
	 * NumberFormat和DateFormat都包含了Format（）和parse（）方法，其中format（）方法用于将数值、日期格式化
	 * 成字符串，parse（）用于将字符串解析成数值、日期。
	 */
	public static void main(String[] args)throws Exception {
		formatDemo();
//		//定义一个任意格式的日期、时间字符串
//		String str1="2014==04==12 01时06分09秒";
//		//根据需要解析的日期、时间字符串定义解析所用的格式器
//		DateTimeFormatter formatter1=DateTimeFormatter.ofPattern("yyyy==MM==dd HH时mm分ss秒");
//		LocalDateTime dt1=LocalDateTime.parse(str1,formatter1);
//		System.out.println(dt1);
	}

	private static void formatDemo()throws Exception {
		Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2005-06-09 12:23:23");

		String now = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(date);

		System.out.println(now);

	}
}
