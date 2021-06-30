package com.haotian.haotianpoi.test.sd;

import java.io.InputStream;

/**
 * @CLassName FileTest
 * @Description: TODO
 * @date: 2021/2/23 15:46
 * @Version 1.0
 */
public class FileTest {
	public static void main(String[] args) throws Exception{
//创建字节输入流
		InputStream fis=FileTest.class.getResourceAsStream("/test.txt");
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
