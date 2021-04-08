package com.it.java8demo.distributed.t0401;

import org.I0Itec.zkclient.ZkClient;

import java.util.concurrent.CountDownLatch;

public abstract  class ZkAbstractTemplateLock implements ZKLock {
    public static final String ZKSERVER="192.168.13.128:2181";
    public static final int TIME_OUT=40*1000;
    ZkClient zkClient=new ZkClient(ZKSERVER,TIME_OUT);
    protected  String path="/zklock0401";
    protected CountDownLatch countDownLatch=null;
    @Override
    public void zkLock() {
        if(tryZklock()){
            System.out.println(Thread.currentThread().getName()+"\t 占用锁成功");
        }else{
            waitZkLock();
            //递归强锁
            zkLock();
        }
    }

    public abstract boolean tryZklock();
    public abstract void waitZkLock();

    @Override
    public void zkUnlock() {
        if(zkClient!=null){
            zkClient.close();
        }
        System.out.println(Thread.currentThread().getName()+"\t 释放锁成功");
        System.out.println();
        System.out.println();

    }
}
