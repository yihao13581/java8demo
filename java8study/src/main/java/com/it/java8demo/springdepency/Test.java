package com.it.java8demo.springdepency;

public class Test {
    public static void main(String[] args) {
//        //创建A
//        ClassA classA=new ClassA();
//        //创建B
//        ClassB classB = new ClassB();
//
//        System.out.println(classA);
//        System.out.println(classB);

        //创建A
        Class classA=ClassA.class;
        //创建B
        Class classB = ClassB.class;

        System.out.println(classA);
        System.out.println(classB);


    }
}
