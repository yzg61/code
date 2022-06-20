package com.yzg.leetcode;

public class OutOfBoundaryPaths {
    /**
     * 576. 出界的路径数
     * 给定一个 m × n 的网格和一个球。球的起始坐标为 (i,j) ，你可以将球移到相邻的单元格内，或者往上、下、左、右四个方向上移动使球穿过网格边界。但是，你最多可以移动 N 次。找出可以将球移出边界的路径数量。答案可能非常大，返回 结果 mod 109 + 7 的值。
     *
     *
     *
     * 示例 1：
     *
     * 输入: m = 2, n = 2, N = 2, i = 0, j = 0
     * 输出: 6
     * 解释:
     *
     * 示例 2：
     *
     * 输入: m = 1, n = 3, N = 3, i = 0, j = 1
     * 输出: 12
     * 解释:
     *
     *
     *
     * 说明:
     *
     * 球一旦出界，就不能再被移动回网格内。
     * 网格的长度和高度在 [1,50] 的范围内。
     * N 在 [0,50] 的范围内。
     */

    long res = 0;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {

        dfs(m, n, maxMove, startRow, startColumn, 0);


        return Math.toIntExact(res % (1000000000 + 7));
    }

    private void dfs(int m, int n, int maxMove, int row, int col, int curMove) {
        if (curMove <= maxMove) {
            curMove++;
            if (row >= m || col >= n || row < 0 || col < 0) {
                res++;
                return;
            }
            dfs(m, n, maxMove, row + 1, col, curMove);
            dfs(m, n, maxMove, row - 1, col, curMove);
            dfs(m, n, maxMove, row, col + 1, curMove);
            dfs(m, n, maxMove, row, col - 1, curMove);
        }
    }
}
