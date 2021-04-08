package com.it.java8demo.newDateApi;

import java.time.*;
import java.time.temporal.Temporal;

/**
 * @CLassName LocalDate
 * @Description: TODO
 * @date: 2020/11/26 14:17
 * @Version 1.0
 */
public class NewLocalDate {
	public static void main(String[] args) {
		localDateDemo();

		localTimeDemo();

		localDateTime();



	}

	private static void localDateTime() {
		LocalDateTime dt1 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45, 20);
		LocalDate date=LocalDate.of(2020,11,26);
		LocalTime time=LocalTime.of(13,23,12);
		LocalDateTime dt2 = LocalDateTime.of(date, time);
		LocalDateTime dt3 = date.atTime(13, 45, 20);
		LocalDateTime dt4 = date.atTime(time);
		LocalDateTime dt5 = time.atDate(date);
		System.out.println(dt1);
		System.out.println(dt2);
		System.out.println(dt3);
		System.out.println(dt4);
		System.out.println(dt5);
	}

	private static void localTimeDemo() {
		LocalTime time=LocalTime.of(13,45,20);
		int hour =time.getHour();
		int minute=time.getMinute();
		int second=time.getSecond();

		LocalDate date=LocalDate.parse("2020-11-26");
		LocalTime time1=LocalTime.parse("13:25:25");
		System.out.println(time);
		System.out.println(hour);
		System.out.println(minute);
		System.out.println(second);
		System.out.println(date);
		System.out.println(time1);
	}

	private static void localDateDemo() {
		LocalDate date=LocalDate.of(2020,11,26);
		int year=date.getYear();
		Month month=date.getMonth();
		int day=date.getDayOfMonth();
		DayOfWeek dow=date.getDayOfWeek();
		int len=date.lengthOfMonth();
		LocalDate today=LocalDate.now();
		System.out.println(year);
		System.out.println(month);
		System.out.println(day);
		System.out.println(dow);
		System.out.println(len);
		System.out.println(today);
	}
}
