package com.it.java8demo.javabase;

import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

public class ArraysTest {
    public static void main(String[] args) {
//        int [] arr={23,1,45,21,67,32,36,2,7,9};
//        System.out.println(Arrays.toString(arr));
//        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.binarySearch(arr,67));
//        Integer.valueOf("22");
//        System.out.println(  Integer.parseInt("22"));


        /**
         * 常用进制转换
         */
        System.out.println(Integer.toBinaryString(10));
        System.out.println(Integer.toOctalString(10));
        System.out.println(Integer.toHexString(10));
        //10进制到其它进制(radix)
        System.out.println(Integer.toString(10,2));
        //其它进制到十进制
        System.out.println(Integer.parseInt("1010",2));
        System.out.println(Character.isDigit('3'));
    }
}
