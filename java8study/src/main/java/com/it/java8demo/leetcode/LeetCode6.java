package com.it.java8demo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Z字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 *
 * 通过从左向右迭代字符串，我们可以轻松地确定字符位于 Z 字形图案中的哪一行。
 *
 * 算法
 * 我们可以使用 min(numRows,len(s))\text{min}( \text{numRows}, \text{len}(s))min(numRows,len(s)) 个列表来表示 Z 字形图案中的非空行。
 * 从左到右迭代 sss，将每个字符添加到合适的行。可以使用当前行和当前方向这两个变量对合适的行进行跟踪。
 * 只有当我们向上移动到最上面的行或向下移动到最下面的行时，当前方向才会发生改变。
 *
 */
public class LeetCode6 {
    public static void main(String[] args) {

    }
    public static String convert(String s, int numRows) {
        if(numRows==1) return s;

        List<StringBuilder> rows=new ArrayList<>();
        for(int i=0;i<Math.min(numRows,s.length());i++){
            rows.add(new StringBuilder());
        }

        int curRow=0;
        boolean goingDown=false;

        for(char c:s.toCharArray()){
            rows.get(curRow).append(c);
            if(curRow==0||curRow==numRows-1) goingDown=!goingDown;
            curRow+=goingDown?1:-1;
        }
        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }
}
