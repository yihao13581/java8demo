package com.it.java8demo.mianshi.sangedemo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier的字面意思是可循环(Cyclic) 使用的屏障(barrier).它要做的事情是,
 * 让一组线程到达一个屏障(也可以叫做同步点)时被阻,直到最后一个线程到达屏障时,屏障才会
 * 开门,所有被屏障拦截的线程才会继续干活,线程进入屏障通过CyclicBarrier的await()方法.
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        //CyclicBarrier(int parties, Runnable barrierAction)
        CyclicBarrier cyclicBarrier=new CyclicBarrier(7,()->{System.out.println("******召唤神龙");});
        for (int i = 1; i <=7 ; i++) {
            final int tempInt=i;
            new Thread(()->
            {
            System.out.println(Thread.currentThread().getName()+"\t 收集到第："+tempInt+"颗龙珠");
            try{
                cyclicBarrier.await();
            }
            catch(InterruptedException e){e.printStackTrace();}
            catch (BrokenBarrierException e){e.printStackTrace();}
            },String.valueOf(i)).start();

        }
    }


}
