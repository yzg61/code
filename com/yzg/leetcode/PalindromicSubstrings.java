package com.yzg.leetcode;

public class PalindromicSubstrings {

    /**
     * 647. 回文子串
     * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
     * <p>
     * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入："abc"
     * 输出：3
     * 解释：三个回文子串: "a", "b", "c"
     * 示例 2：
     * <p>
     * 输入："Semester"
     * 输出：6
     * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "Semester"
     * <p>
     * <p>
     * 提示：
     * <p>
     * 输入的字符串长度不会超过 1000 。
     *
     * @param s
     * @return
     */

    public int countSubstrings(String s) {

        //"aabaccdcc"
        int count = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            //统计 以 s[i]为中心字符的 且子串长度为奇数的 回文子串个数
            count += countOdd(chars, i);
            //统计 以 s[i] 为中心偏左字符 且子串长度为偶数的 回文子串个数
            count += countEven(chars, i);
        }
        return count;
    }

    private int countOdd(char[] chars, int i) {
        int count = 0;
        for (int j = 0; i + j <= chars.length - 1 && i - j >= 0; j++) {
            if (chars[i + j] == chars[i - j]) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    private int countEven(char[] chars, int i) {
        int count = 0;
        for (int j = i + 1; j <= chars.length - 1 && i >= 0; j++, i--) {
            if (chars[j] == chars[i]) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        PalindromicSubstrings main = new PalindromicSubstrings();
        System.out.println(main.countSubstrings("Semester"));
    }
}
