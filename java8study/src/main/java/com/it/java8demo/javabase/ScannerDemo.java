package com.it.java8demo.javabase;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @CLassName JavaBaseDemo
 * @Description: TODO
 * @date: 2020/12/9 10:23
 * @Version 1.0
 */
public class ScannerDemo {
	public static void main(String[] args) throws Exception{
//		scannerDemo();
		scannerReadFile();
	}

	/**
	 * scanner读取文件内容
	 * @throws FileNotFoundException
	 */
	private static void scannerReadFile() throws FileNotFoundException {
		Scanner scanner=new Scanner(new File("java8demo.iml"));
		while(scanner.hasNextLine()){
			//输出文件中的下一行
			System.out.println(scanner.nextLine());
		}
	}

	/**
	 * 读取键盘输入
	 */
	private static void scannerDemo() {
		//System.in：代表标准输入，就是键盘输入
		Scanner sc=new Scanner(System.in);
		//next()读取下一项输入字符串；nextInt()下一项输入整数；nextLong();nextLine():返回输入源中下一行的字符串
		while(sc.hasNext()){
			System.out.println("键盘输入的内容是："+sc.next());
		}
	}
}
