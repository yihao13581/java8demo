package com.it.java8demo.javabase.io;

import java.io.File;
import java.io.IOException;

/**
 * @CLassName IODemo
 * @Description: TODO
 * @date: 2020/12/15 10:56
 * @Version 1.0
 */
public class FileDemo {
	/**
	 * File类常用操作文件和目录的方法
	 * 		1、访问文件名相关的方法：
	 * 			String getName():返回该File对象所表示的文件名或路径名
	 * 			String getPath():返回此File对象所对应的路径名
	 * 		   	File getAbsoluteFile():返回该File对象所对应的绝对路径名
	 * 		   	String getParent():返回该File对象所对应目录的父目录名
	 * 		   	boolean renameTo(File newName)：重命名此File对象所对应的文件或目录，如果重命名成功，则返回true；否则返回false.
	 *
	 * 		   	2、文件检测相关的方法：
	 * 		   	boolean exists():判断File对象所对应的文件或目录是否存在
	 * 		   	boolean canWrite():
	 * 		   	boolean canRead():
	 * 		   	boolean isFile():
	 * 		   	boolean isDirectory():
	 * 		   	boolean isAbsolute():判断File对象所对应的文件或目录是否是绝对路径
	 *
	 * 		   	3获取常规文件信息
	 * 		   	long lastModified():返回文件的最后修改时间
	 * 		   	long length()；返回文件内容的长度
	 *
	 * 		   	4文件操作相关的方法
	 * 		   	boolean createNewFile();
	 * 		   	boolean delete();
	 * 		   	。。。。
	 *
	 * 		   	5目录操作相关的方法
	 * 		   	boolean mkdir():试图创建一个File对象所对应的目录，如果目录创建成功，则返回true
	 * 		   	String[] list():列出File对象的所有子文件名和路径名，返回String数组
	 * 		   	File[] listFiles():列出File对象的所有子文件和路径，返回File数组
	 */
	public static void main(String[] args)throws Exception {
//		fileDo();

		fileFilter();


	}

	private static void fileFilter() {
		//在File类的list()方法中可以接收一个FilenameFilter参数，通过该参数可以只列出符合条件的文件
		File file=new File(".");
		//使用Lambda表达式（目标类型为FilenameFilter）实现文件过滤
		//如果文件名以.java结尾，或者文件对应一个路径，则返回true
		String [] nameList=file.list((dir,name)->name.endsWith(".java")||new File(name).isDirectory());
		for (String name :nameList){
			System.out.println(name);
		}
	}

	private static void fileDo() throws IOException {
		//以当前路径来创建一个File对象
		File file=new File(".");
		//直接获取文件名，输出一点
		System.out.println(file.getName());
		//获取相对路径的父路径可能出错，下面代码输出NUll
		System.out.println(file.getParent());
		//获取绝对路径
		System.out.println(file.getAbsoluteFile());
		//获取上一级的路径
		System.out.println(file.getAbsoluteFile().getParent());
		//在当前路径下创建一个临时文件
		File tmpFile=File.createTempFile("aaa",".txt",file);
		//指定当JVM退出时删除文件
		tmpFile.deleteOnExit();
		//以系统当前时间作为新文件名创建文件
		File newFile=new File(System.currentTimeMillis()+"");
		System.out.println("newFile对象是否存在："+newFile.exists());
		//以指定newFile对象来创建一个文件
		newFile.createNewFile();
		//以newFile对象来创建一个目录，因为newFile已存在
		//所以下面返回False
		newFile.mkdir();
		//使用list()方法列出当前路径下的所有文件和路径
		String [] fileList=file.list();
		System.out.println("=====当前路径下所有文件和路径如下====");
		for(String fileName:fileList)
		{
			System.out.println(fileName);
		}
		//listRoots()静态方法列出所有的磁盘根路径
		File[] roots=File.listRoots();
		System.out.println("====系统所有根路径如下====");
		for(File root:roots)
		{
			System.out.println(root);
		}
	}


}
