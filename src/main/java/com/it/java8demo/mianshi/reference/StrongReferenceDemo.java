package com.it.java8demo.mianshi.reference;

/**
 * 强引用： 当内存不足，JVM开始垃圾回收，对于强引用的对象，就算出现了OOM也不会对该对象进行回收，死都不回收。
 *        强引用时最常见的普通对象引用，只要还有强引用指向一个对象，就能表明对象还“活着”，垃圾回收器就不会碰这种对象。
 *        JAVA中最常见的就是强引用，把一个对象赋给一个引用变量，这个对象就是强引用。当一个对象被强引用变量引用时，
 *      它就处于可达状态，它是不可能被垃圾回收机制回收的，即使该对象以后永远都不会被用到JVM也不会回收。因此强引用是造成JAVA内存泄漏的主要原因。　　　　　
 *      对于一个普通对象，如果没有其它的引用关系，只要超过了引用的作用域或者显式地讲相应地强引用赋值为null，
 *      一般认为就是可以被垃圾收集的了（具体回收时机要看垃圾收集策略）。
 */
public class StrongReferenceDemo {

    public static void main(String[] args) {
        Object obj1=new Object();//这样的定义默认就是强引用
        Object obj2=obj1;//obj2引用赋值
        obj1=null;//置空
        System.gc();
        System.out.println(obj2);
    }
}
