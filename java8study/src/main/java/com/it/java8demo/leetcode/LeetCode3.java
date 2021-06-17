package com.it.java8demo.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LeetCode3 {
    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     *
     *
     * 示例 1:
     *
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     *
     * 示例 2:
     *
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     *
     * 示例 3:
     *
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *
     * 示例 4:
     *
     * 输入: s = ""
     * 输出: 0
     *
     *
     *
     * 提示：
     *
     *     0 <= s.length <= 5 * 104
     *     s 由英文字母、数字、符号和空格组成
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int lengthLongestSubstring(String s){
        if(" ".equals(s)||s==null||"".equals(s)) {return 0;}
        char [] s1=s.toCharArray();
        Set<Character> charset=new HashSet();
        for (char c : s1) {
            charset.add(c);
        }
        int lengthSet=charset.size();
        int stringLength=s.length();
        if(stringLength==lengthSet) return  lengthSet;
        for(;;) {
            for (int i = 0; i <=stringLength - lengthSet; i++) {
                if (!isRepeat(s.substring(i, lengthSet + i))) {
                 return lengthSet;
                }
            }
            if (lengthSet==0) break;
            lengthSet--;
        }
        if("".equals(s)) {return 0;}
        return 0;
    }
    public static boolean isRepeat(String s){
        char [] s1=s.toCharArray();
        Set<Character> charset=new HashSet();
        for (char c : s1) {
            charset.add(c);
        }
        int lengthSet=charset.size();
        return s.length()>lengthSet;

    }

    public static void main(String[] args) {
//        while(true) {
//            Scanner scanner = new Scanner(System.in);
//            String s = scanner.nextLine();
//           int a= s.charAt(0);
//            System.out.println(s.charAt(0));
//            System.out.println(lengthLongestSubstring(s) + "");
//
//        }
        Set<Character> sets=new HashSet<>();

        System.out.println(sets.add('a'));
        System.out.println(sets.add('b'));
        System.out.println(sets.add('a'));
        System.out.println(sets.add('c'));
        System.out.println(sets.add('a'));



    }

    public static int lengthLongestSubstring2(String s){
     if(s.length()==0) return 0;
     HashMap<Character,Integer> map=new HashMap<>();
     int max=0;
     int left=0;
        for (int i = 0; i <s.length() ; i++) {
            if(map.containsKey(s.charAt(i))){
                left=Math.max(left,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max=Math.max(max,i-left+1);

        }
        return max;
    }
}
