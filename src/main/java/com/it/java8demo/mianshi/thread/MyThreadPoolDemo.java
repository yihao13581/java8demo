package com.it.java8demo.mianshi.thread;

import java.util.concurrent.*;

/**
 * 第4种获得使用Java多线程的方式，线程池
 *
 *   public static ExecutorService newFixedThreadPool(int nThreads) {
 *         return new ThreadPoolExecutor(nThreads, nThreads,
 *                                       0L, TimeUnit.MILLISECONDS,
 *                                       new LinkedBlockingQueue<Runnable>());
 *     }
 *
 *    public static ExecutorService newSingleThreadExecutor() {
 *         return new FinalizableDelegatedExecutorService
 *             (new ThreadPoolExecutor(1, 1,
 *                                     0L, TimeUnit.MILLISECONDS,
 *                                     new LinkedBlockingQueue<Runnable>()));
 *     }
 *
 *    public static ExecutorService newCachedThreadPool() {
 *         return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
 *                                       60L, TimeUnit.SECONDS,
 *                                       new SynchronousQueue<Runnable>());
 *     }
 *
 *
 * 线程池的7大重要参数   ThreadPoolExecutor
 *    1、corePoolSize:  线程池中的常驻核心线程数
 *    2、maximumPoolSize:线程池能够容纳同时执行的最大线程数，此值必须大于等于1
 *    3、keepAlive:  多余的空闲线程的存活时间。当前线程池数量超过corePoolSize时，当空闲时间达到keepAlive值时，多余空闲线程会被销毁直到只剩下corePoolSize个线程为止
 *    4、unit:      keepAlive的单位
 *    5、workQueue:   任务队列，被提交但尚未被执行的任务（阻塞队列）
 *    6、threadFactory: 表示生成线程池中工作线程的线程工厂，用于创建线程一般默认的即可
 *    7、handler:   拒绝策略，表示当队列满了并且工作线程大于等于线程池的最大线程数（maximumPoolSize）时如何来拒绝请求执行的Runnable的策略
 *
 * 线程池的拒绝策略：
 *      1、AbortPolicy（）：直接抛出RejectedExecutionException异常阻止系统正常运行。
 *      2、CallerRunsPolicy():"调用者运行"一种调节，该策略既不会抛弃任务也不会抛出异常，而是将某些任务回退给调用者，从而降低新任务的流量。
 *      3、DiscardOldestPolicy():抛弃队列中等待最久的任务,然后把当前任务加入队列中尝试再次提交
 *      4、DiscardPolicy():直接丢弃任务，不予任何处理也不抛出异常。如果允许任务丢失，这是最好的一种方案。
 *
 *
 * 线程池配置合理的线程数；
 *    1、CPU密集型： 该任务需要大量的计算，而没有阻塞，CPU一直运行，该CPU密集型任务只有在真正多核CPU上才能得到加速（通过多线程）
 *                  CPU密集型任务配置尽可能少的线程数量
 *                  一般公式：CPU核数+1个线程的线程池
 *       获取CPU内核数代码   ；       Runtime.getRuntime().availableProcessors();
 *    2、IO密集型：
 *          1、由于IO密集型任务线程并不是一直在执行任务，则配置尽可能多的线程，如CPU核数X2
 *          2、IO密集型，即该任务需要大量地IO，即大量的阻塞。   在单线程上运行IO密集型的任务会导致浪费大量的CPU运算能力浪费在等待。所有
 *          在IO密集型任务中使用多线程可以大大加速程序的运行，即便在单核CPU上，这种加速主要就是利用了被浪费的阻塞时间。
 *
 *          IO密集型时，大部分线程阻塞，故需多配置线程数
 *          参考公式：CPU核数／（1－阻塞系数）　　　　　　阻塞系数在0.8－0.9之间
 *          比如8核CPU： 8/（1-0.9）=80个线程数
 *
 *
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());//查看CPU数量
       ExecutorService threadPool=new ThreadPoolExecutor(2,5,1L,TimeUnit.SECONDS
               ,new LinkedBlockingQueue<Runnable>(3),Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        //模拟10个用户来办理业务，每个用户就是一个来自外部的请求线程
        try {
            for (int i = 1; i <=10; i++) {
                threadPool.submit(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
                //暂停一会线程
//                try{ TimeUnit.MILLISECONDS.sleep(300);}catch (InterruptedException e){ e.printStackTrace(); }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }

    private static void threadPoolInit() {
        //        System.out.println(Runtime.getRuntime().availableProcessors());//查看CPU的数量
        //Array Arrays
        //Collection Collections
        //Executor Executors  辅助工具类

//        ExecutorService threadPool = Executors.newFixedThreadPool(5);//一池5个处理线程，，，固定的线程池
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();//一池1个处理线程  。。。单一的线程池
        ExecutorService threadPool = Executors.newCachedThreadPool();//一池N个处理线程   。。。   带缓存扩容的线程池
        //模拟10个用户来办理业务，每个用户就是一个来自外部的请求线程
        try {
            for (int i = 1; i <=10; i++) {
                threadPool.submit(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
                //暂停一会线程
//                try{ TimeUnit.MILLISECONDS.sleep(300);}catch (InterruptedException e){ e.printStackTrace(); }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
