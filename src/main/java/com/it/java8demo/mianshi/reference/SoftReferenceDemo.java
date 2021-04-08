package com.it.java8demo.mianshi.reference;

import java.lang.ref.SoftReference;

/**
 * 软引用：
 *        是一种相对强引用弱化了一些的引用。需要用java.lang.SoftReference类来实现，可以让对对象豁免一些垃圾收集。
 *        对于只有软引用的对象来说： 当系统内存充足时它 不会被回收，当系统内存不足时 它会被回收。
 *        软引用通常在内存敏感的程序中，比如高速缓存就有用到软引用，内存够用时就保留，不够就回收。
 */

public class SoftReferenceDemo {
    /**
     * 内存够用时就保留，不够就回收。
     */
    public static void softRef_Memory_Enough() {
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;
        System.gc();
        System.out.println(o1);
        System.out.println(softReference.get());
    }

    /**
     * JVM配置，故意产生大对象并配置小的内存，让它内存不够用了导致OOM，看软引用的回收情况
     * -Xms5m -Xmx5m -XX:+PrintGCDetails
     */
    public static void softRef_Memory_NotEnough() {
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;
        try {
            byte [] bytes=new byte[30*1024*1024];
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            System.out.println(o1);
            System.out.println(softReference.get());
        }
    }


    public static void main(String[] args) {
//        softRef_Memory_Enough();
        softRef_Memory_NotEnough();
    }
}
