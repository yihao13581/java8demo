package com.it.java8demo.mianshi.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Phone implements Runnable{
    public synchronized void sendSMS()throws Exception{
        System.out.println(Thread.currentThread().getName()+"\t invoked sendMSG()");
        sendEmail();
    }
    public synchronized void sendEmail()throws Exception{
        System.out.println(Thread.currentThread().getName()+"\t #########invoked sendEmail()");
    }

    Lock lock=new ReentrantLock();
    @Override
    public void run() {
        get();
    }
    public void get(){
        lock.lock();
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t invoked get(）");
            set();
        }
        finally{
            lock.unlock();
            lock.unlock();
        }
    }
    public void set(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t ########invoked set(）");
        }
        finally{
            lock.unlock();
        }
    }
}
/**
 * 可重入锁（递归锁）
 * 指的是同一线程外层函数获得锁之后，内层递归函数仍然能获取该锁的代码，
 * 在同一个线程在外层方法获取锁的时候，在进入内层方法会自动获取锁。
 *
 * 也就是说，线程可以进入任何一个它已经拥有锁所同步着的代码块。
 *
 * synchronized 可重入锁（递归锁）
 * t1	 invoked sendMSG()              t1线程在外层方法获取锁得同时
 * t1	 #########invoked sendEmail()   t1在进入内层方法会自动获取锁
 * t2	 invoked sendMSG()
 * t2	 #########invoked sendEmail()
 *
 * case two
 * ReentrantLock就是一个典型的可重入锁
 *
 * t3	 invoked get(）
 * t3	 ########invoked set(）
 * t4	 invoked get(）
 * t4	 ########invoked set(）
 *
 */
public class ReenterLockDemo {
    public static void main(String[] args) {
        Phone phone=new Phone();
        new Thread(()->
        {
            try{
                phone.sendSMS();
            }
            catch(Exception e){e.printStackTrace();}
            finally{}
        },"t1").start();

        new Thread(()->
        {
            try{
                phone.sendSMS();
            }
            catch(Exception e){e.printStackTrace();}
            finally{}
        },"t2").start();

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        Thread t3=new Thread(phone,"t3");
        Thread t4=new Thread(phone,"t4");
        t3.start();
        t4.start();
    }
}
