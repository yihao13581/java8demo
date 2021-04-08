package com.it.java8demo.easyExcel.mutiExportExcel;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.alibaba.excel.util.StringUtils;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @CLassName PilebodycheckMonthDto
 * @Description: TODO
 * @date: 2021/1/18 11:06
 * @Version 1.0
 */
	@Data
	@NoArgsConstructor
	@Accessors(chain = true)
	@ContentRowHeight(45)
	@HeadRowHeight(50)
	public class PilebodycheckMonthDto {

		@ExcelIgnore
		private String id;

		@ExcelIgnore
		private String cityid;

		@ExcelIgnore
		private String districtid;

		@ExcelProperty(value = {"序号","序号"},index = 0)
		@ColumnWidth(10)
		private String orderNum;

		@ExcelProperty(value = {"堆体名称","堆体名称"},index = 1)
		@ColumnWidth(15)
		private String name;

		@ExcelProperty(value = {"具体位置","具体位置"},index = 3)
		@ColumnWidth(30)
		private String address;

		@ExcelProperty(value = {"占地面积（平方）","占地面积（平方）"},index = 4)
		@ColumnWidth(15)
		private String areastr;

		@ExcelProperty(value = {"堆体高度（米）","堆体高度（米）"},index = 5)
		@ColumnWidth(10)
		private String heightstr;

		@ExcelProperty(value = {"建筑垃圾堆存量（万方）","建筑垃圾堆存量（万方）"},index = 6)
		@ColumnWidth(15)
		private String stocknum;

		@ExcelIgnore
//		@Dict(dicCode = "governway")
		private String governway;

		@ExcelProperty(value = {"治理方式","治理方式"},index = 7)
		@ColumnWidth(20)
		private String governwayname;

		@ExcelProperty(value = {"如需外运，计划外运时间","如需外运，计划外运时间"},index = 8)
		@ColumnWidth(15)
		private String outwardtransporttime;

		@ExcelProperty(value = {"截止目前累计治理量（万方）","截止目前累计治理量（万方）"},index = 13)
		@ColumnWidth(15)
		private String governnum;

		@ExcelProperty(value = {"治理主体","治理主体"},index = 14)
		@ColumnWidth(15)
		private String governbody;

		@ExcelIgnore
//		@Dict(dicCode = "typestr")
		private String typestr;

		@ExcelProperty(value = {"堆体类型","堆体类型"},index = 2)
		@ColumnWidth(15)
		private String typestrname;

		@ExcelIgnore
//		@Dict(dicCode = "statestr")
		private String statestr;

		@ExcelIgnore
		private String districtname;

		@ExcelProperty(value = {"监管单位","监管单位"},index = 15)
		@ColumnWidth(15)
		private String supervisedepartname;

		@ExcelProperty(value = {"监管责任人","监管责任人"},index = 16)
		@ColumnWidth(10)
		private String supervisepeoname;

		@ExcelProperty(value = {"职务","职务"},index = 17)
		@ColumnWidth(10)
		private String supervisepeoposition;

		@ExcelProperty(value = {"联系方式","联系方式"},index = 18)
		@ColumnWidth(20)
		private String supervisepeophone;

		@ExcelIgnore
		private String residuenum;

		@ExcelIgnore
		private String governendtime;

		@ExcelIgnore
		private String governendyearmonth;

		@ExcelProperty(value = {"本月治理量（万方）","外运量"},index = 9)
		@ColumnWidth(15)
		private String outwardtransportnum;

		@ExcelProperty(value = {"本月治理量（万方）","整理地形绿化量"},index = 10)
		@ColumnWidth(15)
		private String afforestnum;

		@ExcelProperty(value = {"本月治理量（万方）","临时覆盖或绿化量"},index = 11)
		@ColumnWidth(15)
		private String temporarilynum ;

		@ExcelProperty(value = {"本月治理量（万方）","合计"},index = 12)
		private String goverytotal;

		@ExcelIgnore
		private String qynum;

		@ExcelIgnore
//		@Dict(dicCode = "sourcestr")
		private String sourcestr;


		@ExcelIgnore
		private String createbyname;

	}

