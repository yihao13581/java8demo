package com.it.java8demo.javabase.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

/**
 * @CLassName NIODemo
 * @Description: TODO；
 * @date: 2020/12/18 9:28
 * @Version 1.0
 */
public class NIODemo {
	/**
	 * 		Channel(通道)和Buffer(缓冲)是新IO中的两个核心对象，Channel是对传统的输入/输出系统的模拟
	 * ，在新IO系统中所有的数据都需要通过通道传输；Channel与传统的InputStream、OutputStream最大的
	 * 区别在于它提供了一个Map()方法，通过该map()方法可以直接将“一块数据”映射到内存中。传统输入/输出是
	 * 面向流的处理，则NIO是面向块的处理。Buffer可以理解为一个容器，本质为一个数组，发送到Channel中的所有
	 * 对象都必须首先放到Buffer中，而从Channel中读取到的数据也必须先放到Buffer中。NIO也提供了用于将Unicode字符串
	 * 映射成字节序列以及映射操作的Charset类，也提供了用于支持非阻塞式输入/输出的Selector类。
	 * 		Buffer中的三个重要概念：容量(capacity)、界限（limit）和位置（position）
	 * 	  	 容量(capacity):表示该Buffer的最大数据容量
	 * 	  	 界限（limit）：第一个不应该背读出或写入的缓冲区位置索引。位于limit后的数据既不可被读，也不可被写。
	 * 	  	 位置（position）：用于指明下一个可以被读入的或者写入的缓冲区位置索引。当新建一个Buffer对象时，它的
	 * 	 position的位置为0。
	 *
	 * 	 	Buffer的主要作用时装入数据，然后输出数据。当Buffer装入数据结束后，调用Buffer的flip()
	 * 方法，该方法将limit设置为position所在位置，并将position设为0，使得Buffer的读写指针又移动到开始位置。Buffer调用
	 * flip()方法为输出数据做好准备。当Buffer输出数据结束后，Buffer调用clear()方法，clear（）不是清楚Buffer中的数据，它
	 * 仅仅将position置为0，将limit置为capacity。这样为再次装数据做准备。
	 *
	 * 		使用Channel，Channel与传统的流对象的两个主要区别
	 * 	       1、Channel可以直接将指定文件的部分或者全部直接映射到成buffer
	 * 	       2、程序不能直接访问Channel中的数据，包括读取、写入都不行，Channel只能与Buffer进行交互
	 *
	 * 	     所有的Channel都不应该通过构造器来直接创建，而是通过传统的节点InputStream、OutputStream的
	 * 	 getChannel()方法来返回对应的channel。
	 * 	 	 Channel的最常用的三类方法是map()、read()和write()。其中map()方法用于将Channel对应的部分或全部数据映射成
	 * ByteBuffer，而read()或write()方法都有一系列的重载模式，用于从Buffer中读取数据或者向Buffer中写入数据。
	 *
	 *
	 */

	public static void main(String[] args) throws IOException {
		//创建Buffer
//		createBuffer();

		//使用channel
		File f=new File("a.txt");
		try(//创建一个RandomAccessFile对象
			RandomAccessFile raf=new RandomAccessFile(f,"rw");
			//获取RandomAccessFile对应的Channel
			FileChannel randomChannel=raf.getChannel())
		{
			//将channel中所有数据映射成ByteBuffer
			ByteBuffer buffer=randomChannel.map(FileChannel.MapMode.READ_ONLY,0,f.length());
			//把channel的记录指针移动到最后
			randomChannel.position(f.length());
			//将buffer中的所有数据输出
			randomChannel.write(buffer);
		}



	}

	private static void createBuffer() {
		//创建一个Capacity为8的CharBuffer
		CharBuffer buff=CharBuffer.allocate(8);
		System.out.println("capacity:"+buff.capacity());
		System.out.println("limit:"+buff.limit());
		System.out.println("position:"+buff.position());
		//放入元素
		buff.put('a');
		buff.put('b');
		buff.put('c');
		System.out.println("增加3个元素后，position="+buff.position());
		//调用Flip方法
		buff.flip();
		System.out.println("执行flip方法后，limit="+buff.limit());
		System.out.println("执行flip方法后，position="+buff.position());
		//取出第一个元素
		System.out.println("第一个元素（position=0）："+buff.get());
		System.out.println("取出一个元素后，position的位置=："+buff.position());

		//调用clear方法
		buff.clear();
		System.out.println("执行clear后，limit="+buff.limit());
		System.out.println("执行clear后，position="+buff.position());
		System.out.println("执行clear后，缓冲区的内容没有被清除"+"第三个元素为："+buff.get(2));
		System.out.println("执行绝对读取后，position="+buff.position());
	}
}
