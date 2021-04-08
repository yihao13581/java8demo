package com.it.java8demo.javabase.OftenUserClass;

import java.math.BigDecimal;

/**
 * @CLassName BigDecimalDemo
 * @Description: TODO
 * @date: 2020/12/14 10:05
 * @Version 1.0
 */
public class BigDecimalDemo {

	/**
	 * BigDecimal类能精确表示、计算浮点数。
	 * 当程序使用new BigDecimal(0.1)来创建一个BigDecimal对象时，它的值并不是0.1，而是一个近似0.1的数。但使用
	 * new BigDecimal("0.1")将创建一个BigDecimal对象，它正好等于预期的0.1。
	 * ☆☆☆☆☆☆创建BigDecimal对象时一定要使用String作为构造器参数，而不是直接使用double数字（精度丢失）
	 *
	 */
	public static void main(String[] args) {
		BigDecimal f1=new BigDecimal("0.05");
		BigDecimal f2=BigDecimal.valueOf(0.01);


	}
}
