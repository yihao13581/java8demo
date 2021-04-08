package com.it.java8demo.javabase.OftenUserClass;

import java.util.Objects;

/**
 * @CLassName ObjectsDemo
 * @Description: TODO
 * @date: 2020/12/11 15:15
 * @Version 1.0
 */
public class ObjectsDemo {
	/**
	 * Java7新增了一个Objects工具类，它提供了一些工具方法来操作对象，这些方法大多时“空指针”安全的。
	 */
	//定义一个obj变量，它的默认值是null
	static ObjectsDemo obj;
	public static void main(String[] args) {
		//输出一个null对象的hashCode值，输出0
		System.out.println(Objects.hashCode(obj));
		//输出一个null对象的toString，输出null
		System.out.println(Objects.toString(obj));
		//要求Obj不能为null,如果为null则引发异常
		System.out.println(Objects.requireNonNull(obj,"obj参数不能是null"));

	}
}
