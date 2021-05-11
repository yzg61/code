package com.yzg.leetcode;

public class LongestPalindromicSubstrings {

    public static void main(String[] args) {
        LongestPalindromicSubstrings main = new LongestPalindromicSubstrings();
        System.out.println(main.longestPalindrome("cbbd"));
    }

    /**
     * 5. 最长回文子串
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     * 示例 2：
     * <p>
     * 输入：s = "cbbd"
     * 输出："bb"
     * 示例 3：
     * <p>
     * 输入：s = "a"
     * 输出："a"
     * 示例 4：
     * <p>
     * 输入：s = "ac"
     * 输出："a"
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length <= 1000
     * s 仅由数字和英文字母（大写和/或小写）组成
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public String longestPalindrome(String s) {

        //"aabaccdcc"
        String longest = "";
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            //统计 以 s[i]为中心字符的 且子串长度为奇数的 最长回文子串长度
            longest = getLongestOdd(s, i, longest);
            //统计 以 s[i] 为中心偏左字符 且子串长度为偶数的 最长回文子串长度
            longest = getLongestEven(s, i, longest);
        }
        return longest;
    }

    private String getLongestOdd(String s, int i, String longest) {

        for (int j = 0; i + j <= s.length() - 1 && i - j >= 0; j++) {
            if (s.charAt(i + j) == s.charAt(i - j)) {
                if (2 * j + 1 > longest.length()) {
                    longest = s.substring(i - j, i + j + 1);
                }
            } else {
                break;
            }
        }
        return longest;
    }

    private String getLongestEven(String s, int i, String longest) {
        for (int j = i + 1; j <= s.length() - 1 && i >= 0; j++, i--) {
            if (s.charAt(j) == s.charAt(i)) {
                if (j - i + 1 > longest.length()) {
                    longest = s.substring(i, j + 1);
                }
            } else {
                break;
            }
        }
        return longest;
    }
}
