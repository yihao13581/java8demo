package com.it.java8demo.distributed.t0401;

import org.I0Itec.zkclient.IZkDataListener;

import java.util.concurrent.CountDownLatch;

public class ZkDistributedLock extends ZkAbstractTemplateLock {
    @Override
    public boolean tryZklock() {
        try {
            zkClient.createEphemeral(path);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void waitZkLock() {
        IZkDataListener iZkDataListener=new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {

            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                if(countDownLatch!=null){
                    countDownLatch.countDown();
                }

            }
        };
        zkClient.subscribeDataChanges(path,iZkDataListener);
        if(zkClient.exists(path)){
            //只能等着，不能往下走
            countDownLatch=new CountDownLatch(1);
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        zkClient.unsubscribeDataChanges(path,iZkDataListener);

    }
}
