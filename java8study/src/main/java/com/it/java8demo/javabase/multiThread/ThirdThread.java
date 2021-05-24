package com.it.java8demo.javabase.multiThread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @CLassName ThridThread
 * @Description: TODO
 * @date: 2020/12/21 9:19
 * @Version 1.0
 */
public class ThirdThread {

	/**
	 * 		Java5开始提供了Callable接口，Callable接口提供了一个call()方法作为线程执行体，call()比方法run()
	 * 功能更强大。             1、call()方法可以有返回值。2、call()方法可以声明抛出异常。
	 *
	 * 		Java5提供了Future接口来代表Callable接口里call()方法的返回值，并为Future接口提供一个FutureTask
	 * 	实现类，该实现类实现了Future接口，并实现了Runnable接口。
	 *
	 * 		Future中定义的公共方法控制它关联的Callable任务
	 * 	》》boolean cancel(boolean mayInterruptIfRunning):试图取消该future里关联的Callable任务
	 * 	》》V  get():返回Callable任务中call（）方法的返回值。调用该方法会导致程序阻塞，必须等到子线程结束后才会得到返回值
	 * 	》》V  get(long timeout,TimeUnit unit):返回Callable任务中call（）方法的返回值。该方法让程序最对阻塞
	 * 	timeout和unit指定的时间，如果经过指定时间后Callable任务依然没有返回值，将会抛出TimeoutException异常
	 * 	》》boolean isCancelled():如果Callable任务正常完成前被取消，则返回true
	 * 	》》boolean isDone():如果Callable任务已完成，则返回true
	 *
	 */

	/**
	 * 创建并启动有返回值的线程的步骤如下：1、创建Callable接口的实现类，并实现call()方法,该call方法将作为线程的执行体，
	 * 且该call()方法有返回值，再创建Callable实现类的实例。	2、使用FutureTask类来包装Callable对象，该FutureTask对象封装了
	 * 该Callable对象的call()方法的返回值。  3、使用FutureTask作为Thread对象的target创建并启动线程。 4、调用FutureTask
	 * 对象的get()方法来获得子线程执行结束后的返回值。
	 */
	public static void main(String[] args) {

		//创建Callable对象
		ThirdThread rt = new ThirdThread();
		//先使用Lambda表达式创建Callable<Integer>对象
		//使用FutureTask来包装Callable对象
		FutureTask<Integer> task = new FutureTask<>((Callable<Integer>) () -> {
			int i = 0;
			for (; i < 100; i++) {
				System.out.println(Thread.currentThread().getName() + "的循环变量i的值：" + i);
			}
			//call()方法可以有返回值
			return i;
		});
		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + "的循环变量i的值：" + i);
			if (i == 20) {
				//实质还是以callable对象来创建并启动线程的
				new Thread(task, "有返回值的线程").start();
			}
		}
		try {
			//获取线程返回值
			System.out.println("子线程的返回值："+task.get());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
