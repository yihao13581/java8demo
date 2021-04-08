package com.it.java8demo.mianshi.reference;

import java.lang.ref.WeakReference;

/**
 * 是需要用java.lang.ref.WeakReference类来实现，它比软引用的生存周期更短，对于只有弱引用的对象来说，
 * 只要垃圾回收机制一运行，不管JVM的内存空间是否足够，都会回收该对象占用的内存。
 */
public class WeakReferenceDomo {
    public static void main(String[] args) {
        Object o1=new Object();
        WeakReference<Object> weakReference=new WeakReference<>(o1);
        System.out.println(o1);
        System.out.println(weakReference.get());

        o1=null;
        System.gc();
        System.out.println("===========");

        System.out.println(o1);
        System.out.println(weakReference.get());
    }
}
