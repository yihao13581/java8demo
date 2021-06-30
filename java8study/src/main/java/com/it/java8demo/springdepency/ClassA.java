package com.it.java8demo.springdepency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class ClassA{

//    //依赖ClassB
//    private ClassB classB;
//    @Autowired
//    public void setClassB(ClassB classB){
//        this.classB=classB;
//    }


    //依赖ClassB
    private ClassB classB;
    @Autowired
    @Lazy
    public ClassA(ClassB classB){
        this.classB=classB;
    }

}