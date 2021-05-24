package com.it.java8demo.javabase;

/**
 * @CLassName RuntimeDemo
 * @Description: TODO
 * @date: 2020/12/11 14:41
 * @Version 1.0
 */
public class RuntimeDemo {
	/**
	 * Runtime类代表了Java程序的运行时环境，可以访问JVM的相关信息，如处理器数量、内存信息
	 * 应用程序不能创建自己的Runtime实例，但可以通过getRuntime()方法获取与之关联的Runtime对象
	 *
	 */
	public static void main(String[] args)throws Exception {
		//获取Java程序关联的运行对象
		Runtime rt=Runtime.getRuntime();
		System.out.println("处理器数量："+rt.availableProcessors());
		System.out.println("空闲内存数："+rt.freeMemory());
		System.out.println("总内存数："+rt.totalMemory());
		System.out.println("可用最大内存数："+rt.maxMemory());

		//Runtime类可以单独启动一个进程来运行操作系统的命令
		//运行记事本程序
		rt.exec("notepad.exe");

	}
}
