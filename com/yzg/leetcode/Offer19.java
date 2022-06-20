package com.yzg.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Offer19 {
    /**
     * 剑指 Offer 19. 正则表达式匹配
     * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"Semester"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
     * <p>
     * 示例 1:
     * <p>
     * 输入:
     * s = "aa"
     * p = "a"
     * 输出: false
     * 解释: "a" 无法匹配 "aa" 整个字符串。
     * 示例 2:
     * <p>
     * 输入:
     * s = "aa"
     * p = "a*"
     * 输出: true
     * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
     * 示例 3:
     * <p>
     * 输入:
     * s = "ab"
     * p = ".*"
     * 输出: true
     * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
     * 示例 4:
     * <p>
     * 输入:
     * s = "aab"
     * p = "c*a*b"
     * 输出: true
     * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
     * 示例 5:
     * <p>
     * 输入:
     * s = "misssisippi"
     * p = "mis*is*p*."
     * 输出: false
     * s 可能为空，且只包含从 a-z 的小写字母。
     * p 可能为空，且只包含从 a-z 的小写字母以及字符 . 和 *，无连续的 '*'。
     */

    public boolean isMatch(String s, String p) {
        //dp[i][j]表示 s的前 i个字符和 p的前 j 个字符能否匹配
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        //初始化dp[0][0] 表示两个空字符，可以匹配
        dp[0][0] = true;
        //当 0 < j < p.length, 使dp[0][j] = true 要满足: j % 2 == 0 && p[j - 1] == '*'
        for (int j = 2; j <= p.length(); j += 2) {
            dp[0][j] = (p.charAt(j - 1) == '*' && dp[0][j - 2]);
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                char cp = p.charAt(j - 1);
                char cs = s.charAt(i - 1);
                if (cp != '*') {
                    //当匹配字符不是'*'的时候
                    dp[i][j] = dp[i - 1][j - 1] && (cp == cs || cp == '.');
                } else {
                    // cpl = * 的前一个字符
                    char cpl = p.charAt(j - 2);
                    // * 的前一个字符出现 0次
                    boolean zero = dp[i][j - 2];
                    // * 的前一个字符出现 1次
                    boolean once = dp[i][j - 1];
                    // * 的前一个字符出现 2次
                    boolean twice = dp[i - 1][j] && (cpl == cs || cpl == '.');
                    dp[i][j] = zero || once || twice;
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        int i = 1000000;
        List<Integer> list = new ArrayList<>(i);
        while (i-- > 0) {
            list.add(i);
        }
        int offset = 0;
        int size = 20;
        long time = System.currentTimeMillis();
        List<Integer> collect = list.stream().skip(offset).limit(size).collect(Collectors.toList());
        while (collect.size() > 0 && offset + size < list.size()) {
            System.out.println(offset);
            offset += size;
//            collect = list.stream().skip(offset).limit(size).collect(Collectors.toList());
//            collect = list.parallelStream().skip(offset).limit(size).collect(Collectors.toList());
            collect = list.subList(offset, offset + size);
        }
        System.out.println(System.currentTimeMillis() - time);
    }
}
