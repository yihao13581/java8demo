package com.it.java8demo.sort;

public class MegreSort {
    public static void main(String[] args) {
        int[] nums = {1, 5,83,8,8,3, 30, 3, 55, 7};
        int length = nums.length;
        mergeSort1(nums,0,length-1);
        for (int num : nums) {
            System.out.println(num);
        }

    }
    //该函数将数组下标范围[l1,r1]和[l2,r2]的有序序列合并成一个有序序列
    public static void merge(int nums[],int l1,int r1,int l2,int r2){
        int i=l1;               //左半部分起始位置
        int j=l2;               //右半部分起始位置
        int n=(r1-l1+1)+(r2-l2+1); //要合并的元素
        int [] temp=new int[n];    //辅助数组
        int k=0;                   //辅助数组其起始位置
        while(i<=r1&&j<=r2){       //挑选两部分中最小的元素放入辅助数组中
            if(nums[i]<nums[j]){
                temp[k++]=nums[i++];
            }else temp[k++]=nums[j++];
        }
        //如果还有剩余，直接放入到辅助数组中
        while(i<=r1) temp[k++]=nums[i++];
        while (j <= r2) temp[k++] = nums[j++];
        //更新原始数组元素
        for (int l = 0; l <n; l++) {
            nums[l1+l]=temp[l];

        }
    }

    //二路归并排序（递归实现)
    public static void mergeSort(int nums[],int start,int end){
        if(start<end){
            int mid=(start+end)/2;            //分割序列
            mergeSort(nums,start,mid);       //对序列左半部分进行规并排序
            mergeSort(nums,mid+1,end); //对序列右半部分进行规并排序
            merge(nums,start,mid,mid+1,end);    //合并已经有序的两个序列
        }
    }
    /*二路归并排序（迭代实现）*/
    public static void mergeSort1(int nums[],int start,int end){
        int n=nums.length;
        if(start<end){
            //step为组内元素个数，step/2为左子区间元素个数
            for (int step = 2; step/2<n ; step*=2) {
                //每step个元素一组，组内前step/2和后step/2个元素进行合并
                for (int i = 0; i < n; i+=step) {
                    int mid=i+step/2-1;             //左子区间元素个数为step/2
                    if(mid+1<n)							//右子区间存在元素个数则合并
                        // 左子区间为[i,mid]，右子区间为[mid+1, min(i+step-1, n-1)]
                        merge(nums, i, mid, mid + 1, Math.min(i + step - 1, n-1));

                }

            }
        }
    }
}
