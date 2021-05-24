package com.it.java8demo.mianshi.thread;

import java.util.concurrent.*;


class MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"********** come in callable");
        try{
            TimeUnit.SECONDS.sleep(2);
        }catch(InterruptedException e){e.printStackTrace();}
        return 1024;
    }
}

/**
 * 多线程中，三种获得多线程的方式
 * 1、extends Thread类
 * 2、实现Runnable接口
 * 3、实现Callable接口,会抛异常，带有返回值
 */
public class CallableDemo{
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //FutureTask(Callable<V> callable)
        FutureTask<Integer> futureTask=new FutureTask<>(new MyThread());
        new Thread(futureTask,"AA").start();
//        new Thread(futureTask,"BB").start();
//        int result02=futureTask.get();
        System.out.println(Thread.currentThread().getName()+"*******");
        int result01=100;
//        while(!futureTask.isDone()){
//
//        }
        int result02=futureTask.get();//建议放在最后,要求获取callable线程的计算结果，如果没有计算完成就要去强求，会导致阻塞，值得计算完成
        System.out.println("*******result:"+(result01+result02));
    }

}
