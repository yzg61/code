package com.yzg.leetcode;

import java.util.Arrays;

public class L542 {
    /**
     * 542. 01 矩阵
     * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
     * <p>
     * 两个相邻元素间的距离为 1 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：
     * [[0,0,0],
     * [0,1,0],
     * [0,0,0]]
     * <p>
     * 输出：
     * [[0,0,0],
     * [0,1,0],
     * [0,0,0]]
     * 示例 2：
     * <p>
     * 输入：
     * [[0,0,0],
     * [0,1,0],
     * [1,1,1]]
     * <p>
     * 输出：
     * [[0,0,0],
     * [0,1,0],
     * [1,2,1]]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 给定矩阵的元素个数不超过 10000。
     * 给定矩阵中至少有一个元素是 0。
     * 矩阵中的元素只在四个方向上相邻: 上、下、左、右。
     */


    public int[][] updateMatrix(int[][] matrix) {
        int[][] distances = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    distanceZero(matrix, distances, i, j, 0);
                }
            }
        }

        return distances;
    }

    void distanceZero(int[][] matrix, int[][] distances, int i, int j, int min) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[i].length ||
                (matrix[i][j] == 0 && min != 0)) {
            return;
        }
        if (distances[i][j] > 0 && min >= distances[i][j]) {
            return;
        }
        distances[i][j] = min;
        distanceZero(matrix, distances, i + 1, j, min + 1);
        distanceZero(matrix, distances, i , j + 1, min + 1);
        distanceZero(matrix, distances, i - 1, j, min + 1);
        distanceZero(matrix, distances, i , j - 1, min + 1);
    }

    public static void main(String[] args) {
        L542 main = new L542();
        int[][] ints = main.updateMatrix(new int[][]{{0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}});
        System.out.println(Arrays.deepToString(ints));
    }
}
