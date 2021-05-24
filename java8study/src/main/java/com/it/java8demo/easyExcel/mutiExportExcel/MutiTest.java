//package com.it.java8demo.easyExcel.mutiExportExcel;
//
//import com.alibaba.excel.EasyExcel;
//import com.alibaba.excel.support.ExcelTypeEnum;
//import com.alibaba.excel.write.metadata.style.WriteCellStyle;
//import com.alibaba.excel.write.metadata.style.WriteFont;
//import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
//import org.apache.poi.ss.usermodel.BorderStyle;
//import org.apache.poi.ss.usermodel.HorizontalAlignment;
//import org.apache.poi.ss.usermodel.VerticalAlignment;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.net.URLEncoder;
//import java.util.List;
//
///**
// * @CLassName MutiTest
// * @Description: TODO
// * @date: 2021/1/18 11:12
// * @Version 1.0
// */
//@RestController
//public class MutiTest {
//	@postMapping("pilebodystatisticsmonthexport")
//	public WebApiResponse<List<PilebodycheckMonthDto>> pilebodystatisticsmonthexport (HttpServletResponse response, String month) throws IOException {
//		List<PilebodycheckMonthDto> pilebodysList = pilebodycheckService.pilebodystatisticsmonth(sysDepartDto, month);
//		//设置序号
//		for (int i = 1;i <= pilebodysList.size();i++){
//			pilebodysList.get(i-1).setOrderNum(i+"");
//		}
//		response.setContentType("application/vnd.ms-excel");
//		response.setCharacterEncoding("utf-8");
//		// 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
//		String fileName = URLEncoder.encode("存量建筑垃圾堆体治理进度月报表", "UTF-8");
//		response.setHeader("Content-disposition",  "attachment;filename=" + fileName + ".xls");
//		//内容样式策略
//		WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
//		//垂直居中,水平居中
//		contentWriteCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
//		contentWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.CENTER);
//		contentWriteCellStyle.setBorderLeft(BorderStyle.THIN);
//		contentWriteCellStyle.setBorderTop(BorderStyle.THIN);
//		contentWriteCellStyle.setBorderRight(BorderStyle.THIN);
//		contentWriteCellStyle.setBorderBottom(BorderStyle.THIN);
//		//设置 自动换行
//		contentWriteCellStyle.setWrapped(true);
//		// 字体策略
//		WriteFont contentWriteFont = new WriteFont();
//		// 字体大小
//		contentWriteFont.setFontHeightInPoints((short) 12);
//		contentWriteCellStyle.setWriteFont(contentWriteFont);
//		//头策略使用默认
//		WriteCellStyle headWriteCellStyle = new WriteCellStyle();
//
//		//excel如需下载到本地,只需要将response.getOutputStream()换成File即可(注释掉以上response代码)
//		EasyExcel.write(response.getOutputStream(), PilebodycheckMonthDto.class)
//				//设置输出excel版本,不设置默认为xlsx
//				.excelType(ExcelTypeEnum.XLS).head(PilebodycheckMonthDto.class)
//				//设置拦截器或自定义样式
//				.registerWriteHandler(new MonthSheetWriteHandler())
//				.registerWriteHandler(new HorizontalCellStyleStrategy(headWriteCellStyle,contentWriteCellStyle))
//				.sheet("存量建筑垃圾堆体治理进度月报表")
//				//设置默认样式及写入头信息开始的行数
//				.useDefaultStyle(true).relativeHeadRowIndex(3)
//				//这里的addsumColomn方法是个添加合计的方法,可删除
//				.doWrite(pilebodycheckService.addSumColomn(pilebodysList));
//		return new WebApiResponse(200, "生成excel文件成功", null);
//
//	}
//}
