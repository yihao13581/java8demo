package com.it.java8demo.javabase.socket.proxy;

import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 * @CLassName ProxyTest
 * @Description: TODO
 * @date: 2020/12/24 14:19
 * @Version 1.0
 */
public class ProxyTest {
	//下面是代理服务器的地址和端口
	//换成实际有效的代理服务器的地址和端口
	final String PROXY_ADDR="129.82.12.188";
	final int PROXY_PORT=3124;
	//定义需要访问的网站地址
	String urlStr="http://www.crazyit.org";
	public void init() throws Exception{
		URL url=new URL(urlStr);
		//创建一个代理服务器对象
		Proxy proxy=new Proxy(Proxy.Type.HTTP,new InetSocketAddress(PROXY_ADDR,PROXY_PORT));
		//使用指定的代理服务器打开连接
		URLConnection conn=url.openConnection(proxy);
		//设置超时时长
		conn.setConnectTimeout(3000);
		try(
				//通过代理服务器读取数据的Scanner
				Scanner scan=new Scanner(conn.getInputStream());
				PrintStream ps=new PrintStream("index.html")
				){
			while(scan.hasNextLine())
			{
				String line=scan.nextLine();
				//在控制太输出网页资源内容
				System.out.println(line);
				//将网页资源内容输出到指定输出流
				ps.println(line);
			}
		}
	}

	public static void main(String[] args)throws Exception {
		new ProxyTest().init();
	}
}
