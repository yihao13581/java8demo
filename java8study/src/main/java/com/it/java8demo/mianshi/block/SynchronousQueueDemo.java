package com.it.java8demo.mianshi.block;

import org.apache.tomcat.util.collections.SynchronizedQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * SynchronousQueue没有容量
 * 与其他BlockingQueue不同，SynchronousQueue是一个不存储元素的BlockingQueue。
 * 每一个put操作必须要等待一个take操作，否则不能继续添加元素，反之亦然。
 */
public class SynchronousQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();
       new Thread(()->
       {
           try {
               System.out.println(Thread.currentThread().getName()+"\t put 1");
               blockingQueue.put("1");

               System.out.println(Thread.currentThread().getName()+"\t put 2");
               blockingQueue.put("2");

               System.out.println(Thread.currentThread().getName()+"\t put 3");
               blockingQueue.put("3");

           } catch (InterruptedException e) {
               e.printStackTrace();
           } finally {

           }
       },"AAA").start();

        new Thread(()->
        {
            try {
               //暂停一会线程
                try{ TimeUnit.SECONDS.sleep(5);}catch(InterruptedException e){e.printStackTrace();}
                System.out.println(Thread.currentThread().getName()+"\t"+blockingQueue.take());
                try{ TimeUnit.SECONDS.sleep(5);}catch(InterruptedException e){e.printStackTrace();}
                System.out.println(Thread.currentThread().getName()+"\t"+blockingQueue.take());
                try{ TimeUnit.SECONDS.sleep(5);}catch(InterruptedException e){e.printStackTrace();}
                System.out.println(Thread.currentThread().getName()+"\t"+blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"BBB").start();

    }
}
