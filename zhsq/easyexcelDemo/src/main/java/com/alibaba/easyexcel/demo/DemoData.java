package com.alibaba.easyexcel.demo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;

import java.util.Date;

/**
 * @CLassName DemoData
 * @Description: TODO
 * @date: 2020/10/23 18:37
 * @Version 1.0
 */
//@Data
public class DemoData {

	@ExcelProperty("字符串标题")

	private String string;

	@ExcelProperty("日期标题")

	private Date date;

	@ExcelProperty("数字标题")

	private Double doubleData;

	/**

	 * 忽略这个字段

	 */

	@ExcelIgnore
	private String ignore;

}
