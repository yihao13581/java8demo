package com.it.java8demo.leetcode;

/**
 * 回文数
 *
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *
 *
 *
 * 示例 1：
 *
 * 输入：x = 121
 * 输出：true
 *
 * 示例 2：
 *
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * 示例 3：
 *
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 *
 * 示例 4：
 *
 * 输入：x = -101
 * 输出：false
 */
public class LeetCode9 {
    public static  void main(String [] args){
        int x=121;
        System.out.println(isPalindrome(x));
    }

    public static boolean isPalindrome(int x){
        String str=x+"";
        if(str.length()==1) return true;
        int length=str.length();
        int i=0,j=length-1;
        while(i<j)
        {
            if(str.charAt(i)==str.charAt(j)){
                i++;
                j--;
            }else {
                return  false;
            }
        }
        return true;
    }

    /**
     * 第二个想法是将数字本身反转，然后将反转后的数字与原始数字进行比较，如果它们是相同的，那么这个数字就是回文。
     * 但是，如果反转后的数字大于 int.MAX\text{int.MAX}int.MAX，我们将遇到整数溢出问题。
     *
     * 按照第二个想法，为了避免数字反转可能导致的溢出问题，为什么不考虑只反转 int\text{int}int 数字的一半？毕竟，
     * 如果该数字是回文，其后半部分反转后应该与原始数字的前半部分相同。
     *
     * 例如，输入 1221，我们可以将数字 “1221” 的后半部分从 “21” 反转为 “12”，并将其与前半部分 “12” 进行比较，
     * 因为二者相同，我们得知数字 1221 是回文。
     *
     * 算法
     *对于数字 1221，如果执行 1221 % 10，我们将得到最后一位数字 1，要得到倒数第二位数字，我们可以先通过除以10把最后一位
     * 数字从 1221 中移除，1221 / 10 = 122，再求出上一步结果除以 10 的余数，122 % 10 = 2，就可以得到倒数第二位数字。
     * 如果我们把最后一位数字乘以 10，再加上倒数第二位数字，1 * 10 + 2 = 12，就得到了我们想要的反转后的数字。如果继续这
     * 个过程，我们将得到更多位数的反转数字。
     * @param x
     * @return
     */
    public static boolean isPalindrome2(int x){
        //特殊情况：
        //如上所述，当x<0时，x不是回文数。
        //同样的，如果数字的最后一位是0，为了使该数字为回文，
        //则其第一位数字也应该是0；只有0符合这一回文属性。
        if(x<0||(x!=0&&x%10==0)) return false;

        int revertedNumber=0;
        while(x>revertedNumber){
            revertedNumber=revertedNumber*10+x%10;
            x/=10;
        }
        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
