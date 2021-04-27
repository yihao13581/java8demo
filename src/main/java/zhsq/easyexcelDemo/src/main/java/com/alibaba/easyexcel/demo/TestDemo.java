package com.alibaba.easyexcel.demo;

import com.alibaba.excel.EasyExcel;

/**
 * @CLassName TestDemo
 * @Description: TODO
 * @date: 2020/10/23 18:39
 * @Version 1.0
 */
public class TestDemo {
	@Test
	public void simpleWrite() {

		// 写法1

		String fileName = TestFileUtil.getPath() + "simpleWrite" + System.currentTimeMillis() + ".xlsx";

		// 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭

		// 如果这里想使用03 则 传入excelType参数即可

		EasyExcel.write(fileName, DemoData.class).sheet("模板").doWrite(data());
}
