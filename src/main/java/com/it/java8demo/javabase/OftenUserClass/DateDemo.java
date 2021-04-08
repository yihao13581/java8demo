package com.it.java8demo.javabase.OftenUserClass;

import java.util.Calendar;
import java.util.Date;

/**
 * @CLassName DateDemo
 * @Description: java8的日期、时间类
 * @date: 2020/12/14 10:28
 * @Version 1.0
 */
public class DateDemo {
	public static void main(String[] args) {
		datedemo();
		calendarDemo();
	}

	/**
	 *      Calendar类可以更好的处理日期和时间，是一个抽象类，用于表示日历
	 * Calendar抽象类不能使用构造器来创建Calendar对象，但提供了几个静态getInstance()方法来获取Calendar对象
	 *  	Calendar类提供了大量访问】修改日期时间的方法
	 *    void add(int field,int amount):为给定的日历字段添加或减去指定的时间量
	 *    int get(int field):返回指定日历字段的值
	 *    int getActualMaximum(int field): 返回指定日历字段可能拥有的最大值，例如月， 最小值为0
	 *    int getActualMinimum(int field):
	 *    void roll(int field,ing amount): 当被修改的字段超出它允许的范围时，不会发生进位，即上一级的字段不会增大
	 *    void set(int field,int value):将给定的日历字段设置为给定值
	 *    void set(int year,int month,int date):为Calendar对象设置年月日
	 *    void set(int year,int month,int date,int hourOFDay,int minute,int second)
	 *
	 *    注意点：月份的起始值是0，而不是1.设置8月份时，用7而不是8。
	 *    		 Calendar有两种解释日历字段模式：lenient模式(容错模式。允许每个时间字段超过允许值，会自动进行进位处理)和non-lenient模式。calendar.setLenient(true)默认
	 *    		 set(f,value)方法延迟修改，尽管日历字段f是立即修改的，但calendar所代表的时间却不会立即修改，直到下次调用
	 *  get()、getTime()、getTimeInMillis()、add()或者roll()时才会重新计算日历时间
	 */
	private static void calendarDemo() {
//		//创建一个默认的Calendar对象
//		Calendar calendar=Calendar.getInstance();
//		//从Calendar对象中取出Date对象
//		Date date=calendar.getTime();
//
//		//根据Date都西昂获取对应的Calendar对象
//		Calendar calendar1=Calendar.getInstance();
//		calendar1.setTime(date);


		Calendar c=Calendar.getInstance();
		//取出年
		System.out.println(c.get(Calendar.YEAR));
		//取出月份
		System.out.println(c.get(Calendar.MONTH));
		//取出日
		System.out.println(c.get(Calendar.DATE));
		//分别设置年、月、日、时、分、秒
		c.set(2020,11,14,11,02,21);
		System.out.println(c.getTime());
		c.add(Calendar.YEAR,-1);
		System.out.println(c.getTime());

	}

	/**
	 * Date类：提供有6个构造器，其中4个已经Deprecated,剩下的两个构造器如下：
	 *       Date():生成一个代表当前日期时间的Date对象。该构造器在底层调用System.currentTimeMillis()获取long
	 *       整数作为日期参数
	 *       Date（long date）:根据指定的long型整数来生成一个Date对象。该参数表示自GMT1970年1月1日00：00；00之间的时间差，以毫秒为单位
	 *  其它方法：
	 *  	boolean after(Date when):测试日期是否在指定日期之后
	 *     	boolean before(Date when):测试日期是否在指定日期之前
	 *     	long getTime();返回该时间对应的long型整数
	 */
	private static void datedemo() {
		Date d1=new Date();
		Date d2=new Date(System.currentTimeMillis()+100);
		System.out.println(d2);
		System.out.println(d1.compareTo(d2));
		System.out.println(d1.before(d2));
	}
}
