package com.it.java8demo.ceshi;

import org.springframework.beans.BeanUtils;

/**
 * @CLassName TestDemo
 * @Description: TODO
 * @date: 2020/11/4 17:23
 * @Version 1.0
 */
public class TestDemo {
	public static void main(String[] args) {
//		Student student = new Student();
//		student.setName("00:00:00");
//		Student2 student2 = new Student2();
//		BeanUtils.copyProperties(student,student2);
//		System.out.println(student2);
//		String s=null;
//		if(s.contains(":")){
//			System.out.println(s);
//		}

		String hour="2020-08-09 12:32:23";
		String ssdd=hour.substring(11,13);
		System.out.println(ssdd);

	}
}
