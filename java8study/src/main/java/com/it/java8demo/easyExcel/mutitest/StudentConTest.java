package com.it.java8demo.easyExcel.mutitest;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.it.java8demo.easyExcel.Student;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @CLassName StudentConTest
 * @Description: TODO
 * @date: 2021/1/18 10:31
 * @Version 1.0
 */
public class StudentConTest {
	public static void main(String[] args) {
//		easy();
		List<Student> students = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Student student = new Student();
			student.setBirthday(new Date());
			student.setGender(i + "");
			student.setName("张三" + i);
			students.add(student);

		}
		String beginTime = "2020年12月1日";
		String endTime = "2020年12月1日";
		EasyExcel.write("d:\\深圳黑马学员表.xlsx", Student.class)
				.head(Student.class)
				//设置拦截器或自定义样式
				.registerWriteHandler(new StudentWriteHandler(beginTime, endTime))
				.sheet("IVR统计报表")
				//设置默认样式及写入头信息开始的行数
				.useDefaultStyle(true).relativeHeadRowIndex(1)
				.doWrite(students);
	}

	private static void easy() {
		List<Student> students = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Student student = new Student();
			student.setBirthday(new Date());
			student.setGender(i + "");
			student.setName("张三" + i);
			students.add(student);

		}
		ExcelWriterBuilder workBook = EasyExcel.write("d:\\深圳黑马学员表.xlsx", Student.class);
//		ExcelWriterBuilder workBook = EasyExcel.write(out, Student.class);
		// sheet方法参数： 工作表的顺序号（从0开始）或者工作表的名字
		workBook.sheet().doWrite(students);
	}
}
