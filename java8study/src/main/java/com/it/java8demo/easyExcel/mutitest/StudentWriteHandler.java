package com.it.java8demo.easyExcel.mutitest;

/**
 * @CLassName MonthSheetWriteHandler
 * @Description: TODO
 * @date: 2021/1/18 11:13
 * @Version 1.0
 */
import com.alibaba.excel.write.handler.SheetWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteWorkbookHolder;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

public class StudentWriteHandler implements SheetWriteHandler {
	private String beginTime;
	private String endTime;

	public  StudentWriteHandler(){}

	public  StudentWriteHandler(String beginTime,String endTime){
		this.beginTime=beginTime;
		this.endTime=endTime;
	}
	@Override
	public void beforeSheetCreate(WriteWorkbookHolder writeWorkbookHolder, WriteSheetHolder writeSheetHolder) {

	}

	@Override
	public void afterSheetCreate(WriteWorkbookHolder writeWorkbookHolder, WriteSheetHolder writeSheetHolder) {
		Workbook workbook = writeWorkbookHolder.getWorkbook();
		Sheet sheet = workbook.getSheetAt(0);
		//设置标题
		Row row = sheet.createRow(0);
		row.setHeight((short) 800);
		Cell cell = row.createCell(0);

		cell.setCellValue("IVR统计报表\n"+"统计时间："+beginTime+"-"+endTime);

		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setAlignment(HorizontalAlignment.LEFT);
		Font font = workbook.createFont();
		font.setBold(true);
		font.setFontHeight((short) 300);
		cellStyle.setFont(font);
		cellStyle.setWrapText(true);
		cell.setCellStyle(cellStyle);
		sheet.addMergedRegionUnsafe(new CellRangeAddress(0, 0, 0, 7));
	}

}