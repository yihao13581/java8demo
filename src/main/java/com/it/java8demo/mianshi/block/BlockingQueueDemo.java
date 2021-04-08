package com.it.java8demo.mianshi.block;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * ArrayBlockingQueue:是一个基于数组结构的有界阻塞队列，此队列按FIFO（先进先出）原则对元素进行排序
 * LinkedBlockingQueue:一个基于链表结构的阻塞队列，此队列按FIFO（先进先出）排序元素，吞吐量通常要高于ArrayBlockingQueue.
 * SynchronousQueue:一个不存储元素的阻塞队列,也即单个元素的队列（专属定制版，生产一个用一个，再用再生产）。每个插入操作必须等到另一个线程调用移除操作，否则插入操作一直处于阻塞状态，吞吐量通常要高于
 *
 *
 * 使用较少
 * PriorityBlockingQueue：支持优先级排序的误解阻塞队列
 * DealauQueue            使用优先级队列实现的延迟误解阻塞队列
 * LinkedTransfersQueue   由链表结构组成的无界阻塞队列
 * LinkedBlockingDeque    由链表结构组成的双向阻塞队列
 *
 * 1  队列
 *
 * 2  阻塞队列；当阻塞队列是空的时候，从队列中获取元素的操作会被阻塞；当阻塞队列是满的时候，往队列中添加元素的操作会被阻塞；
 *      2.1阻塞队列有没有好的一面
 *
 *      2.2不得不阻塞，你如何管理
 *
 *
 *      BlockingQueue的核心方法
 *      方法类型            抛出异常           特殊值            阻塞           超时
 *      插入              add(e)            offer(e)          put(e)      offer（e,time,unit）
 *      移除              remove()          poll()            take()      poll(time,unit)
 *      检查              element()         peek()            不可用       不可用
 *
 *   抛出异常 ：当阻塞队列满时，再往队列里add插入元素会抛IllegalStateException：Queue full ;
 *            当阻塞队列为空时，再往队列里remove移除元素会抛NoSuchElementException.
 *   特殊值：   插入方法,成功返回true 失败返回false；移除方法,成功返回元素,队列里面没有就返回null
 *
 *   阻塞 ：   一直阻塞：当阻塞队列满时,生产者继续往队列里面put元素,队列会一直阻塞直到put数据or响应中断退出 ；
 *            当阻塞队列空时,消费者试图从队列take元素,队列会一直阻塞消费者线程直到队列可用.
 *
 *   超时退出： 当阻塞队列满时,队列会阻塞生产者线程一定时间,超过后限时后生产者线程就会退出
 */

public class BlockingQueueDemo {
    public static void main(String[] args) throws Exception{
//        List list=new ArrayList();
        BlockingQueue<String> blockingQueue=new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        System.out.println(blockingQueue.element());

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());

    }

}
