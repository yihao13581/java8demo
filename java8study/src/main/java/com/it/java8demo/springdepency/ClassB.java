package com.it.java8demo.springdepency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class ClassB{
//    //依赖ClassA
//    private ClassA classA;
//    @Autowired
//    public void setClassA(ClassA classA){
//        this.classA=classA;
//    }

    //依赖ClassA
    private ClassA classA;
    @Autowired
    @Lazy
    public ClassB(ClassA classA){
        this.classA=classA;
    }
}
