package com.haotian.haotianpoi;

import org.springframework.util.StringUtils;

/**
 * @CLassName BUSs
 * @Description: TODO
 * @date: 2021/1/22 10:10
 * @Version 1.0
 */
public class BUSs {
	public static void main(String[] args) {

		int [] ab={2,54,12,35,23,78,1};
		//冒泡排序
		String s=SeasonEnum.SPRING.getCode()+SeasonEnum.SPRING.getMessage();
		System.out.println(s);
//		bubleSort(ab);
		//选择排序
		selectSort(ab);
		for (int i : ab) {
			System.out.print(i+" ");
		}
		System.out.println(Math.pow(2,3));
		System.out.println(Math.round(3.4));
		System.out.println(Math.round(3.5));

	}

	private static void selectSort(int[] ab) {
		for(int i=0;i<ab.length-1;i++){
			for (int j=i+1;j<ab.length;j++){
				if(ab[i]>ab[j]){
					int tem=ab[i];
					ab[i]=ab[j];
					ab[j]=tem;
				}
			}
		}
	}

	private static void bubleSort(int[] ab) {
		for(int i=0;i<ab.length;i++){
			for(int j=0;j<ab.length-i-1;j++){

				if(ab[j]>ab[j+1]){
					int temp=ab[j];
					ab[j]=ab[j+1];
					ab[j+1]=temp;
				}
			}
		}
	}
}
