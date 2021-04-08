package com.it.java8demo.javabase.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * @CLassName PrintStreamTest
 * @Description: TODO
 * @date: 2020/12/16 13:55
 * @Version 1.0
 */
public class PrintStreamTest {
	/**
	 * 使用处理流时的典型思路：使用处理流来包装节点流，程序通过处理流来执行输入、输出功能，让
	 * 节点流与底层的I/O设备、文件交互。
	 */
	public static void main(String[] args) {
		usePrintStream();
	}

	/**
	 * 使用处理流非常简单，通常只需要在创建处理流时传入一个节点流作为构造器参数即可，这样创建的处理流
	 * 就是包装了该节点流的处理流。
	 */
	private static void usePrintStream() {
		try (FileOutputStream fos=new FileOutputStream("test.txt");
			 PrintStream ps=new PrintStream(fos))
		{
			//使用PrintStream执行输出
			ps.println("普通字符串");
			//直接使用printStream输出对象
			ps.println(new PrintStreamTest());
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}


	}

}
