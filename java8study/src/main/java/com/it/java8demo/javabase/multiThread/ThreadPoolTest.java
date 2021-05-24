package com.it.java8demo.javabase.multiThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @CLassName ThreadPoolTest
 * @Description: TODO
 * @date: 2020/12/21 17:46
 * @Version 1.0
 */
public class ThreadPoolTest {
	/**
	 * 使用线程池来执行线程任务的步骤如下：
	 * 	1、调用Executors类的静态工厂方法创建一个ExecutorService对象，该对象代表一个线程池
	 * 	2、创建Runnable实现类或Callable实现类的实例，作为线程执行任务
	 * 	3、调用ExecutorService对象的submit()方法来提交Runnable实例或Callable实例。
	 * 	4、当不想提交任何任务时，调用ExecutorService对象的shutdown()方法来关闭线程池。
	 */
	public static void main(String[] args) throws Exception{
		//创建一个具有固定线程数（6）的线程池
		ExecutorService pool= Executors.newFixedThreadPool(6);
		//使用Lambda表达式创建Runnable对象
		Runnable target=()->{
			for(int i=0;i<100;i++){
				System.out.println(Thread.currentThread().getName()+"的i值为："+i);
			}
		};
		//向线程池中提交两个线程
		pool.submit(target);
		pool.submit(target);
		//关闭线程池
		pool.shutdown();
	}
}
