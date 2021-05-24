package com.it.java8demo.easyExcel;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Data;

import java.util.Date;

/**
 * @CLassName Student
 * @Description: TODO
 * @date: 2020/10/27 17:33
 * @Version 1.0
 */
@Data
public class Student {
	/**
	 * 学生姓名
	 */
	@ExcelProperty(value = "学生姓名",index=0)
	@ColumnWidth(30)
	private String name;
	/**
	 * 学生性别
	 */
	@ExcelProperty(value = "学生性别",index=1)
	@ColumnWidth(20)
	private String gender;

	/**
	 * 学生出生日期
	 */
	@ExcelProperty(value = "学生出生日期",index=2)
	@ColumnWidth(40)
	private Date birthday;
	/**
	 * id
	 */
	@ExcelIgnore
	private String id;
}
