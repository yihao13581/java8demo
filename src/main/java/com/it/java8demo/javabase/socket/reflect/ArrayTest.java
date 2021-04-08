package com.it.java8demo.javabase.socket.reflect;

import java.lang.reflect.Array;

/**
 * @CLassName ArrayTest
 * @Description: TODO
 * @date: 2020/12/31 17:31
 * @Version 1.0
 */
public class ArrayTest {
	public static void main(String[] args) {

		//arrayTest1();
		arrayTest2();
	}

	private static void arrayTest2() {
		/**
		 * 创建一个三维数组
		 * 根据前面介绍数组时讲的：三维数组也是一维数组，是数组元素，是二维数组的一维数组
		 * 因此可以认为arr是长度为3的一维数组
		 */
		Object arr=Array.newInstance(String.class,3,4,10);
		//获取arr数组中index为2的元素，该元素应该是二维数组
		Object arrObj=Array.get(arr,2);
		//使用Array为二维数组的数组元素赋值，二维数组的数组元素是一维数组
		//所有传入Array的set()方法的第三个参数是一维数组
		Array.set(arrObj,2,new String[]{"疯狂Java讲义","轻量级JavaEE企业应用实战"});
		//获取arrObj数组中index为3的元素，该元素应该是一维数组
		Object anArr=Array.get(arrObj,3);
		Array.set(anArr,8,"疯狂Android讲义");
		//将arr强制类型转换为三维数组
		String [] [] [] cast=(String[][][])arr;
		//获取cast三维数组中指定元素的值
		System.out.println(cast[2][3][8]);
		System.out.println(cast[2][2][0]);
		System.out.println(cast[2][2][1]);

	}

	private static void arrayTest1() {
		try {
			//创建一个元素类型为String，长度为10的数组
			Object arr= Array.newInstance(String.class,10);
			//依次为arr数组中的index为5、6的元素赋值
			Array.set(arr,5,"疯狂Java讲义");
			Array.set(arr,6,"疯狂Java EE企业应用实战");
			//依次取出arr数组中index为5，6的元素的值
			Object book1=Array.get(arr,5);
			Object book2=Array.get(arr,6);
			//输出arr数组中index为5，6的元素
			System.out.println(book1);
			System.out.println(book2);

		} catch (Throwable e) {
			System.err.println(e);
		}
	}
}
