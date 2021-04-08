package com.it.java8demo.mianshi.sangedemo;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch:倒计数控制，减为0以后 countDownLatch.await();之后被阻止的主线程才能够被执行
 *
 *
 * CountDownLatch主要有两个方法,当一个或多个线程调用await方法时,调用线程会被阻塞.
 * 其他线程调用countDown方法计数器减1(调用countDown方法时线程不会阻塞),当计数器的值变为0,
 * 因调用await方法被阻塞的线程会被唤醒,继续执行
 *
 *
 */

public class CountDownLatchDemo {
    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch=new CountDownLatch(6);
        for (int i = 1; i <=6 ; i++) {
            new Thread(()->
            {
                System.out.println(Thread.currentThread().getName()+"\t国，被灭");
                countDownLatch.countDown();
            },CountryEnum.forEach_CountryEnum(i).getRetMessage()).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t ***********秦帝国，一统华夏");

    }

    private static void closeDoor() throws InterruptedException {
        CountDownLatch countDownLatch=new CountDownLatch(6);
        for (int i = 1; i <=6 ; i++) {
            new Thread(()->
            {
                System.out.println(Thread.currentThread().getName()+"\t 上完自习，离开教室");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t ***********88班长最后关门走人");
    }
}
