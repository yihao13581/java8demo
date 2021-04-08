package com.it.java8demo.mianshi.gc;

/**
 * jps -l  查看运行中的线程，获取进程编号
 * jinfo -flag MetaspaceSize 进程编号     查看JVN参数信息
 * jinfo -flags 进程编号          查看目前能搜索的全部参数
 *jinfo -flags 23212
 *
 *C:\Users\admin>jps -l
 * 13120
 * 25424 sun.tools.jps.Jps
 * 4400 com.it.java8demo.mianshi.gc.HelloGC
 * 7496
 * 16492 org.jetbrains.jps.cmdline.Launcher
 *
 * C:\Users\admin>jinfo -flag MetaspaceSize 4400
 * -XX:MetaspaceSize=21807104
 *
 *
 */
public class HelloGC {
    public static void main(String[] args) throws Exception{
        System.out.println("*******HelloGC");
//        byte [] b1=new byte[20*1024*1024];
//        long totalMemory=Runtime.getRuntime().totalMemory();//返回Java虚拟机的内存容量（初始话堆内存）默认1/64
//        long maxMemory=Runtime.getRuntime().maxMemory();//返回java虚拟机试图使用的最大内存量（堆内存） 默认1/4
//        System.out.println("TOTAL_MEMORY(-Xms)="+totalMemory+"字节、"+(totalMemory/(double)1024/1024)+"MB");//InitialHeapSize=运行内存的1/64
//        System.out.println("MAX_MEMORY(-Xmx)="+maxMemory+"字节、"+(maxMemory/(double)1024/1024)+"MB");//MaxHeapSize=运行内存/4

//        Thread.sleep(Integer.MAX_VALUE);
    }
    /**
     * -Xms128m -Xmx4096m -Xss1024k -XX:MetaspaceSize=512m -XX:+PrintCommandLineFlags -XX:+PrintGCDetails -XX:+UseSerialGC
     */
}
