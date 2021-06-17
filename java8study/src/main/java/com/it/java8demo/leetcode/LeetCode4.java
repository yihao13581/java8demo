package com.it.java8demo.leetcode;

/**4、寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 *
 * 示例 2：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 *
 * 示例 3：
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 *
 * 示例 4：
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 *
 * 示例 5：
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode4 {
    public static void main(String[] args) {
        int[] nums1={1,3};
        int[] nums2={2};
        findMedianSortedArrays(nums1,nums2);


    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int leftSize=nums1.length;
        int rightSize=nums2.length;
        int n=leftSize+rightSize;
        int[] temp = new int[n];
        int k=0;
        int i=0,r1=leftSize-1;
        int j=0,r2=rightSize-1;
        while(i<=r1&&j<=r2){
            if(nums1[i]<nums2[j]) temp[k++]=nums1[i++];
            else temp[k++]=nums2[j++];
        }
        while(i<=r1) temp[k++]=nums1[i++];
        while(j<=r2) temp[k++]=nums2[j++];

        if(n%2==0){
            return (temp[n/2-1]+temp[n/2])/(double)2;
        }else{
            return (temp[n/2])/(double)1;
        }
    }

}
