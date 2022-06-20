package com.yzg.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {

    public static void main(String[] args) {
        ShortestPathInBinaryMatrix main = new ShortestPathInBinaryMatrix();
        int i = main.shortestPathBinaryMatrix(new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 0}});
        System.out.println(i);
    }

    /**
     * 1091. 二进制矩阵中的最短路径
     * 给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。
     * <p>
     * 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求：
     * <p>
     * 路径途经的所有单元格都的值都是 0 。
     * 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。
     * 畅通路径的长度 是该路径途经的单元格总数。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：grid = [[0,1],[1,0]]
     * 输出：2
     * 示例 2：
     * <p>
     * <p>
     * 输入：grid = [[0,0,0],[1,1,0],[1,1,0]]
     * 输出：4
     * 示例 3：
     * <p>
     * 输入：grid = [[1,0,0],[1,1,0],[1,1,0]]
     * 输出：-1
     * <p>
     * <p>
     * 提示：
     * <p>
     * n == grid.length
     * n == grid[i].length
     * 1 <= n <= 100
     * grid[i][j] 为 0 或 1
     *
     * @param grid
     * @return
     */
    public int shortestPathBinaryMatrix(int[][] grid) {
        //无解
        if (grid.length == 0 ||
                grid[0][0] == 1 ||
                grid[grid.length - 1][grid[grid.length - 1].length - 1] == 1) {
            return -1;
        }
        //队列缓存可通行的路径点
        Queue<int[]> queue = new LinkedList<>(Arrays.asList(new int[]{0, 0}));
        //路径长度初始化1
        int res = 1;
        grid[0][0] = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            //遍历队列中所有的路劲点
            for (int i = 0; i < size; i++) {
                int[] path = queue.poll();
                int x = path[0];
                int y = path[1];
                //终点
                if (x == grid.length - 1 && y == grid[x].length - 1) {
                    return res;
                }
                //将路径点的周围 8个点添加到队列中
                for (int j = -1; j < 2; j++) {
                    for (int k = -1; k < 2; k++) {
                        if (j != 0 || k != 0) {
                            int x1 = x + j;
                            int y1 = y + k;
                            //路径点 没有出界，没有重复访问
                            if (x1 > -1 && y1 > -1 &&
                                    x1 < grid.length && y1 < grid[x1].length &&
                                    grid[x1][y1] == 0) {
                                queue.add(new int[]{x1, y1});
                                //走过的路径设为-1
                                grid[x1][y1] = -1;
                            }
                        }
                    }
                }
            }
            res++;
        }


        return -1;
    }
}
