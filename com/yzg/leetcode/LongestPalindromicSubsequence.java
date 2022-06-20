package com.yzg.leetcode;

public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        LongestPalindromicSubsequence main = new LongestPalindromicSubsequence();
        System.out.println(main.longestPalindromeSubseq("cbbd"));
    }

    /**
     * 516. 最长回文子序列
     * 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
     *
     *
     *
     * 示例 1:
     * 输入:
     *
     * "bbbab"
     * 输出:
     *
     * 4
     * 一个可能的最长回文子序列为 "bbbb"。
     *
     * 示例 2:
     * 输入:
     *
     * "cbbd"
     * 输出:
     *
     * 2
     * 一个可能的最长回文子序列为 "bb"。
     *
     *
     *
     * 提示：
     *
     * 1 <= s.length <= 1000
     * s 只包含小写英文字母
     */

    public int longestPalindromeSubseq(String s) {

        //"aabaccdcc"
        int longest = 0;
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            //统计 以 s[i]为中心字符的 且子串长度为奇数的 最长回文子串长度
            longest = getLongestOdd(s, i, longest);
            //统计 以 s[i] 为中心偏左字符 且子串长度为偶数的 最长回文子串长度
            longest = getLongestEven(s, i, longest);
        }
        return longest;
    }

    private int getLongestOdd(String s, int i, int longest) {

        for (int j = 0; i + j <= s.length() - 1 && i - j >= 0; j++) {
            if (s.charAt(i + j) == s.charAt(i - j)) {
                longest = Math.max(longest, 2*j + 1);
            } else {
                break;
            }
        }
        return longest;
    }

    private int getLongestEven(String s, int i, int longest) {
        for (int j = i + 1; j <= s.length() - 1 && i >= 0; j++, i--) {
            if (s.charAt(j) == s.charAt(i)) {
               longest = Math.max(longest, j - i + 1);

            } else {
                break;
            }
        }
        return longest;
    }
}
