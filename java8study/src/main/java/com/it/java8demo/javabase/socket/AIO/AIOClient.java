package com.it.java8demo.javabase.socket.AIO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @CLassName AIOClient
 * @Description: TODO
 * @date: 2020/12/23 15:14
 * @Version 1.0
 */
public class AIOClient {
	final static String UTF_8="utf-8";
	final static int PORT=30000;
	/**
	 * 与服务器端通信的异步Channel
	 */
	AsynchronousSocketChannel clientChannel;
	JFrame mainWin=new JFrame("多人聊天");
	JTextArea jta=new JTextArea(16,48);
	JTextField jtf=new JTextField(40);
	JButton sendBn=new JButton("发送");
	public void init(){
		mainWin.setLayout(new BorderLayout());
		jta.setEditable(false);
		mainWin.add(new JScrollPane(jta),BorderLayout.CENTER);
		JPanel jp=new JPanel();
		jp.add(jtf);
		jp.add(sendBn);
		//发送消息的Action，action是ActionListener的子接口
		Action sendAction=new AbstractAction(){
			@Override
			public void actionPerformed(ActionEvent e){
				String  content=jtf.getText();
				if(content.trim().length()>0)
				{
					try{
						//将content内容写入channel中
						clientChannel.write(ByteBuffer.wrap(content.trim().getBytes(UTF_8))).get();
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}
				//清空输入框
				jtf.setText("");
			}
		};
		sendBn.addActionListener(sendAction);
		//将“Ctrl+Enter”键和“send”关联
		jtf.getActionMap().put("send",sendAction);
		mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWin.add(jp,BorderLayout.SOUTH);
		mainWin.pack();
		mainWin.setVisible(true);
	}
	public void connect() throws Exception{
		//定义一个ByteBuffer准备读取数据
		final ByteBuffer buffer=ByteBuffer.allocate(1024);
		//创建一个线程池
		ExecutorService executor= Executors.newFixedThreadPool(80);
		//以指定线程池来创建一个AsynchronousChannelGroup
		AsynchronousChannelGroup channelGroup=AsynchronousChannelGroup.withThreadPool(executor);
		//以channelGroup作为组管理器来创建AsynchronousSocketChannel
		clientChannel=AsynchronousSocketChannel.open(channelGroup);
		//让AsynchronousSocketChannel连接到指定IP地址、指定端口
		clientChannel.connect(new InetSocketAddress("127.0.0.1",PORT)).get();
		jta.append("---与服务器来凝结成功------\n");
		buffer.clear();
		clientChannel.read(buffer, null, new CompletionHandler<Integer, Object>() {
			@Override
			public void completed(Integer result, Object attachment) {
				buffer.flip();
				//将buff中的内容转换成字符串
				String content= StandardCharsets.UTF_8.decode(buffer).toString();
				//显示从服务器端读取的数据
				jta.append("某人说："+content+"\n");
				buffer.clear();
				clientChannel.read(buffer,null,this);
			}

			@Override
			public void failed(Throwable ex, Object attachment) {
				System.out.println("读取数据失败："+ex);

			}
		});

	}

	public static void main(String[] args) throws Exception{
		AIOClient client=new AIOClient();
		client.init();
		client.connect();
	}

}
