package com.it.java8demo.javabase.io;

import java.io.*;
import java.util.Scanner;

/**
 * @CLassName IODemo
 * @Description: TODO
 * @date: 2020/12/16 14:46
 * @Version 1.0
 */
public class IODemo {


	public static void main(String[] args) {
//		convertIODemo();
//		redirectOut();
		redirectIn();
	}

	private static void redirectIn() {
		try (FileInputStream fis = new FileInputStream("out.txt"))
		{
			//将标准输入重定向到fis输入流
			System.setIn(fis);
			//使用System.in创建Scanner对象，用于获取标准输入
			Scanner sc=new Scanner(System.in);
			//增加下面一行只把回车作为分隔符
			sc.useDelimiter("\n");
			//判断是否还有下一个输入项
			while(sc.hasNext()){
				//输出输入项
				System.out.println("键盘输入的内容是："+sc.next());
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	//重定向标准输出流
	private static void redirectOut() {
		try (//一次性创建PrintStream输出流
			 PrintStream ps = new PrintStream(new FileOutputStream("out.txt"))) {
			//将标准输出重定向到PS输出流
			System.setOut(ps);
			//向标准输出输出一个字符串
			System.out.println("普通字符串");
			//向标准输出输出一个对象
			System.out.println(new IODemo());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 输入/输出流体系中提供了两个转换流，这两个流用于实现将字节流转换成字符流。
	 * 其中InputStreamReader将字节输入流转换成字符输入流，OutputStreamWriter将字节输出流转换成字符输出流
	 */
	private static void convertIODemo() {
		try {
			//将System.in对象转换成Reader对象
			InputStreamReader reader = new InputStreamReader(System.in);
			//将普通的Reader包装成BufferedReader
			BufferedReader br = new BufferedReader(reader);
			{
				String line = null;
				//采用循环方式来逐行读取
				while ((line = br.readLine()) != null) {
					//如果读取的字符串为“exit"，则程序退出
					if (line.equals("exit")) {
						System.exit(1);
					}
					//打印读取的内容
					System.out.println("输入内容为：" + line);
				}
			}

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
