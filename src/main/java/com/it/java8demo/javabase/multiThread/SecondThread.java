package com.it.java8demo.javabase.multiThread;

/**
 * @CLassName SecondThread
 * @Description: TODO
 * @date: 2020/12/18 17:28
 * @Version 1.0
 */

/**
 * 实现Runnable接口来创建并启动多线程的步骤
 * 		1、定义Runnable接口的实现类，并重新run()方法
 * 		2、创建Runnable实现类的实例，并以此实例作为Thread的target来创建Thread对象，该Thread对象
 * 	才是真正的线程对象。
 * 		3、调用线程对象的start()方法来启动该线程
 */
public class SecondThread  implements Runnable{
	private int i;

	/**
	 * run()方法同样时线程执行体
	 */
	@Override
	public void run() {
		for(;i<100;i++)
		{
			//当线程类实现Runnable接口时，想获取当前线程，只能用Thread.currentThread()方法
			System.out.println(Thread.currentThread().getName()+" "+i);
		}
	}

	public static void main(String[] args) {
		for(int i=0;i<100;i++)
		{
			System.out.println(Thread.currentThread().getName()+" "+i);
			if(i==20)
			{
				SecondThread secondThread=new SecondThread();
				//通过new Thread(target,name)方式创建新线程
				new Thread(secondThread,"新线程1").start();
				new Thread(secondThread,"新线程2").start();
			}
		}

	}
}
