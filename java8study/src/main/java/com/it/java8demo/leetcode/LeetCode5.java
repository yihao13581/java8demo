package com.it.java8demo.leetcode;

/**
 * 最长回文子串:       动态规划：
 * 思路与算法
 *
 * 对于一个子串而言，如果它是回文串，并且长度大于 222，那么将它首尾的两个字母去除之后，它仍然是个回文串。例如对于字符串 “ababa”
 *，如果我们已经知道 “bab” 是回文串，那么 “ababa” 一定是回文串，这是因为它的首尾两个字母都是 “a”。
 *
 * 根据这样的思路，我们就可以用动态规划的方法解决本题。我们用 P(i,j)表示字符串s的第i到j个字母组成的串（下文表示成 s[i:j]）是否为回文串；
 * P(i,j)={true,如果子串Si…Sj是回文串
 *         false；其它情况
 *这里的「其它情况」包含两种可能性：
 *
 *     s[i,j]本身不是一个回文串；
 *
 *     i>j，此时 s[i,j]本身不合法。
 *
 * 那么我们就可以写出动态规划的状态转移方程：
 *
 *       P(i,j)=P(i+1,j−1)∧(Si==Sj)
 *
 * 也就是说，只有 s[i+1:j−1]是回文串，并且 s的第 i和 j个字母相同时，s[i:j]才会是回文串。
 *
 * 上文的所有讨论是建立在子串长度大于 2的前提之上的，我们还需要考虑动态规划中的边界条件，即子串的长度为 1或2。对于长度为 11的子串，它显然是个回文串；
 * 对于长度为 2的子串，只要它的两个字母相同，它就是一个回文串。因此我们就可以写出动态规划的边界条件：
 *      {P(i,i)=true
 *       P(i,i+1)=(Si==Si+1)
 * 根据这个思路，我们就可以完成动态规划了，最终的答案即为所有 P(i,j)=true中 j−i+1（即子串长度）的最大值。
 * 注意：在状态转移方程中，我们是从长度较短的字符串向长度较长的字符串进行转移的，因此一定要注意动态规划的循环顺序。
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 示例 2：
 *
 * 输入：s = "cbbd"
 * 输出："bb"
 *
 * 示例 3：
 *
 * 输入：s = "a"
 * 输出："a"
 *
 * 示例 4：
 *
 * 输入：s = "ac"
 * 输出："a"
 *
 *
 *
 * 提示：
 *
 *     1 <= s.length <= 1000
 *     s 仅由数字和英文字母（大写和/或小写）组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode5 {
    public static void main(String[] args) {
        String s="abdbasad";
        String result=longestPalindrome(s);
        System.out.println(result);
    }

    public static String longestPalindrome(String s) {
       int len=s.length();
       if(len<2) return s;

       int maxLen=1;
       int begin=0;
       //dp[i][j] 表示 s[i..j] 是否是回文串
        boolean [][] dp=new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i <len ; i++) {
            dp[i][i]=true;
        }
        char [] charArray=s.toCharArray();
        //递推开始
        //先枚举字串长度
        for (int L =2; L <=len ; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i <len ; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j=L+i-1;
                // 如果右边界越界，就可以退出当前循环
                if(j>=len){break;}
                if(charArray[i]!=charArray[j]){
                    dp[i][j]=false;
                }else{
                    if(j-i<3){//i和j之间只相隔一个字符
                        dp[i][j]=true;
                    }else{
                        dp[i][j]=dp[i+1][j-1];
                    }
                }
                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if(dp[i][j]&&j-i+1>maxLen){
                    maxLen=j-i+1;
                    begin=i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);

    }
}
