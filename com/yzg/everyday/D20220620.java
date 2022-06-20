package com.yzg.everyday;

public class D20220620 {

    public static void main(String[] args) {
        D20220620 main = new D20220620();
        String s = main.maximumTime("1?:?0");
        System.out.println(s);
    }

    /**
     * 给你一个字符串 time ，格式为 hh:mm（小时：分钟），其中某几位数字被隐藏（用 ? 表示）。
     * <p>
     * 有效的时间为 00:00 到 23:59 之间的所有时间，包括 00:00 和 23:59 。
     * <p>
     * 替换 time 中隐藏的数字，返回你可以得到的最晚有效时间。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：time = "2?:?0"
     * 输出："23:50"
     * 解释：以数字 '2' 开头的最晚一小时是 23 ，以 '0' 结尾的最晚一分钟是 50 。
     * 示例 2：
     * <p>
     * 输入：time = "0?:3?"
     * 输出："09:39"
     * 示例 3：
     * <p>
     * 输入：time = "1?:22"
     * 输出："19:22"
     *  
     * <p>
     * 提示：
     * <p>
     * time 的格式为 hh:mm
     * 题目数据保证你可以由输入的字符串生成有效的时间
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/latest-time-by-replacing-hidden-digits
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param time
     * @return
     */
    public String maximumTime(String time) {
        char[] c = new char[]{'2', '9', ':', '5', '9'};
        char[] chars = time.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '?') {
                if (i == 0 && chars[1] != '?' && chars[1] > 51) {
                    chars[i] = '1';
                } else if (i == 1 && chars[0] == '2') {
                    chars[i] = '3';
                } else {
                    chars[i] = c[i];
                }
            }
        }

        return String.valueOf(chars);
    }
}
