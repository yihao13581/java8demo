package com.haotian.haotianpoi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @CLassName ExcelWriteTest
 * @Description: TODO
 * @date: 2021/1/15 16:47
 * @Version 1.0
 */
public class ExcelWriteTest {

	String PATH = "D:\\study\\haotian-poi";

	@Test
	public void testWrite03() throws Exception {
		//1、创建一个工作簿
		Workbook workbook = new HSSFWorkbook();
		//2、创建一个工作表
		Sheet sheet = workbook.createSheet("狂神观众统计表");
		//3、创建一行
		Row row1 = sheet.createRow(0);
		//4、创建一个单元格
		Cell cell1 = row1.createCell(0);
		cell1.setCellValue("今日新增观众");
		//（1，2）
		Cell cell2 = row1.createCell(1);
		cell2.setCellValue("666");

		//第二行（2，1）
		Row row2 = sheet.createRow(1);
		Cell cell21 = row2.createCell(0);
		cell21.setCellValue("统计时间");
		//（2，2）
		Cell cell22 = row2.createCell(1);
		String time = new DateTime().toString("yyyy-MM-dd HH:mm:ss");
		cell22.setCellValue(time);

		//生成一张表（IO流） 03版本就是使用xls结尾
		FileOutputStream fileOutputStream = new FileOutputStream(PATH + "狂神观众统计表03.xls");
		workbook.write(fileOutputStream);
		//关闭流
		fileOutputStream.close();
		System.out.println("Excel生成完毕");
	}

	@Test
	public void testWrite07() throws Exception {
		//1、创建一个工作簿
		Workbook workbook = new XSSFWorkbook();
		//2、创建一个工作表
		Sheet sheet = workbook.createSheet("狂神观众统计表");
		//3、创建一行
		Row row1 = sheet.createRow(0);
		//4、创建一个单元格
		Cell cell1 = row1.createCell(0);
		cell1.setCellValue("今日新增观众");
		//（1，2）
		Cell cell2 = row1.createCell(1);
		cell2.setCellValue("666");

		//第二行（2，1）
		Row row2 = sheet.createRow(1);
		Cell cell21 = row2.createCell(0);
		cell21.setCellValue("统计时间");
		//（2，2）
		Cell cell22 = row2.createCell(1);
		String time = new DateTime().toString("yyyy-MM-dd HH:mm:ss");
		cell22.setCellValue(time);

		//生成一张表（IO流） 03版本就是使用xlsx结尾
		FileOutputStream fileOutputStream = new FileOutputStream(PATH + "狂神观众统计表07.xlsx");
		workbook.write(fileOutputStream);
		//关闭流
		fileOutputStream.close();
		System.out.println("Excel生成完毕");
	}

	//大数据写数据
	@Test
	public void testWrite03BigData()throws Exception{
		//时间
		long begin=System.currentTimeMillis();
		//创建一个簿
		Workbook workbook=new HSSFWorkbook();
		//创建表
		Sheet sheet=workbook.createSheet();
		//写入数据
		for(int rowNum=0;rowNum<65536;rowNum++){
			Row row=sheet.createRow(rowNum);
			for(int cellNum=0;cellNum<10;cellNum++){
				Cell cell=row.createCell(cellNum);
				cell.setCellValue(cellNum);
			}
		}
		System.out.println("over");
		FileOutputStream fileOutputStream = new FileOutputStream(PATH+"testWrite03BigData.xls");
		workbook.write(fileOutputStream);
		fileOutputStream.close();
		long end=System.currentTimeMillis();
		System.out.println((double)(end-begin)/1000);
	}

	//耗时较长，比较慢
	@Test
	public void testWrite07BigData()throws Exception{
		//时间
		long begin=System.currentTimeMillis();
		//创建一个簿
		Workbook workbook=new XSSFWorkbook();
		//创建表
		Sheet sheet=workbook.createSheet();
		//写入数据
		for(int rowNum=0;rowNum<100000;rowNum++){
			Row row=sheet.createRow(rowNum);
			for(int cellNum=0;cellNum<10;cellNum++){
				Cell cell=row.createCell(cellNum);
				cell.setCellValue(cellNum);
			}
		}
		System.out.println("over");
		FileOutputStream fileOutputStream = new FileOutputStream(PATH+"testWrite03BigData.xlsx");
		workbook.write(fileOutputStream);
		fileOutputStream.close();
		long end=System.currentTimeMillis();
		System.out.println((double)(end-begin)/1000);
	}

	//优化，使用SXSSFWorkbook对象，会生成临时文件。100条数据后就会生成临时文件
	@Test
	public void testWrite07BigDataImprove()throws Exception{
		//时间
		long begin=System.currentTimeMillis();
		//创建一个簿
		Workbook workbook=new SXSSFWorkbook();
		//创建表
		Sheet sheet=workbook.createSheet();
		//写入数据
		for(int rowNum=0;rowNum<100000;rowNum++){
			Row row=sheet.createRow(rowNum);
			for(int cellNum=0;cellNum<10;cellNum++){
				Cell cell=row.createCell(cellNum);
				cell.setCellValue(cellNum);
			}
		}
		System.out.println("over");
		FileOutputStream fileOutputStream = new FileOutputStream(PATH+"testWrite07BigDataImprove.xlsx");
		workbook.write(fileOutputStream);
		fileOutputStream.close();
		//清除临时文件
		((SXSSFWorkbook)workbook).dispose();
		long end=System.currentTimeMillis();
		System.out.println((double)(end-begin)/1000);
	}
}
