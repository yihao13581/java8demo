package com.it.java8demo.javabase.multiThread.threadGroup;

/**
 * @CLassName ThreadGroupTest
 * @Description: TODO
 * @date: 2020/12/21 17:20
 * @Version 1.0
 */
public class ThreadGroupTest {
	public static void main(String[] args) {
		//获取主线程所在的线程组，这是所有线程的默认的线程组
		ThreadGroup mainGroup=Thread.currentThread().getThreadGroup();
		System.out.println("主线程组的名字："+mainGroup.getName());
		System.out.println("主线程组是否为后台线程组："+mainGroup.isDaemon());
		new MyThread("主线程组的线程").start();
		ThreadGroup tg=new ThreadGroup("新线程组");
		tg.setDaemon(true);
		System.out.println("tg线程组是否时后台线程组："+tg.isDaemon());
		MyThread tt=new MyThread(tg,"tg组的线程甲");
		tt.start();
		new MyThread(tg,"tg组的线程乙").start();
	}
}
