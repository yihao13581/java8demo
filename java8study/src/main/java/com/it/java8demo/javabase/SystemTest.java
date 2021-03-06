package com.it.java8demo.javabase;

import java.io.FileOutputStream;
import java.util.Map;
import java.util.Properties;

/**
 * @CLassName SystemTest
 * @Description: TODO
 * @date: 2020/12/9 11:08
 * @Version 1.0
 */
public class SystemTest {
	public static void main(String[] args) throws Exception{
		//获取系统所有的环境变量
		Map<String,String> env=System.getenv();
		for(String name:env.keySet())
		{
			System.out.println(name+" ---->"+env.get(name));
		}
		//获取指定环境变量的值
		System.out.println(System.getenv("JAVA_HOME"));
		//获取所有系统的属性
		Properties props=System.getProperties();
		//将所有的系统属性保存倒props.txt文件中
		props.store(new FileOutputStream("props.txt"),"System Properties");
		//输出特定的系统属性
		System.out.println(System.getProperty("os.name"));

		System.out.println();
	}
}
