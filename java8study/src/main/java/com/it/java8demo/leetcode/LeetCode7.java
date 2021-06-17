package com.it.java8demo.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 7整数反转
 * <p>
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 * 输入：x = 0
 * 输出：0
 */
public class LeetCode7 {
    public static int reverse(int x) {
        String s1 = x + "";
        String s2 = new StringBuffer(s1).reverse().toString();
        try {
            if (s1.contains("-")) {
                s1 = s2.substring(0, s1.length() - 1);

                return Integer.parseInt("-" + s1);
            }
            return Integer.parseInt(s2);
        } catch (NumberFormatException e) {
            return 0;
        }

    }
    public int reverse2(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }


    public static void main(String[] args) {
        HashMap map=new HashMap();
        int x = -123;
        System.out.println(reverse(x));
        int y = 123;
        System.out.println(reverse(y));
        List<String> list1=new ArrayList<>();
        list1.add("java");
        list1.add("good");
        list1.add("hello");
        Collections.reverse(list1);
        System.out.println(list1.toString());
    }
}
