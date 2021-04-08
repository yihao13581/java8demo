package com.it.java8demo.distributed.common;

import com.it.java8demo.distributed.lock.OrderNumCreateUtil;
import com.it.java8demo.distributed.t0401.ZKLock;
import com.it.java8demo.distributed.t0401.ZkDistributedLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OrderService {
    private OrderNumCreateUtil orderNumCreateUtil = new OrderNumCreateUtil();
    private ZKLock zkLock=new ZkDistributedLock();

    public void getOrdNumber() {
        zkLock.zkLock();
        try {
            System.out.println("获得编号------>:" + orderNumCreateUtil.getOrdNumber());
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            zkLock.zkUnlock();
        }
    }

//    private Lock lock = new ReentrantLock();
//
//    public String getOrdNumber() {
//        lock.lock();
//        try {
//            return orderNumCreateUtil.getOrdNumber();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally{
//            lock.unlock();
//        }
//        return "";
//    }
}
