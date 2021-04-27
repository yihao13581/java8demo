package com.cmos.isccmp.util;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @CLassName Java8DateUtil
 * @Description: TODO
 * @date: 2020/1/21 10:05
 * @Version 1.0
 */
public class Java8DateUtil {
	/**java8获取今天的日期*/
	public static String getTodayDate(){
		LocalDate today=LocalDate.now();
		System.out.println("今天的日期："+today);
		return today.toString();
	}
	/**java8获取年月日信息*/
	public  static String getTodayYearMonthDay(){
		LocalDate today=LocalDate.now();
		int year=today.getYear();
		int month=today.getMonthValue();
		int day=today.getDayOfMonth();
		String date=""+year+month+day;
		System.out.println(date);
		return  date;
	}
	/**java8处理特定日期*/
	public static String getCustomDate(int year,int month,int day){
		LocalDate date=LocalDate.of(year,month,day);
		System.out.println("自定义日期"+date);
		return date.toString();
	}

	/**java8中判断是否为当前日期*/
	public static void isEquals(){
		LocalDate date1=LocalDate.now();
		LocalDate date2=LocalDate.of(2020,1,21);
		if(date1.equals(date2)){
			System.out.println("时间为当前日期");
		}
		else{
			System.out.println("时间不为当前日期");
		}
	}
	/**java8检查生日这种周期性事件*/
	public static void isBirthday(){
		LocalDate date1=LocalDate.now();
		LocalDate date2=LocalDate.of(2019,1,21);
		MonthDay birthday=MonthDay.of(date2.getMonth(),date2.getDayOfMonth());
		MonthDay currentMonthDay=MonthDay.from(date1);
		System.out.println(currentMonthDay);
		if(currentMonthDay.equals(birthday)){
			System.out.println("是你的生日");
		}else{
			System.out.println("你的生日还没到");
		}
	}
	/**java8中获取当前时间修改时分秒*/
	public static void updateTime(){
		LocalTime time=LocalTime.now();
		LocalTime newTime=time.plusHours(3).plusMinutes(2).plusSeconds(5).minusHours(1);
		System.out.println("三个小时2分钟5秒后的时间为："+newTime);
	}
	/**计算一周后的日期*/
	public static void postPoneWeek(){
		LocalDate today=LocalDate.now();
		System.out.println("今天的日期为："+today);
		LocalDate nextWeek=today.plus(1, ChronoUnit.WEEKS);
		System.out.println("推迟一周后的日期为："+nextWeek);
	}

	/**
	 * 计算一年前或一年后的日期
	 */
	public static void postPoneYear(){
		LocalDate today=LocalDate.now();
		LocalDate prevoiusYear=today.minus(1,ChronoUnit.YEARS);
		System.out.println("一年前的日期："+prevoiusYear);

		LocalDate nextYear=today.minus(1,ChronoUnit.YEARS);
		System.out.println("一年后的日期："+prevoiusYear);
	}
	/**java8中的时钟类,用于获取当时的时间戳*/
	public static void getClock(){
		//根据系统时钟返回当前时间并将其设置为UTC
		Clock clock=Clock.systemUTC();
		System.out.println("clock:"+clock.millis());
		//根据系统时钟区域返回时间
		Clock defaultClock=Clock.systemDefaultZone();
		System.out.println("clock:"+defaultClock.millis());
	}

	/**java判断日期是早于还是晚于另一个日期
	 */
	public static void isBeforeOrAfter(){
		LocalDate today=LocalDate.now();
		LocalDate tomorrow=LocalDate.of(2020,1,21);
		if(tomorrow.isAfter(today)){
			System.out.println("之后的日期；"+tomorrow);
		}
		LocalDate yesterday=today.minus(1,ChronoUnit.DAYS);
		if(yesterday.isBefore(today)){
			System.out.println("之前的日期："+yesterday);
		}
	}
	/**java8处理时区*/
	public static void getTimeZone(){
		// Date and time with timezone in Java 8
		ZoneId america = ZoneId.of("America/New_York");
		LocalDateTime localtDateAndTime = LocalDateTime.now();
		ZonedDateTime dateAndTimeInNewYork  = ZonedDateTime.of(localtDateAndTime, america );
		System.out.println("Current date and time in a particular timezone : " + dateAndTimeInNewYork);
	}
	/**表示信用卡到期这类固定日期，答案就在YearMonth
	 * YearMonth是另一个组合类，用于表示信用卡到期日、FD到期日、期货期权到期日等。
	 * 还可以用这个类得到 当月共有多少天，YearMonth实例的lengthOfMonth()方法可以
	 * 返回当月的天数，在判断2月有28天还是29天时非常有用
	*/
	public static void isExpire(){
		YearMonth currentYearMonth = YearMonth.now();
		System.out.printf("Days in month year %s: %d%n", currentYearMonth, currentYearMonth.lengthOfMonth());
		YearMonth creditCardExpiry = YearMonth.of(2019, Month.FEBRUARY);
		System.out.printf("Your credit card expires on %s %n", creditCardExpiry);
	}
	/**java8中查询润年*/
	public static void isLeap(){
		LocalDate today = LocalDate.now();
		if(today.isLeapYear()){
			System.out.println("This year is Leap year");
		}else {
			System.out.println("2018 is not a Leap year");
		}
	}
	/**计算两个日期之间的天数或月数*/
	public static void getDays(){
		LocalDate today = LocalDate.now();

		LocalDate java8Release = LocalDate.of(2018, 12, 14);

		Period periodToNextJavaRelease = Period.between(today, java8Release);
		System.out.println("Months left between today and Java 8 release : "
				+ periodToNextJavaRelease.getMonths() );
	}
	/**java8获取当前的时间戳*/
	public static void getTimeStamp(){
		Instant timestamp = Instant.now();
		System.out.println("What is value of this instant " + timestamp.toEpochMilli());
	}
	/**java8使用预定义的格式化工具去解析或格式化日期*/
	public static void format(){
		String dayAfterTomorrow = "20180205";
		LocalDate formatted = LocalDate.parse(dayAfterTomorrow,
				DateTimeFormatter.BASIC_ISO_DATE);
		System.out.println(dayAfterTomorrow+"  格式化后的日期为:  "+formatted);
	}
	/**字符串互转日期类型*/
	public static void getConversion(){
		LocalDateTime date = LocalDateTime.now();

		DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		//日期转字符串
		String str = date.format(format1);

		System.out.println("日期转换为字符串:"+str);

		DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		//字符串转日期
		LocalDate date2 = LocalDate.parse(str,format2);
		System.out.println("日期类型:"+date2);
	}

	public static void main(String [] args){
		getTodayDate();
		getTodayYearMonthDay();
		getCustomDate(2020,1,21);
		isEquals();//8229.94
		isBirthday();
		updateTime();
		postPoneWeek();
		postPoneYear();
		getClock();
		isBeforeOrAfter();
		getTimeZone();
		isExpire();
		getConversion();
	}

}
