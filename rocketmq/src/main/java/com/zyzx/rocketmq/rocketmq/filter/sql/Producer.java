package com.zyzx.rocketmq.rocketmq.filter.sql;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;

import java.util.concurrent.TimeUnit;

/**
 * @CLassName Producer
 * @Description: TODO
 * @Author: shenhao
 * @date: 2019/10/22 10:53
 * @Version 1.0
 */
public class Producer {

	public static void main(String[] args) throws Exception {
		//1.创建消息生产者producer，并制定生产者组名
		DefaultMQProducer producer = new DefaultMQProducer("group1");
		//2.指定Nameserver地址
		producer.setNamesrvAddr("192.168.13.128:9876;192.168.13.129:9876");
		//3.启动producer
		producer.start();

		for (int i = 0; i < 10; i++) {
			//4.创建消息对象，指定主题Topic、Tag和消息体
			/**
			 * 参数一：消息主题Topic
			 * 参数二：消息Tag
			 * 参数三：消息内容
			 */
			Message msg = new Message("filterSQLTopic", "tag1", ("hello word" + i).getBytes());
			msg.putUserProperty("i", String.valueOf(i));

			//5.发送消息
			SendResult result = producer.send(msg);
			//发送状态
			SendStatus status = result.getSendStatus();
			System.out.println("发送状态：" + result);
			//线程睡1秒
			TimeUnit.SECONDS.sleep(1);
		}
		//6.关闭生产者producer
		producer.shutdown();

	}
}
