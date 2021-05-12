package com.yzg.leetcode;

public class UniquePathsIII {


    public static void main(String[] args) {
        UniquePathsIII main = new UniquePathsIII();
        System.out.println(main.uniquePathsIII(new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}}));
    }

    /**
     * 980. 不同路径 III
     * 在二维网格 grid 上，有 4 种类型的方格：
     * <p>
     * 1 表示起始方格。且只有一个起始方格。
     * 2 表示结束方格，且只有一个结束方格。
     * 0 表示我们可以走过的空方格。
     * -1 表示我们无法跨越的障碍。
     * 返回在四个方向（上、下、左、右）上行走时，从起始方格到结束方格的不同路径的数目。
     * <p>
     * 每一个无障碍方格都要通过一次，但是一条路径中不能重复通过同一个方格。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：[[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
     * 输出：2
     * 解释：我们有以下两条路径：
     * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
     * 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
     * 示例 2：
     * <p>
     * 输入：[[1,0,0,0],[0,0,0,0],[0,0,0,2]]
     * 输出：4
     * 解释：我们有以下四条路径：
     * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
     * 2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
     * 3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
     * 4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
     * 示例 3：
     * <p>
     * 输入：[[0,1],[2,0]]
     * 输出：0
     * 解释：
     * 没有一条路能完全穿过每一个空的方格一次。
     * 请注意，起始和结束方格可以位于网格中的任意位置。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= grid.length * grid[0].length <= 20
     *
     * @return
     */


    //起点
    int startX = -1, startY = -1;
    //需要走的路径总长度,包括终点和起点
    int maxLen = 0;
    //符合条件的路径数量
    int res = 0;

    public int uniquePathsIII(int[][] grid) {

        //     * 1 表示起始方格。且只有一个起始方格。
        //     * 2 表示结束方格，且只有一个结束方格。
        //     * 0 表示我们可以走过的空方格。
        //     * -1 表示我们无法跨越的障碍。

        //找到起点，需要走的路径总长度
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == -1) {
                    continue;
                }
                if (grid[i][j] == 0) {
                    maxLen++;
                } else if (grid[i][j] == 1) {
                    maxLen++;
                    startX = i;
                    startY = j;
                } else if (grid[i][j] == 2) {
                    maxLen++;
                }
            }
        }

        //从起点开始搜索结果
        dfs(grid, startX, startY, 0);

        return res;
    }

    /**
     * 搜索结果
     *
     * @param grid   路径数组
     * @param x      当前坐标
     * @param y      当前坐标
     * @param curLen 已经走过的路径长度
     */
    private void dfs(int[][] grid, int x, int y, int curLen) {

        //越界
        if (x < 0 || x > grid.length - 1 || y < 0 || y > grid[0].length - 1) {
            return;
        }
        //遇到障碍无法继续搜索
        if (grid[x][y] == -1) {
            return;
        }
        //可通行，包括起点和终点
        if (grid[x][y] == 0) {
            curLen++;
        } else if (grid[x][y] == 1) {
            curLen++;
        } else if (grid[x][y] == 2) {
            curLen++;
            //终点判断当前路径是否符合条件
            if (curLen == maxLen) {
                res++;
            }
            //无论是否符合条件，走到终点就无法继续搜索
            return;
        }
        //当前位置设为-1，不可通行
        grid[x][y] = -1;
        //往当前位置的 上，下，左，右继续搜索
        dfs(grid, x, y + 1, curLen);
        dfs(grid, x, y - 1, curLen);
        dfs(grid, x + 1, y, curLen);
        dfs(grid, x - 1, y, curLen);
        //回溯时，当前位置重置为可通行
        grid[x][y] = 0;
    }
}
