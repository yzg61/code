package com.yzg.leetcode;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

public class Decode_ways {
    public static void main(String[] args) {


        int month = 3;

        int quarter = (month - 1) / 3 + 1;

        int preQua = (quarter - 1);

        if (preQua == 0 ) {
            preQua = 4;
        }
        int startM= (preQua - 1) * 3 + 1;
        int endM = startM + 2;

        System.out.println(endM);
    }

    /**
     * 91. 解码方法
     * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
     * <p>
     * 'A' -> 1
     * 'B' -> 2
     * ...
     * 'Z' -> 26
     * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"111" 可以将 "1" 中的每个 "1" 映射为 "A" ，从而得到 "AAA" ，或者可以将 "11" 和 "1"（分别为 "K" 和 "A" ）映射为 "KA" 。注意，"06" 不能映射为 "F" ，因为 "6" 和 "06" 不同。
     * <p>
     * 给你一个只含数字的 非空 字符串 num ，请计算并返回 解码 方法的 总数 。
     * <p>
     * 题目数据保证答案肯定是一个 32 位 的整数。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "12"
     * 输出：2
     * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
     * 示例 2：
     * <p>
     * 输入：s = "226"
     * 输出：3
     * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
     * 示例 3：
     * <p>
     * 输入：s = "0"
     * 输出：0
     * 解释：没有字符映射到以 0 开头的数字。含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。由于没有字符，因此没有有效的方法对此进行解码，因为所有数字都需要映射。
     * 示例 4：
     * <p>
     * 输入：s = "06"
     * 输出：0
     * 解释："06" 不能映射到 "F" ，因为字符串开头的 0 无法指向一个有效的字符。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length <= 100
     * s 只包含数字，并且可能包含前导零。
     */
    public int numDecodings(String s) {

        //arr[i]为前i个字符的解码方法总数
        //arr[i] = max(arr[i - 1] + a, arr[i - 2] + b)
        //a为最后一个字符单独解码，b为最后2个字符共同解码
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = decode(s.substring(0, 1));
        for (int i = 2; i < dp.length; i++) {
            char cur = s.charAt(i - 1);
            char pre = s.charAt(i - 2);
            if (cur == '0') {
                //当前为0，只能和前一位结合 “10”，“20”；
                if (pre != '1' && pre != '2') {
                    //无法与前一位结合，直接返回0
                    return 0;
                }
                //只能和前一位结合，解法不变
                dp[i] = dp[i - 2];
            } else {
                //前一位不为0，当前不为 0且位于1 -6 之间，则能使解法增加
                if (pre != '0' && cur >= '1' && cur <= '6') {
                    dp[i] = dp[i - 1] + dp[i - 2];
                } else {
                    //否则只能以当前位解析，解法数量不变
                    dp[i] = dp[i - 1];
                }
            }
        }



        return dp[dp.length - 1];
    }

    private int decode(String s) {
        return Integer.parseInt(s) > 0 && Integer.parseInt(s) < 27 ? 1 : 0;
    }


}
