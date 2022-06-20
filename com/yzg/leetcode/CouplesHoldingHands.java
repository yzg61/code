package com.yzg.leetcode;

public class CouplesHoldingHands {


    public static void main(String[] args) {
        CouplesHoldingHands main = new CouplesHoldingHands();
        int res = main.minSwapsCouples(new int[]{10, 7, 4, 2, 3, 0, 9, 11, 1, 5, 6, 8});
        System.out.println(res);
    }

    /**
     * 765. 情侣牵手
     * N 对情侣坐在连续排列的 2N 个座位上，想要牵到对方的手。 计算最少交换座位的次数，以便每对情侣可以并肩坐在一起。 一次交换可选择任意两人，让他们站起来交换座位。
     * <p>
     * 人和座位用 0 到 2N-1 的整数表示，情侣们按顺序编号，第一对是 (0, 1)，第二对是 (2, 3)，以此类推，最后一对是 (2N-2, 2N-1)。
     * <p>
     * 这些情侣的初始座位  row[i] 是由最初始坐在第 i 个座位上的人决定的。
     * <p>
     * 示例 1:
     * <p>
     * 输入: row = [0, 2, 1, 3]
     * 输出: 1
     * 解释: 我们只需要交换row[1]和row[2]的位置即可。
     * 示例 2:
     * <p>
     * 输入: row = [3, 2, 0, 1]
     * 输出: 0
     * 解释: 无需交换座位，所有的情侣都已经可以手牵手了。
     * 说明:
     * <p>
     * len(row) 是偶数且数值在 [4, 60]范围内。
     * 可以保证row 是序列 0...len(row)-1 的一个全排列。
     */

    public int minSwapsCouples(int[] row) {
        int res = 0;

        for (int i = 0; i < row.length; i += 2) {
            if (row[i] / 2 != row[i + 1] / 2) {
                int find = row[i] % 2 == 0 ? row[i] + 1 : row[i] - 1;
                for (int j = i + 2; j < row.length; j++) {
                    if (find == row[j]) {
                        res++;
                        swap(row, i + 1, j);
                    }
                }
            }
        }
        return res;
    }

    private void swap(int[] row, int i, int j) {
        int t = row[i];
        row[i] = row[j];
        row[j] = t;
    }
}
