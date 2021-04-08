package com.it.java8demo.javabase.OftenUserClass;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @CLassName ThreadLocalRandomDemo
 * @Description: TODO
 * @date: 2020/12/11 17:21
 * @Version 1.0
 */
public class ThreadLocalRandomDemo {
	/**
	 * Random类专门用来生成一个伪随机数，他有两个构造器：一个构造器使用默认的种子(以当前时间作为种子)，
	 * 另一个构造器需要程序员显示传入一个Long型整数的种子。
	 * 只要两个Random对象的种子相同，而且方法的调用顺序也相同，它们就会产生相同的数字序列。（伪随机）
	 *
	 * ThreadLocalRandom类是Java7新增的一个类，是Random类的增强版。在并发访问的环境下，使用ThreadLocalRandom
	 * 来代替Random可以减少多线程资源竞争，最终保证系统具有更好的线程安全性。
	 * ★ 用法：与Random类似，提供一个静态的current()方法来获取ThreadLocalRandom对象，获取该对象之后可调用各种nextXxx()方法来获取伪随机数
	 */
	public static void main(String[] args) {
		Random rand=new Random();
		System.out.println("rand.nextBoolean:"+rand.nextBoolean());
		byte[] buffer=new byte[16];
		rand.nextBytes(buffer);
		System.out.println(Arrays.toString(buffer));

		//生成处于int整数范围的伪随机整数
		System.out.println("rand.nextInt():"+rand.nextInt());
		//生成0-26之间伪随机整数
		System.out.println("rand.nextInt():"+rand.nextInt(26));

		ThreadLocalRandom threadLocalRandom=ThreadLocalRandom.current();
		//生成一个4-20之间的伪随机整数
		int val1=threadLocalRandom.nextInt(4,20);
		//生成一个2.0-10.0之间的伪随机浮点数
		double val2=threadLocalRandom.nextDouble(2.0,10.0);
		System.out.println(val1);
		System.out.println(val2);

	}
}
