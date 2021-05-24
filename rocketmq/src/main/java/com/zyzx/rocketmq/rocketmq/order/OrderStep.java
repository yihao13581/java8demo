package com.zyzx.rocketmq.rocketmq.order;

import java.util.ArrayList;
import java.util.List;

/**
 * @CLassName OrderStep
 * @Description: TODO
 * @Author: shenhao
 * @date: 2019/10/22 11:18
 * @Version 1.0
 */
public class OrderStep  {
	private long orderId;
	private String desc;

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "OrderStep{" +
				"orderId=" + orderId +
				", desc='" + desc + '\'' +
				'}';
	}

	public static List<OrderStep> buildOrders(){
		//  1039L   : 创建    付款 推送 完成
		//  1065L   ： 创建   付款
		//  7235L   ：创建    付款
		List<OrderStep> orderList=new ArrayList<>();

		OrderStep orderDemo = new OrderStep();
		orderDemo.setOrderId(1039L);
		orderDemo.setDesc("创建");
		orderList.add(orderDemo);

		orderDemo = new OrderStep();
		orderDemo.setOrderId(1065L);
		orderDemo.setDesc("创建");
		orderList.add(orderDemo);

		orderDemo = new OrderStep();
		orderDemo.setOrderId(1039L);
		orderDemo.setDesc("付款");
		orderList.add(orderDemo);

		orderDemo = new OrderStep();
		orderDemo.setOrderId(7235L);
		orderDemo.setDesc("创建");
		orderList.add(orderDemo);

		orderDemo = new OrderStep();
		orderDemo.setOrderId(1065L);
		orderDemo.setDesc("付款");
		orderList.add(orderDemo);

		orderDemo = new OrderStep();
		orderDemo.setOrderId(7235L);
		orderDemo.setDesc("付款");
		orderList.add(orderDemo);

		orderDemo = new OrderStep();
		orderDemo.setOrderId(1065L);
		orderDemo.setDesc("完成");
		orderList.add(orderDemo);

		orderDemo = new OrderStep();
		orderDemo.setOrderId(1039L);
		orderDemo.setDesc("推送");
		orderList.add(orderDemo);

		orderDemo = new OrderStep();
		orderDemo.setOrderId(7235L);
		orderDemo.setDesc("完成");
		orderList.add(orderDemo);

		orderDemo = new OrderStep();
		orderDemo.setOrderId(1039L);
		orderDemo.setDesc("完成");
		orderList.add(orderDemo);

		return orderList;

	}
}
