package com.yzg.jianzhioffer;

public class JFETK5 {


    /**
     * 剑指 Offer II 002. 二进制加法
     * 给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。
     *
     * 输入为 非空 字符串且只包含数字 1 和 0。
     *
     *
     *
     * 示例 1:
     *
     * 输入: a = "11", b = "10"
     * 输出: "101"
     * 示例 2:
     *
     * 输入: a = "1010", b = "1011"
     * 输出: "10101"
     *
     *
     * 提示：
     *
     * 每个字符串仅由字符 '0' 或 '1' 组成。
     * 1 <= a.length, b.length <= 10^4
     * 字符串如果不是 "0" ，就都不含前导零。
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {

        int offset = 0;
        boolean c = false;
        StringBuilder res = new StringBuilder();

        while (offset < a.length() || offset < b.length() ) {
            char x = (offset < a.length()) ? a.charAt(a.length() - 1 - offset): '0';
            char y = (offset < b.length()) ? b.charAt(b.length() - 1 - offset): '0';
            if (c) {
                res.append(Math.abs((x ^ y) - 1));
            } else {
                res.append(x ^ y);
            }
            offset++;
            c = x + y > '1' || c && (x + y) > '0';
        }
        if (c) {
            res.append("1");
        }

        return res.reverse().toString();
    }

    public static void main(String[] args) {
        JFETK5 main = new JFETK5();
        String s = main.addBinary("1", "111");
        System.out.println(s);


    }
}
