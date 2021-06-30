package com.it.java8demo.sort;

public class SortDemo {
    public static void main(String[] args) {
        int[] nums = {1, 5,83,8,8,3, 30, 3, 55, 7};
        int length = nums.length;
//        maopao(nums, length);
//        selector(nums, length);
//        insert(nums, length);
//        bucketSort(nums);
        quickSort(nums, 0, length - 1);


        for (int num : nums) {
            System.out.println(num);
        }

    }

    /**
     * 归并排序（MERGE-SORT）：分治法
     *          是建立在归并操作上的一种有效的排序算法,该算法是采用分治法的一个非常典型的应用。
     * 将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。
     * 若将两个有序表合并成一个有序表，称为二路归并。
     */


    /**
     * 快速排序的基本思想是：基于二分的思想，通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，
     * 然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。
     * 主要是选择基准数----使序列中一部分比基准数大，一部分比基准数小的实现：
     */
    public static void quickSort(int[] arr, int low, int high) {
        int i, j, temp, t;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        //temp就是基准位
        temp = arr[low];
        while (i < j) {
            //先看右边，哨兵j向左依次递减知道找到小于基准的数的索引
            while (arr[j] >= temp && i < j) {
                j--;
            }
            //先看右边，哨兵j向左依次递减知道找到小于基准的数的索引
            while (arr[i] <= temp && i < j) {
                i++;
            }
            //如果满足条件则交换
            if (i < j) {
                t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        //最后将基准为与i和j相等位置的数字交换,即i，j相遇的位置
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j - 1);
        //递归调用右半数组
        quickSort(arr, j + 1, high);


    }

    /**
     * 简单桶排序：
     * 桶排序(Bucket Sort)的原理很简单，它是将数组分到有限数量的桶子里；
     * 时间复杂度为0(m+n)(m为桶的个数，n为待排序数的个数）
     *
     * @param nums
     */
    private static void bucketSort(int[] nums) {
        int[] a = new int[1024];
        for (int num : nums) {
            a[num]++;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                System.out.println(i);
            }
        }
    }

    /**
     * 插入排序：
     *
     * 插入排序原理很简单，将一组数据分成两组，我分别将其称为有序组与待插入组。每次从待插入组中取出一个元素，与有序组的元素进行比较，
     * 并找到合适的位置，将该元素插到有序组当中。就这样，每次插入一个元素，有序组增加，待插入组减少。直到待插入组元素个数为0。当然，
     * 插入过程中涉及到了元素的移动。
     * 为了排序方便，我们一般将数据第一个元素视为有序组，其他均为待插入组。
     *
     * @param nums
     * @param length
     */
    private static void insert(int[] nums, int length) {
        for (int i = 1; i < length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    /**
     * 选择排序：
     * 原理：排序的基本思想：首先在未排序的序列里找到最小(大)元素，放到序列的首端，再从剩余元素中找到最小(大)的元素，
     * 放到剩余元素序列的首端。依次循环，直到排序完成。
     *
     * @param nums
     * @param length
     */
    private static void selector(int[] nums, int length) {
        //选择排序
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }

        }
    }

    /**
     * 冒泡排序：
     * 原理：比较相邻的前后两个数据，如果前面的数据大于后面的数据，就将两个数据交换。执行到最后的元素便为最大元素
     *
     * @param nums
     * @param length
     */
    private static void maopao(int[] nums, int length) {
        //冒泡排序
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }
}
