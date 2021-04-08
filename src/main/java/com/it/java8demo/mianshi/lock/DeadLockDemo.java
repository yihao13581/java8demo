package com.it.java8demo.mianshi.lock;

import java.util.concurrent.TimeUnit;

class HoldLockThread implements  Runnable{
    private String lockA;
    private String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized(lockA)
        {
            System.out.println(Thread.currentThread().getName()+"\t自己持有："+lockA+"\t 尝试获得"+lockB);
             try{ TimeUnit.SECONDS.sleep(2);}catch (InterruptedException e){ e.printStackTrace(); }
             synchronized (lockB){
                 System.out.println(Thread.currentThread().getName()+"\t自己持有："+lockB+"\t 尝试获得"+lockA);
             }
        }
    }
}
/**
 * 死锁是指两个或两个以上的线程在执行过程中，因为争夺资源而造成的一种互相等待的现象，若无外力干涉那他们将无法推进下去。
 * 产生死锁的原因: 1、系统资源不足；
 *              2、进程运行推进的顺序不合适，
 *              3、资源分配不当。
 *
 * 线程A持有锁A试图获取锁B，
 * 线程B持有锁B试图获取锁A，将死锁了。
 *
 *
 * 解决死锁：
 *      jps
 *      linux  查看进程命令   ps -ef|grep xxxx           ls -l
 *      windows下的Java运行程序也有类似查看进程的命令，但是目前我们需要查看的只是Java
 *                          jps  =java ps     -l         cl命令定位进程号
 *                          jstack 进程号                   jstack 27760找到死锁查看
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA="lockA";
        String lockB="lockB";
        new Thread(new HoldLockThread(lockA,lockB),"ThreadAAA").start();
        new Thread(new HoldLockThread(lockB,lockA),"ThreadBBB").start();
    }
}
