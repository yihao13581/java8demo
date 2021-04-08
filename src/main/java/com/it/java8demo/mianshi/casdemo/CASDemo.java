package com.it.java8demo.mianshi.casdemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS是什么？ ===》compareAndSet
 * 比较并交换
 *
 *
 *
 * AtomicInteger
 * CAS-->Unsafe-->CAS底层原理-->ABA-->原子引用更新-->如何规避ABA问题
 *   *ABA：狸猫换太子
 *   如何解决ABA问题？？？ 理解原子引用+新增一种机制，那就是修改版本号（类似时间戳）
 *
 *   T1  100 1       2019 2
 *   T2  100 1 101 2 100 3
 */
public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger=new AtomicInteger(5);
        //main do thing ......
        System.out.println( atomicInteger.compareAndSet(5,2019)+"\t current data:"+atomicInteger.get());
        System.out.println( atomicInteger.compareAndSet(5,1024)+"\t current data:"+atomicInteger.get());
    }

//    public final int getAndIncrement(){
//        return unsafe.getAndAddInt(this,valueoffset,1);
//    }
//    //unsafe.getAndAddInt
//    public final int getAndAddInt(Object var1,long var2,int var4){
//        int var5;
//        do{
//            var5=this.getIntVolatile(var1,var2);
//        }while(!this.compareAndSwapInt(var1,var2,var5,var5+var4));
//        return var5;
//    }
    //var1 AtomicInteger对象本身，var2该对象值的引用地址，var4需要变动的数量。var5是用var1 var2找出的主内存中真实的值，用与该对象当前的值与var5比较
    //如果相同，更新var5+var4并且返回true。如果不同，继续取值然后再比较，直到更新完成。
}
