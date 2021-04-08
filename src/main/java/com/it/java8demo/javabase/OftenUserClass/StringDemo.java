package com.it.java8demo.javabase.OftenUserClass;

/**
 * @CLassName StringDemo
 * @Description: TODO
 * @date: 2020/12/11 15:41
 * @Version 1.0
 */
public class StringDemo {

	/**
	 * String类是不可变类，一个String对象一但被创建，包含在该对象中的字符序列是不可改变的直到该对象被销毁
	 *
	 * StringBuffer:字符序列可变的字符串，当一个StringBuffer提供append()、insert()、reverse()、setCharAt()、
	 * setLength()等方法将其转换为一个String对象。线程安全的
	 *
	 *
	 *
	 */
	public static void main(String[] args) {
//		stringTest();
		StringBuilder sb=new StringBuilder();
		sb.append("java");
		System.out.println(sb);
		sb.insert(0,"hello");
		System.out.println(sb);
		sb.replace(5,6,",");
		System.out.println(sb);
		sb.delete(5,6);
		System.out.println(sb);
		sb.reverse();
		System.out.println(sb);
		System.out.println(sb.length());
		System.out.println(sb.capacity());//表示StringBuilder类的容量

	}

	private static void stringTest() {
		String s1=new String("abcdefghijklmn");
		String s2=new String("abcdefghijk");
		String s3=new String("abcdefghijalmn");
		System.out.println("s1.compareTo(s2):"+s1.compareTo(s2));//返回长度差
		System.out.println("s1.compareTo(s3):"+s1.compareTo(s3));//返回‘k’-'a'的差
	}
}
