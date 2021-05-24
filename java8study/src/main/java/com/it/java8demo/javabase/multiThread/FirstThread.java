package com.it.java8demo.javabase.multiThread;

/**
 * @CLassName FirstThread
 * @Description: kevin
 * @date: 2020/12/18 17:05
 * @Version 1.0
 */

/**
 * 通过继承Thread类来创建并启动多线程步骤：
 * 1、定义Thread类的子类，并重写该类的run方法，该run方法的方法体就代表了线程需要完成的任务。线程执行体
 * 2、创建Thread子类的实例，即创建了线程对象
 * 3、调用线程对象的start来启动线程
 * 使用继承Thread类的方法来创建线程类时，多个线程之间无法共享线程类的实例变量
 * <p>
 * <p>
 * Runnable接口中只包含一个抽象方法，Java8之后，Runnable接口使用@FunctionInterface修饰。也是函数式接口
 * 可以使用Lambda表达式创建Runnable对象
 */
public class FirstThread extends Thread {
	private int i;

	/**
	 * 重写run()方法，run()方法的方法体就是线程执行体
	 */
	@Override
	public void run() {
		for (; i < 100; i++) {
			//当线程类继承Thread类时，直接使用this即可获取当前线程
			//Thread对象的getName()返回当前线程的名字
			//因此可以直接调用getName()方法返回当前线程的名字
			System.out.println(getName() + " " + i);
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			//调用Thread的CurrentThread()方法获取当前线程
			System.out.println(Thread.currentThread().getName() + " " + i);
			if (i == 20) {
				//创建并启动第一个线程
				new FirstThread().start();
				//创建并启动第二个线程
				new FirstThread().start();
			}
		}
	}

}
