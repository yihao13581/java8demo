package com.it.java8demo.javabase.io;

import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * @CLassName FileLockTest
 * @Description: TODO
 * @date: 2020/12/18 15:01
 * @Version 1.0
 */
public class FileLockTest {
	/**
	 * NIO中，Java提供了FileLock来支持文件锁定功能，在FileChannel中提供的lock()/tryLock()方法
	 * 可以获得文件锁FileLock对象，从而锁定文件。区别：lock()试图锁定某文件时，如果无法获得文件
	 * 锁，程序将一直阻塞；而tryLock()是尝试锁定文件，它将直接返回而不是阻塞，如果获得了文件锁，该
	 * 方法则返回文件锁，否则返回null
	 * 若FileChannel只想锁定文件的部分内容，而不是全部内容可使用如下方法：
	 * lock(long position,long size,boolean shared):对文件从position开始，长度为size的内容加锁，阻塞式方法
	 * tryLock(long position,long size,boolean shared):非阻塞式的加锁方式
	 */

	public static void main(String[] args) throws Exception {
		try (//使用FileOutputStream获取FileChannel
			 FileChannel channel = new FileOutputStream("a.txt").getChannel())
		{
			//使用非阻塞式方式对文件加锁
			FileLock lock=channel.tryLock();
			//程序暂停10s
			Thread.sleep(10000);
			lock.release();
		}


	}
}
