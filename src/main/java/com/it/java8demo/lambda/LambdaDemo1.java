package com.it.java8demo.lambda;

import com.it.java8demo.easyExcel.Student;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

/**
 * @CLassName LambdaDemo1
 * @Description: TODO
 * @date: 2020/10/28 16:09
 * @Version 1.0
 */
public class LambdaDemo1 {
	public static void main(String[] args) {
		List<Student> students = initData();
//		students.sort(comparing(Student::getName).reversed());
//		System.out.println(students);
		Function<Integer, Integer> f = x -> x + 1;
		Function<Integer, Integer> g = x -> x * 2;
		Function<Integer, Integer> h = f.compose(g);
		int result = h.apply(1);
	}




	private static List<Student> initData() {
		ArrayList<Student> students = new ArrayList<Student>();

		for (int i = 0; i < 10; i++) {
			Student data = new Student();
			data.setName("杭州黑马学号0" + i);
			data.setBirthday(new Date());
			data.setGender("男");
			students.add(data);
		}
		return students;
	}
}
