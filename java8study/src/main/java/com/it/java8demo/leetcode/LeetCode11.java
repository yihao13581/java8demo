package com.it.java8demo.leetcode;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * 11、盛最多水的容器
 *
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器。
 *
 *
 *
 * 示例 1：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * 示例 2：
 * 输入：height = [1,1]
 * 输出：1
 *
 * 示例 3：
 * 输入：height = [4,3,2,1,4]
 * 输出：16
 *
 * 示例 4：
 * 输入：height = [1,2,1]
 * 输出：2
 */
public class LeetCode11 {
    public static void main(String [] args){

    }

    /**
     * 本题是一道经典的面试题，最优的做法是使用「双指针」。
     *
     * [1, 8, 6, 2, 5, 4, 8, 3, 7]
     *  ^                       ^
     *
     * 在初始时，左右指针分别指向数组的左右两端，它们可以容纳的水量为 min(1,7)∗8=8。
     * 此时我们需要移动一个指针。移动哪一个呢？直觉告诉我们，应该移动对应数字较小的那个指针（即此时的左指针）。这是因为，由于容纳的水量是由
     *                  两个指针指向的数字中较小值∗指针之间的距离
     * 决定的。如果我们移动数字较大的那个指针，那么前者「两个指针指向的数字中较小值」不会增加，后者「指针之间的距离」会减小，那么这个乘积会减小。
     * 因此，我们移动数字较大的那个指针是不合理的。因此，我们移动 数字较小的那个指针。
     * @param height
     * @return
     */
    public  int maxArea(int[] height){
       int l=0 ,r=height.length-1;
        int ans=0;
       while(l<r){
           int area=Math.min(height[l],height[r])*(r-l);
           ans=Math.max(area,ans);
           if(height[l]<height[r]) l++;
           else r--;
       }
        return ans;
    }
}
