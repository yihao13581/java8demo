package com.it.java8demo.javabase.socket.reflect;

import java.net.URL;
import java.util.Enumeration;

/**
 * @CLassName ClassLoaderPropTest
 * @Description: TODO
 * @date: 2020/12/24 17:18
 * @Version 1.0
 */
public class ClassLoaderPropTest {
	public static void main(String[] args) throws Exception{
		//获取系统类加载器
		ClassLoader systemLoader=ClassLoader.getSystemClassLoader();
		System.out.println("系统类加载器："+systemLoader);
		/**
		 * 获取系统类加载器的加载路径---通常由CLASSPATH环境变量指定
		 * 如果操作系统没有指定CLASSPATH环境变量，则默认以当前路径作为
		 * 系统类加载器的加载路径
		 */
		Enumeration<URL> eml=systemLoader.getResources("");
		while(eml.hasMoreElements()){
			System.out.println(eml.nextElement());
		}
		//获取系统类加载器的父类加载器，得到扩展加载器
		ClassLoader extensionLader=systemLoader.getParent();
		System.out.println("扩展类加载器："+extensionLader);
		System.out.println("扩展类加载器的加载路径:"+System.getProperty("java.ext.dirs"));
		System.out.println("扩展类加载器的parent："+extensionLader.getParent());


	}
}
