package com.zyzx.rocketmq.rocketmq.order;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * @CLassName Consumer消费顺序消息
 * @Description: TODO
 * @Author: shenhao
 * @date: 2019/10/22 11:17
 * @Version 1.0
 */
public class Consumer {
	public static void main(String[] args) throws Exception {
		//1.创建消费者Consumer，制定消费者组名
		DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("group1");
		//2.指定Nameserver地址
		consumer.setNamesrvAddr("192.168.25.135:9876;192.168.25.138:9876");
		//3.订阅主题Topic和Tag
		consumer.subscribe("OrderTopic", "*");

		//4.注册消息监听器，保证顺序的监听器
		consumer.registerMessageListener(new MessageListenerOrderly() {
		    //进行有序消息的多线程消费消息时，同一个消息队列使用同一个线程进行消费
			@Override
			public ConsumeOrderlyStatus consumeMessage(List<MessageExt> msgs, ConsumeOrderlyContext context) {
				for (MessageExt msg : msgs) {
					System.out.println("线程名称：【" + Thread.currentThread().getName() + "】:" + new String(msg.getBody()));
				}
				return ConsumeOrderlyStatus.SUCCESS;
			}
		});
		//5.启动消费者
		consumer.start();

		System.out.println("消费者启动");
	}
}
