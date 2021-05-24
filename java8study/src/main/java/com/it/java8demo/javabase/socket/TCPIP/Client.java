package com.it.java8demo.javabase.socket.TCPIP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @CLassName Client
 * @Description: TODO
 * @date: 2020/12/22 17:00
 * @Version 1.0
 */
public class Client {
	public static void main(String[] args)throws IOException {
		Socket socket=new Socket("192.168.0.63",30000);
		//将Socket对应的输入流包装成BufferedReader
		BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		//进行普通IO操作
		String line=br.readLine();
		System.out.println("来自服务器的数据"+line);
		//关闭输入流，关闭socket
		br.close();
		socket.close();
	}
}
