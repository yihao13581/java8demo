package com.it.java8demo.javabase.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @CLassName UdpServer
 * @Description: TODO
 * @date: 2020/12/24 10:00
 * @Version 1.0
 */
public class UdpServer {
	public  static final int PORT=30000;
	//定义每个数据报的大小最大为4KB
	private static final int DATA_LEN=4096;
	//定义接收网络数据的字节数组
	byte [] inBuff=new byte[DATA_LEN];
	//以指定字节数组创建准备接收数据的DatagramPacket对象
	private DatagramPacket inPacket=new DatagramPacket(inBuff,inBuff.length);
	//定义一个用于发送的DatagramPacket
	private DatagramPacket outPacket;
	//定义一个字符串数组，服务器端发送该数组的元素
	String [] books=new String[]{
		"疯狂Java讲义","轻量级Java EE企业应用实战","疯狂Android讲义","疯狂Ajax讲义"
	};
	public void init() throws IOException{
		try(
				//创建DatagramSocket对象
			DatagramSocket socket=new DatagramSocket(PORT)
			)
		{  //采用循环接收数据
			for(int i=0;i<1000;i++){
				//读取Socket中的数据，读到的数据放入inPacket封装的数组中
				socket.receive(inPacket);
				//判断inPacket.getData()和inBuff是否为同一个数组
				System.out.println(inBuff==inPacket.getData());
				//将接收到的内容转换成字符串后输出
				System.out.println(new String(inBuff,0,inPacket.getLength()));
				byte[] sendData=books[i%4].getBytes();
				//已制定的字节数组作为发送数据，以刚接收到的DatagramPacket的
				//源SocketAddress作为目标SocketAddress创建DataGramPacket
				outPacket=new DatagramPacket(sendData,sendData.length,inPacket.getSocketAddress());
				//发送数据
				socket.send(outPacket);
			}

		}
	}

	public static void main(String[] args)throws Exception {
		new UdpServer().init();
	}
}
