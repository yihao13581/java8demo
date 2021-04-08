package com.it.java8demo.mianshi.volatiledemo;



import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyData{
   volatile int  number=0;
    public void addTo60(){
        this.number=60;
    }
    //此时number添加了volatile关键字修饰，volatile不保证原子性
    public void  appPlusPlus(){
        number++;
    }

    AtomicInteger atomicInteger=new AtomicInteger();
    public void addMyAtomit(){
        atomicInteger.getAndIncrement();
    }
}

/**
 * 1、验证volatile的可见性
 * 1.1假如int number=0;number变量之前没有添加volatile关键子修饰      ---->没有可见性
 * 1.2假如int number=0;number变量添加volatile关键子修饰      ---->有可见性
 *
 * 2、验证volatile不保证原子性
 *  2.1原子性值得是什么意思？不可分割，完整性，也即某个线程正在做某个具体业务时，中间不可以被
 *  加塞或者被分割。需要整体完整要么同时成功，要么同时失败
 *  2.2volatile不保证原子性的案例演示
 *  2.3why？：数值少于2000，出现了丢失写值的情况(写覆盖纳秒级别)
 *
 *  2.4如何解决原子性？
 *      *加 sync
 *      *使用我们的JUC下的AtomicInteger
 */
public class VolatileDemo {
    public static void main(String[] args) {  //main是一切方法的运行入口
        MyData myData=new MyData();
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    myData.appPlusPlus();
                    myData.addMyAtomit();
                }
            },String.valueOf(i)).start();
        }
        //需要等待上面20个线程都全部计算完成后，再用main线程取得最终的结果值看是多少
        while(Thread.activeCount()>2){//默认２个线程：main线程、JVM的GC线
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+"\t int type, finally number value:"+myData.number);
        System.out.println(Thread.currentThread().getName()+"\t AtomicInteger type finally number value:"+myData.atomicInteger);

//        //等一会线程
//        try{TimeUnit.SECONDS.sleep(5);}catch (Exception e){e.printStackTrace();}


    }

    //可以保证可见性，及时通知其它线程，主物理内存的值已经被修改。
    private static void seeOkByVolatile() {
        MyData myData=new MyData();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t come in");
            //暂停一会线程
            try{ TimeUnit.SECONDS.sleep(3); }catch (Exception e){e.printStackTrace();}
            myData.addTo60();
            System.out.println(Thread.currentThread().getName()+"\t update number value:"+myData.number);
        },"AAA").start();

        //第二个线程就是我们的main线程
        while(myData.number==0){
            //main线程就一直在这里等待循环，知道number值不等于0
        }
        System.out.println(Thread.currentThread().getName()+"\t mission is over，main get number value:"+myData.number);
    }
}
