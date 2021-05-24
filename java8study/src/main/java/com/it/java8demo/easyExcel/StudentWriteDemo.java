package com.it.java8demo.easyExcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

import static java.util.Comparator.comparing;

/**
 * @CLassName StudentWriteDemo
 * @Description: TODO
 * @date: 2020/10/27 17:39
 * @Version 1.0
 */
public class StudentWriteDemo {
	public static void main(String[] args)throws Exception {
		List<Student> students = initData();
//		students.sort(comparing(Student::getName).reversed());
//		System.out.println(students);
		Function<Integer, Integer> f = x -> x + 1;
		Function<Integer, Integer> g = x -> x * 2;
		Function<Integer, Integer> h = f.compose(g);
		int result = h.apply(1);
		/*
            String pathName 写入文件的路径
            Class head      写入文件的对象类型
            默认写入到07的xlsx中，如果想要写入xls，可以指定类型（待验证）
         */
		ByteArrayOutputStream out=new ByteArrayOutputStream();

		ExcelWriterBuilder workBook = EasyExcel.write("d:\\杭州黑马学员表.xlsx", Student.class);
//		ExcelWriterBuilder workBook = EasyExcel.write(out, Student.class);
		// sheet方法参数： 工作表的顺序号（从0开始）或者工作表的名字
		workBook.sheet().doWrite(students);
		System.out.println(out.toString());
		InputStream inputStream=new ByteArrayInputStream(out.toByteArray());
		System.out.println(inputStream);
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
