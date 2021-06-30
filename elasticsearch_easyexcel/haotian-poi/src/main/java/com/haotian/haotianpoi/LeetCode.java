package com.haotian.haotianpoi;

import org.apache.tomcat.util.buf.StringUtils;

/**
 * @CLassName LeetCode
 * @Description: TODO
 * @date: 2021/2/8 16:23
 * @Version 1.0
 */
public class LeetCode {
	public static void main(String[] args) {
		int [] nums={2,7,11,15};
		int target=9;
		int[]a=twoSum(nums,target);
		for (int i : a) {
			System.out.println(i);
		}
	}

	public static int[] twoSum(int[] nums, int target) {
		int[] indexs = new int[2];



		// 双重循环 循环极限为(n^2-n)/2
		for(int i = 0; i < nums.length; i++){
			for(int j = nums.length - 1; j > i; j --){
				if(nums[i]+nums[j] == target){
					indexs[0] = i;
					indexs[1] = j;
					return indexs;
				}
			}
		}
		return indexs;
	}
}
