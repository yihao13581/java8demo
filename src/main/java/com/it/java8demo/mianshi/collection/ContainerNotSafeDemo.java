package com.it.java8demo.mianshi.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 集合类不安全的问题
 * ArrayList
 * HashSet
 */
public class ContainerNotSafeDemo {
    public static void main(String[] args) {
//        Map<String,String> map= new HashMap<>();//ConCurrentModificationException
//        Map<String,String> map= Collections.synchronizedMap(new HashMap<>());//解决方式1
        Map<String,String> map= new ConcurrentHashMap<>();//解决方式2

        for (int i = 0; i <30; i++) {
            new Thread(()->{
                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            },String.valueOf(i)).start();
        }

    }

    private static void setNotSafe() {
//        Set<String> set=new HashSet<>();//有异常情况 ConcurrentModificationException
//        Set<String> set=Collections.synchronizedSet(new HashSet<>());//解决方式1
        Set<String> set= new CopyOnWriteArraySet();//解决方式2,底层用的还是CopyOnWriteArrayList
//        List<String> list=new Vector<>();
        for (int i = 0; i <30; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }

    private static void listNotSafe() {
        //        List<String> list= Arrays.asList("a","b","c");
//        list.stream().forEach(System.out::println);
//        List<String> list=new ArrayList<>();
//        List<String> list=Collections.synchronizedList(new ArrayList<>());
        List<String> list=new CopyOnWriteArrayList<>();
//        List<String> list=new Vector<>();
        for (int i = 0; i <30; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
        //java.util.ConcurrentModificationException   并发修改异常
        /**
         * ArrayList线程不安全
         * 1 故障现象
         *      java.util.ConcurrentModificationException
         *
         * 2 导致原因：
         *      并发争抢修改导致，参考：花名册签名情况，一个人正在写入，另一个同学过来抢夺导致数据不一致异常，数据并发修改异常
         *
         * 3 解决方案
         *    3.1 new Vector<>();   Vector是ArrayList的前生
         *    3.2 Collections.synchronizedList(new ArrayList());
         *    3.3 new CopyOnWriteArrayList();  写时复制技术
         *
         * 4优化建议（同样的错误不犯第二次）
         *
         */
        /**
         * 写时复制
         * CopyOnWrite容器即写时复制容器，让一个容器添加元素的时候，不能直接往当前容器Object[] 添加，而是先将容器Object【】进行copy，
         * 复制出一个新的容器Object[] newElements,然后往新的容器Object[] newElements里卖弄添加元素，添加完元素后，
         * 再将原容器的引用指向新的容器setArray(newElements);这样的好处是可以对CopyOnWrite容器进行并发的读，
         * 而不需要加锁，因为当前容器不会添加任何元素，所有CopyOnWrite容器也是一种读写分离思想，读写不同的容器。
         *  public boolean add(E e){
         *             final ReentrantLock lock=this.Lock;
         *             lock.lock();
         *             try {
         *                 Object[] elements=getArray();
         *                 int len=elements.length;
         *                 Object[] newElements=Arrays.copyOf(elements,len+1);
         *                 newElements[len]=e;
         *                 setArray(newElements);
         *                 return true;
         *             }catch (Exception e){e.printStackTrace();}
         *             finally{
         *                 lock.unlock();
         *             }
         *         }
         */

    }
}
