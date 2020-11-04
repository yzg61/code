package com.yzg.leetcode;

public class L47 {
    /**
     * 剑指 Offer 47. 礼物的最大价值
     * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
     *
     *
     *
     * 示例 1:
     *
     * 输入:
     * [
     *   [1,3,1],
     *   [1,5,1],
     *   [4,2,1]
     * ]
     * 输出: 12
     * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
     *
     *
     * 提示：
     *
     * 0 < grid.length <= 200
     * 0 < grid[0].length <= 200
     */

    private static int lenx;
    private static int leny;
    private static int[][] maxArr;
    public int maxValue(int[][] grid) {
        lenx = grid.length;
        leny = grid[0].length;
        maxArr = new int[lenx][leny];
        return nextMax(grid, 0, 0);
    }

    private int nextMax(int[][] grid, int x,int y) {
        if (maxArr[x][y] != 0) {
            return maxArr[x][y];
        }

        int left = grid[x][y], right = grid[x][y];

        if (y < leny - 1) {
            left += nextMax(grid, x, y + 1);
        }
        if (x < lenx - 1) {
            right += nextMax(grid, x + 1, y);
        }
        int max = Math.max(left, right);
        maxArr[x][y] = max;
        return max;
    }


    public static void main(String[] args) {
        L47 main = new L47();
        int [][] a = {{1,3,1,2,56,3,5,7}, {1,3,3,4,5,2,25,1},{1,3,3,4,5,2,25,1}};
        int i = main.maxValue(a);
        System.out.println(i);
    }
}
