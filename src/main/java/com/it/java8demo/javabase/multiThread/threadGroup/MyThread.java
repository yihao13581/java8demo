package com.it.java8demo.javabase.multiThread.threadGroup;

/**
 * @CLassName MyThread
 * @Description: TODO
 * @date: 2020/12/21 17:14
 * @Version 1.0
 */
public class MyThread extends Thread {

	public MyThread(){}
	//提供指定线程名的构造器
	public MyThread(String name){
		super(name);
	}
	//提供指定线程名、线程组的构造器
	public MyThread(ThreadGroup group,String name)
	{
		super(group,name);
	}
	@Override
	public void run(){
		for(int i=0;i<20;i++){
			System.out.println(getName()+"线程的i变量"+i);
		}
	}


}
