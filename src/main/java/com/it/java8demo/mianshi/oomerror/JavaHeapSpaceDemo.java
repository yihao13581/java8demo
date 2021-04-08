package com.it.java8demo.mianshi.oomerror;

import java.util.Random;

public class JavaHeapSpaceDemo {
    public static void main(String[] args) {
//        String str="atguigu";
//        while(true){
//            str+=str+new Random().nextInt(11111111)+new Random().nextInt(2222222);
//            str.intern();
//        }

        byte [] bytes=new byte[80*1024*1024];
        //Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    }
}
