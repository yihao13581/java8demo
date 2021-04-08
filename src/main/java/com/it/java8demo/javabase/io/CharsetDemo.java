package com.it.java8demo.javabase.io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.SortedMap;

/**
 * @CLassName CharsetDemo
 * @Description: TODO
 * @date: 2020/12/18 14:16
 * @Version 1.0
 */
public class CharsetDemo {
	/**
	 * 获取当前Java所支持的全部字符集
	 */
	public static void main(String[] args) throws Exception{
//		getAll();

		//创建简体中文对应的Charset
		Charset cn=Charset.forName("GBK");
		//获取cn对象对应的编码器和解码器
		CharsetEncoder cnEncoder=cn.newEncoder();
		CharsetDecoder cnDecoder=cn.newDecoder();
		//创建一个CharBuffer对象
		CharBuffer cbuff=CharBuffer.allocate(8);
		cbuff.put('孙');
		cbuff.put('悟');
		cbuff.put('空');
		cbuff.flip();
		//将CharBuffer中的字符序列转换成字节序列
		ByteBuffer bbuff=cnEncoder.encode(cbuff);
		//循环访问ByteBuffer中的每个字节
		for(int i=0;i<bbuff.capacity();i++){
			System.out.println(bbuff.get(i)+"");
		}
		System.out.println("\n"+cnDecoder.decode(bbuff));
	}

	private static void getAll() {
		//获取Java支持的全部字符集
		SortedMap<String, Charset> map=Charset.availableCharsets();
		for(String alias:map.keySet()){
			//输出字符集的别名和对应的Charset对象
			System.out.println(alias+"----->"+map.get(alias));
		}
	}
}
