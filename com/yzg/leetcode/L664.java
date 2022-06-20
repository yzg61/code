package com.yzg.leetcode;

public class L664 {
    /**
     * 664. 奇怪的打印机
     * 有台奇怪的打印机有以下两个特殊要求：
     * <p>
     * 打印机每次只能打印同一个字符序列。
     * 每次可以在任意起始和结束位置打印新字符，并且会覆盖掉原来已有的字符。
     * 给定一个只包含小写英文字母的字符串，你的任务是计算这个打印机打印它需要的最少次数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: "aaabbb"
     * 输出: 2
     * 解释: 首先打印 "Semester" 然后打印 "bbb"。
     * 示例 2:
     * <p>
     * 输入: "aba"
     * 输出: 2
     * 解释: 首先打印 "Semester" 然后在第二个位置打印 "b" 覆盖掉原来的字符 'a'。
     * 提示: 输入字符串的长度不会超过 100。
     */

    public int strangePrinter(String s) {
        /**
         *  a - 1
         *  ab - 2
         *  aa - 1
         *  abc - 3
         *  abb - 2
         */
        char[] chars = s.toCharArray();
        int len = chars.length;
        if (len < 2) {
            return len;
        }
        //res[i][j] 为打印chars[i]到chars[j]间的字符需要的次数
        int[][] res = new int[len][len];
        for (int i = 0; i < len; i++) {
            //先确定打印每个单独的字符需要一次
            res[i][i] = 1;
        }

        for (int l = 1; l < len; l++) {
            //j = i + 1 -> len - 1
            int j;
            //找出打印chars[0]到chars[j]的最少次数，j = 1 -> len - 1
            for (int i = 0; (j = i + l) < len; i++) {
                //找出打印chars[i]到chars[j]的最少次数， i = 0 -> j
                //打印chars[i]到chars[j]可以分解为，chars[i + 1]到chars[j]的次数加上chars[i]的一次
                res[i][j] = res[i + 1][j] + 1;
                for (int k = i + 1; k <= j; k++) {
                    //在 (i + 1) <= k <= j 中，若存在chars[k] == chars[i]，
                    //则有可能减少打印次数
                    if (chars[k] == chars[i]) {
                        //chars[k]和chars[i]可以一起打印，即忽略chars[k]的次数，
                        //打印chars[i]到chars[j]可以分解为 res[i][k - 1] + res[k + 1][j]
                        if (k != len - 1) {
                            //k不是字符串的最后一个字符
                            res[i][j] = Math.min(res[i][j], res[i][k - 1] + res[k + 1][j]);
                        } else {
                            //k是最后一个字符，直接忽略 res[k + 1][j]
                            res[i][j] = Math.min(res[i][j], res[i][k - 1]);
                        }
                    }
                }
            }
        }
        return res[0][len - 1];
    }

    public static void main(String[] args) {
        L664 main = new L664();
        int a = main.strangePrinter("aabccacaacdaav");
        System.out.println(a);
    }
}
