package com.it.java8demo.distributed.common;

public class Client {
    public static void main(String[] args) {
//        OrderService orderService=new OrderService();
        for(int i=0;i<=30;i++){
            new Thread(()->{
                new OrderService().getOrdNumber();
            },String.valueOf(i)).start();
        }
    }
}
