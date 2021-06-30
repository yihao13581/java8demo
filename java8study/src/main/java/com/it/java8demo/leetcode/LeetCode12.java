package com.it.java8demo.leetcode;

/**
 * 12、转罗马数字
 *
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 *     I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 *     X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 *     C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 *
 * 给你一个整数，将其转为罗马数字。
 * 示例 1:
 * 输入: num = 3
 * 输出: "III"
 *
 * 示例 2:
 * 输入: num = 4
 * 输出: "IV"
 *
 * 示例 3:
 * 输入: num = 9
 * 输出: "IX"
 *
 * 示例 4:
 * 输入: num = 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 *
 * 示例 5:
 * 输入: num = 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */
public class LeetCode12 {
    public static void main(String[] args) {
        int a=10;
        int b=20;
        a^=b;
        b^=a;
        a^=b;
        System.out.println(a);
        System.out.println(b);
    }

    /**
     * 罗马数字由7个不同的单字母符号组成，每个符号对应一个具体的数值。此外，减法规则（如问题描述中所述）给出了额外的 6个复合符号.
     * 这给了我们总共13个独特的符号（每个符号由 1个或 2个字母组成），如下图所示。
     *          M->1000      CM->900
     *          D->500       CD->400
     *          C->100       XC->90
     *          L->50        XL->40
     *          X->10        VX->9
     *          V->5         IV->4
     *          I->1
     */
    /**
     *方法一   ：模拟
     * 根据罗马数字的唯一表示法，为了表示一个给定的整数 num，我们寻找不超过 num的最大符号值，将 num减去该符号值，然后继续寻找不超过num的最大符号值，
     * 将该符号拼接在上一个找到的符号之后，循环直至 num为 0。最后得到的字符串即为 num的罗马数字表示。
     *
     * 编程时，可以建立一个数值-符号对的列表 valueSymbols，按数值从大到小排列。遍历 valueSymbols 中的每个数值-符号对，
     * 若当前数值value不超过 num，则从 num中不断减去 value，直至 num小于 value，然后遍历下一个数值-符号对。若遍历中为 0则跳出循环。
     */
    public String intToRoman(int num){
       int [] values={1000,900,500,400,100,90,50,40,10,9,5,4,1};
       String [] symbols={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

       StringBuffer roman=new StringBuffer();
       for(int i=0;i<values.length;i++){
           int value=values[i];
           String symbol=symbols[i];
           while(num>=value){
               num-=value;
               roman.append(symbol);
           }
           if(num==0) break;
       }
       return roman.toString();
    }

    /**
     *
     */
}
