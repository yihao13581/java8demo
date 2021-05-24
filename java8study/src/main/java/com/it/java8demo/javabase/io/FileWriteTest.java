package com.it.java8demo.javabase.io;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @CLassName FileWriteTest
 * @Description: TODO
 * @date: 2020/12/16 11:14
 * @Version 1.0
 */
public class FileWriteTest {
	public static void main(String[] args) {
		try {
			FileWriter fw=new FileWriter("poem.txt");
			{
				fw.write("锦瑟-李商隐\r\n");
				fw.write("锦瑟无端五十弦，一弦一柱思华年。\r\n");
				fw.write("庄生晓梦迷蝴蝶，望帝春心托杜鹃。\r\n");
				fw.write("沧海月明珠有泪，蓝田日暖玉生烟。\r\n");
				fw.write("此情可待成追忆，只是当时已惘然。\r\n");
				fw.flush();
				fw.close();


			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
