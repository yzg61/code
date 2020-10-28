package com.yzg.jianzhioffer;

import java.util.Arrays;

/**
 * 题目描述
 * N皇后问题是指在N*N的棋盘上要摆N个皇后，要求任何两个皇后不同行，不同列也不再同一条斜线上，求给一个整数n，返回n皇后的摆法。
 * 示例1
 * 输入
 * 复制
 * 1
 * 返回值
 * 复制
 * 1
 * 示例2
 * 输入
 * 复制
 * 8
 * 返回值
 * 复制
 * 92
 * 备注:
 * 1 \leq n \leq 141≤n≤14
 */
public class Nqueen {

    private static int res = 0;
    /**
     *
     * @param n int整型 the n
     * @return int整型
     */
    public int Nqueen (int n) {
        // write code here
        res = 0;
        dfs(new int[n], 0);

        return res;
    }

    /**
     *
     * @param ints 每一行的皇后位置，如ints[0]=8,标识第0行的皇后放在第8列
     * @param current 当前放皇后的行数
     */
    private void dfs(int[] ints, int current) {
        int length;
        if ((length = ints.length) == current) {
            //超过最后一行，表示每一行都放了皇后,找到一种解法，结束
            res++;
            System.out.println(Arrays.toString(ints));
            return;
        }
        //不能放置的位置，exc[0] = true表示，当前行第0列不能放置
        boolean [] exc = new boolean[length];

        //遍历之前的每一行，找到所有当前行不能放置皇后的位置
        for (int i = 0; i < current; i++) {
            //row表示某行的皇后在哪一列
            int row = ints[i];
            //len表示某行距离当前行的长度
            int distance = current - i;
            //排除某行上存在皇后的列
            exc[row] = true;
            //排除某行上存在皇后的对角线的列
            //left为左对角线与当前行相交的列位置
            int left = row - distance;
            //right为右对角线与当前行相交的列位置
            int right = row + distance;
            if (left >=0) {
                //排除左对角线的列位置
                exc[left] = true;
            }
            if (right < length) {
                //排除右对角线
                exc[right] = true;
            }
        }

        //遍历当前行的所有列，从可以放置的列递归查找下一行的位置
        for (int i = 0; i < length; i++) {
            //跳过不能放置的列
            if (!exc[i]) {
                //当前行的皇后放置在当前列
                ints[current] = i;
                //查找下一行可以放的位置
                dfs(ints, current + 1);
            }
        }
    }

    public static void main(String[] args) {
        Nqueen nqueen = new Nqueen();
        int res = nqueen.Nqueen(8);
    }
}
