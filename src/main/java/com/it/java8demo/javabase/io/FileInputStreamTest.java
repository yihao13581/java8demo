package com.it.java8demo.javabase.io;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @CLassName
 * @Description: TODO
 * @date: 2020/12/16 10:10
 * @Version 1.0
 */
public class FileInputStreamTest {

	/**
	 * 按照流的流向来分，可以分为输入流和输出流
	 * 》》》输入流：只能从中读取数据，而不能向其写入数据
	 * 》》》输出流：只能向其写入数据，而不能从中读取数据
	 *		JAVA的IO流共涉及40多个类，都是从如下4个抽象基类派生的
	 *	InputStream/Reader：所有输入流的基类，前者是字节输入流，后者是字符输入流
	 *		在InputStream里包含的三个方法：
	 *			int read():从输入流中读取单个字节，返回所读取的字节数据（字节数据可直接转换为int类型）
	 *		    int read(byte[] b):从输入流中最多读取b.length个字节的数据，并将其存储在字节数组b中，返回实际读取的字节数
	 *		    int read(byte b,int off,int len):从输入流中最多读取len个字节的数据，并将其存储在数组b中，并不是从数组起点开始，而是从off位置开始
	 *		 在Reader里包含如下三个方法：
	 *		   int read():
	 *		   int read(char[] cbuf);
	 *		   int read(char[],int off,int len):
	 *
	 *	OutputStream/Writer：所有输出流的基类，前者是字节输出流，后者是字符输出流
	 */

	public static void main(String[] args) throws IOException {
		//创建字节输入流
		FileInputStream fis=new FileInputStream("props.txt");
		//创建一个长度为1024的竹筒
		byte[] bbuf=new byte[1024];
		//用于存储实际读取的字节数
		int hasRead=0;
		while((hasRead=fis.read(bbuf))>0){
			//取出竹筒中的水滴（字节），将字节数组转换成字符串输入
			System.out.println(new String(bbuf,0,hasRead));
		}
		//关闭文件输入流，放在finally块里更安全
		fis.close();
	}
}
