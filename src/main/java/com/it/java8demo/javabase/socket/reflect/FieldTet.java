package com.it.java8demo.javabase.socket.reflect;

import java.lang.reflect.Field;

/**
 * @CLassName FieldTet
 * @Description: TODO
 * @date: 2020/12/31 15:10
 * @Version 1.0
 */
public class FieldTet {
	public static void main(String[] args) throws Exception{
		//创建一个Person对象
		Person p=new Person();
		//获取Person类对应的Class对象
		Class<Person> personClazz=Person.class;
		//获取person的名为name的成员变量
		//使用getDeclaredField()方法表明可获取各种访问控制符的成员变量
		Field nameField=personClazz.getDeclaredField("name");
		//设置通过反射访问该成员变量时取消访问权限检查
		nameField.setAccessible(true);
		nameField.set(p,"Yeeku.H.Lee");
		//获取Person类名为age的成员变量
		Field ageField=personClazz.getDeclaredField("age");
		//设置通过反射访问该成员变量时取消访问权限检查
		ageField.setAccessible(true);
		//调用setInt()方法为P对象的age成员变量设置值
		ageField.setInt(p,30);
		System.out.println(p);
	}
}

class Person{
	private String name;
	private int age;
	@Override
	public String toString()
	{
		return "Person[name:"+name+",age:"+age+"]";
	}
}
