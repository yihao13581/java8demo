package com.zyzx.rocketmq.rocketmq.batch;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @CLassName Producer发送批量消息
 * @Description: TODO
 * @Author: shenhao
 * @date: 2019/10/22 9:31
 * @Version 1.0
 */
public class Producer {

	public static void main(String []args) throws Exception{
		//1.创建消息生产者producer，并制定生产者组名
		DefaultMQProducer producer=new DefaultMQProducer();
		//2.指定Nameserver地址
		producer.setNamesrvAddr("192.168.13.128:9876;192.268.13.129:9876");
		//3.启动producer
		producer.start();
		List<Message> msgs=new ArrayList<>();

		//4.创建消息对象，指定主题Topic、Tag和消息体
		/**
		 * 参数一：消息主题Topic
		 * 参数二：消息Tag
		 * 参数三：消息内容
		 */
		Message msg1=new Message("batchTop","tag1",("hello word"+1).getBytes());
		Message msg2=new Message("batchTop","tag2",("hello word"+2).getBytes());
		Message msg3=new Message("batchTop","tag3",("hello word"+3).getBytes());

		msgs.add(msg1);
		msgs.add(msg2);
		msgs.add(msg3);
		//5.发送消息
		SendResult result=producer.send(msgs);
		//发送状态
		SendStatus sendStatus=result.getSendStatus();
		System.out.println("发送状态："+result.toString());

		//线程睡一秒
		TimeUnit.SECONDS.sleep(1);

		//6.关闭生产者producer
		producer.shutdown();


//        //把大消息分裂成若干小的消息
//        ListSplitter splitter = new ListSplitter(msgs);
//        while (splitter.hasNext()) {
//            try {
//                List<Message> listItem = splitter.next();
//                producer.send(listItem);
//            } catch (Exception e) {
//                e.printStackTrace();//处理error}
//            }
//        }
	}


}
