package com.haotian.haotianpoi;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;

/**
 * @CLassName ExcelWriteTest
 * @Description: TODO
 * @date: 2021/1/15 16:47
 * @Version 1.0
 */
public class ExcelReadTest {

	String PATH = "D:\\study\\";

	@Test
	public void testWrite03() throws Exception {
		//获取文件流
		FileInputStream fileInputStream = new FileInputStream(PATH + "haotian-poi狂神观众统计表03.xls");
		//1、创建一个工作簿,使用Excel能操作的这边他都能操作！
		Workbook workbook = new HSSFWorkbook(fileInputStream);
		//2、得到表
		Sheet sheet = workbook.getSheetAt(0);
		//3、得到行
		Row row = sheet.getRow(0);
		//4、得到列
		Cell cell1 = row.getCell(0);
		//读取值的时候，一定要注意类型
		//getStringCellValue() 字符串类型
		//getNumericCellValue() 字符串类型
		System.out.println(cell1.getStringCellValue());
		fileInputStream.close();
	}

	@Test
	public void testCellType() throws Exception {
		//获取文件流
		FileInputStream fileInputStream = new FileInputStream(PATH + "haotian-poi狂神观众统计表03.xls");
		//1、创建一个工作簿,使用Excel能操作的这边他都能操作！
		Workbook workbook = new HSSFWorkbook(fileInputStream);
		//2、得到表
		Sheet sheet = workbook.getSheetAt(0);
		//获取标题内容
		Row rowTitle = sheet.getRow(0);
		if (rowTitle != null) {
			//一定要掌握
			int cellCount = rowTitle.getPhysicalNumberOfCells();
			for (int cellNum = 0; cellNum < cellCount; cellNum++) {
				Cell cell = rowTitle.getCell(cellNum);
				if (cell != null) {
					int cellType = cell.getCellType();
					String cellValue = cell.getStringCellValue();
					System.out.println(cellValue + "|");
				}
			}
		}

		//获取表中的内容
		int rowCount = sheet.getPhysicalNumberOfRows();
		for (int rowNum = 1; rowNum < rowCount; rowNum++) {
			Row rowDate = sheet.getRow(rowNum);
			if (rowDate != null) {
				//读取列
				int cellCount = rowTitle.getPhysicalNumberOfCells();
				for (int cellNum = 0; cellNum < cellCount; cellNum++) {
					System.out.println("[" + (rowNum + 1) + "_" + (cellNum + 1) + "]");

					Cell cell = rowDate.getCell(cellNum);
					//匹配列的数据类型
					if (cell != null) {
						int cellType = cell.getCellType();
						String cellValue = "";
						switch (cellType) {
							case HSSFCell.CELL_TYPE_STRING://字符串
								System.out.println("[String]");
								cellValue = cell.getStringCellValue();
								break;
							case HSSFCell.CELL_TYPE_BOOLEAN://布尔
								System.out.println("[boolean]");
								cellValue = String.valueOf(cell.getBooleanCellValue());
								break;
							case HSSFCell.CELL_TYPE_BLANK://空
								System.out.println("[blank]");
								break;
							case HSSFCell.CELL_TYPE_NUMERIC://数字（日期、普通数字）
								System.out.println("[NUMERIC]");
								if(HSSFDateUtil.isCellDateFormatted(cell)){//日期
									System.out.println("[日期]");
									Date date=cell.getDateCellValue();
									cellValue=new DateTime(date).toString();
								}else{
									//不是日期格式，防止数字过长
									System.out.println("[转换为字符串输出]");
									cell.setCellType(HSSFCell.CELL_TYPE_STRING);
									cellValue=cell.toString();
								}
								break;
							case HSSFCell.CELL_TYPE_ERROR://错误
								System.out.println("[数据类型错误]");
								break;
						}
						System.out.println(cellValue);

					}

				}
			}

		}
		fileInputStream.close();
	}


	public void testCellType(FileInputStream fileInputStream) throws Exception {
		//获取文件流
//		FileInputStream fileInputStream = new FileInputStream(PATH + "haotian-poi狂神观众统计表03.xls");
		//1、创建一个工作簿,使用Excel能操作的这边他都能操作！
		Workbook workbook = new HSSFWorkbook(fileInputStream);
		//2、得到表
		Sheet sheet = workbook.getSheetAt(0);
		//获取标题内容
		Row rowTitle = sheet.getRow(0);
		if (rowTitle != null) {
			//一定要掌握
			int cellCount = rowTitle.getPhysicalNumberOfCells();
			for (int cellNum = 0; cellNum < cellCount; cellNum++) {
				Cell cell = rowTitle.getCell(cellNum);
				if (cell != null) {
					int cellType = cell.getCellType();
					String cellValue = cell.getStringCellValue();
					System.out.println(cellValue + "|");
				}
			}
		}

		//获取表中的内容
		int rowCount = sheet.getPhysicalNumberOfRows();
		for (int rowNum = 1; rowNum < rowCount; rowNum++) {
			Row rowDate = sheet.getRow(rowNum);
			if (rowDate != null) {
				//读取列
				int cellCount = rowTitle.getPhysicalNumberOfCells();
				for (int cellNum = 0; cellNum < cellCount; cellNum++) {
					System.out.println("[" + (rowNum + 1) + "_" + (cellNum + 1) + "]");

					Cell cell = rowDate.getCell(cellNum);
					//匹配列的数据类型
					if (cell != null) {
						int cellType = cell.getCellType();
						String cellValue = "";
						switch (cellType) {
							case HSSFCell.CELL_TYPE_STRING://字符串
								System.out.println("[String]");
								cellValue = cell.getStringCellValue();
								break;
							case HSSFCell.CELL_TYPE_BOOLEAN://布尔
								System.out.println("[boolean]");
								cellValue = String.valueOf(cell.getBooleanCellValue());
								break;
							case HSSFCell.CELL_TYPE_BLANK://空
								System.out.println("[blank]");
								break;
							case HSSFCell.CELL_TYPE_NUMERIC://数字（日期、普通数字）
								System.out.println("[NUMERIC]");
								if(HSSFDateUtil.isCellDateFormatted(cell)){//日期
									System.out.println("[日期]");
									Date date=cell.getDateCellValue();
									cellValue=new DateTime(date).toString();
								}else{
									//不是日期格式，防止数字过长
									System.out.println("[转换为字符串输出]");
									cell.setCellType(HSSFCell.CELL_TYPE_STRING);
									cellValue=cell.toString();
								}
								break;
							case HSSFCell.CELL_TYPE_ERROR://错误
								System.out.println("[数据类型错误]");
								break;
						}
						System.out.println(cellValue);

					}

				}
			}

		}
		fileInputStream.close();
	}

	@Test
	public void testFormula() throws Exception{
		FileInputStream inputStream=new FileInputStream(PATH+"公式.xls");
		Workbook workbook=new HSSFWorkbook(inputStream);
		Sheet sheet=workbook.getSheetAt(0);

		Row row=sheet.getRow(4);
		Cell cell=row.getCell(0);

		//拿道计算公式 eval
		FormulaEvaluator formulaEvaluator=new HSSFFormulaEvaluator((HSSFWorkbook)workbook);

		//输出单元格的内容
		int cellType=cell.getCellType();
		switch (cellType){
			case Cell.CELL_TYPE_FORMULA://公式
				String formula=cell.getCellFormula();
				System.out.println(formula);

				//计算
				CellValue evaluate=formulaEvaluator.evaluate(cell);
				String cellValue=evaluate.formatAsString();
				System.out.println(cellValue);
				break;
		}
	}
}
