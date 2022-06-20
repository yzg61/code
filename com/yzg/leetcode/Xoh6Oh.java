package com.yzg.leetcode;

public class Xoh6Oh {

    /**
     * 剑指 Offer II 001. 整数除法
     * 给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%' 。
     * <p>
     * <p>
     * <p>
     * 注意：
     * <p>
     * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
     * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231−1]。本题中，如果除法结果溢出，则返回 231 − 1
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：a = 15, b = 2
     * 输出：7
     * 解释：15/2 = truncate(7.5) = 7
     * 示例 2：
     * <p>
     * 输入：a = 7, b = -3
     * 输出：-2
     * 解释：7/-3 = truncate(-2.33333..) = -2
     * 示例 3：
     * <p>
     * 输入：a = 0, b = 1
     * 输出：0
     * 示例 4：
     * <p>
     * 输入：a = 1, b = 1
     * 输出：1
     * <p>
     * <p>
     * 提示:
     * <p>
     * -231 <= a, b <= 231 - 1
     * b != 0
     */

    public int divide(int a, int b) {
        //溢出判断
        if (b == -1 && a == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }

        int res = 0;
        //符号位
        boolean neg = a < 0 && b > 0 || a > 0 && b < 0;

        long s = Math.abs((long)a);
        long div = Math.abs((long)b);
        while (true) {
            int bit = 0;
            while ((div << bit) <= s && (div << bit) > 0) {
                bit++;
            }
            if (bit == 0) {
                break;
            }
            if (bit < 2) {
                res += bit;
            } else {
                res += 2 << (bit - 2);
            }

            s -= div << (bit - 1);
        }

        return neg ? -res : res;
    }

    public static void main(String[] args) {
        Xoh6Oh main = new Xoh6Oh();
        int divide = main.divide(-2147483648, 1);
        System.out.println(divide);
    }

    public static class Query {

    }
    private void process(Query query) {

    }
}
