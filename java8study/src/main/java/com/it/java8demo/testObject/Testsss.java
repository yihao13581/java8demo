package com.it.java8demo.testObject;

import java.util.*;

/**
 * @CLassName Testsss
 * @Description: TODO
 * @date: 2021/1/6 10:23
 * @Version 1.0
 */
public class Testsss {
	public static void main(String[] args) {
		int [] s1=new int[]{7,12,5,6,33,21,65};
		int length=s1.length;
//		sortMaoPao(s1, length);
		for(int i=0;i<length;i++){
			for(int j=i+1;j<length;j++){
				if(s1[i]>s1[j]){
					int temp=s1[i];
					s1[i]=s1[j];
					s1[j]=temp;
				}
			}
		}
		for (int i1 : s1) {
			System.out.println(i1);
		}



//		list.add("ss");
//		if(list==null||!list.contains("ss")){
//			System.out.println("sss");
//		}
//		System.out.println("bubaohan");
	}

	private static void sortMaoPao(int[] s1, int length) {
		for(int i=0;i<length-1;i++){
			for(int j=0;j<length-i-1;j++){

				if(s1[j]>s1[j+1]){
					int temp=s1[j];
					s1[j]=s1[j+1];
					s1[j+1]=temp;

				}
			}
		}
	}


}
