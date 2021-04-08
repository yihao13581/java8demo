package com.it.java8demo.mianshi.block;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareData {
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() throws Exception {
        lock.lock();
        try {
            //1判断       多线程判断用while
            while (number != 0) {

                //等待，不能生产
                condition.await();
            }
            //2干活
            number++;
            System.out.println(Thread.currentThread().getName() + "\t我要生产" + number);
            //3通知唤醒
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void decrement() throws Exception {
        lock.lock();
        try {
            //1判断       多线程判断用while
            while (number == 0) {

                //等待，不能生产
                condition.await();
            }
            //2干活
            number--;
            System.out.println(Thread.currentThread().getName() + "\t我要消费" + number);
            //3通知唤醒
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}

/**
 *    多线程消费者生产者传统版
 * 高内聚低耦合前提下     ：  线程操作资源类，判断干活唤醒通知 ---》严防多线程并发下的虚假唤醒
 * <p>
 * <p>
 * 题目：一个初事为零的变量，两个线程对其交替操作，一个加1一个减1，来5轮（传统版消费者生产者模式）
 * <p>
 * 1 线程         操作          资源类
 * 2 判断         干活          通知
 * 3 防止虚假唤醒机制     多线程的判断用 while 而不是 if判断
 */
public class ProdConsumer_TraditionDemo {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();

        new Thread(() ->
        {
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "AA").start();

        new Thread(() ->
        {
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "BB").start();

    }
}
