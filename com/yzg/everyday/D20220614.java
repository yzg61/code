package com.yzg.everyday;

import java.util.Arrays;

public class D20220614 {

    /**
     * 498. 对角线遍历
     * 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,2,4,7,5,3,6,8,9]
     * 示例 2：
     * <p>
     * 输入：mat = [[1,2],[3,4]]
     * 输出：[1,2,3,4]
     * <p>
     * <p>
     * 提示：
     * <p>
     * m == mat.length
     * n == mat[i].length
     * 1 <= m, n <= 104
     * 1 <= m * n <= 104
     * -105 <= mat[i][j] <= 105
     */
    public int[] findDiagonalOrder(int[][] mat) {
        int[] res = new int[mat.length * mat[0].length];
        //往右上走
        boolean up = true;

        run(mat, 0, res, 0, 0, up);

        return res;
    }

    private void run(int[][] mat, int i, int[] res, int y, int x, boolean up) {
        if (i >= res.length) {
            return;
        }
        res[i++] = mat[y][x];
        if (up) {
            if (y - 1 >= 0 && x + 1 < mat[y].length) {
                y--;
                x++;
            } else if (y - 1 < 0 && x + 1 < mat[y].length) {
                up = false;
                x++;
            } else if (x + 1 >= mat[y].length) {
                up = false;
                y++;
            }

        } else {
            if (y + 1 < mat.length && x - 1 >= 0) {
                x--;
                y++;
            } else if (y + 1 < mat.length && x - 1 < 0) {
                up = true;
                y++;
            } else if (y + 1 >= mat.length) {
                up = true;
                x++;
            }
        }

        run(mat, i, res, y, x, up);
    }

    public static void main(String[] args) {
        D20220614 main = new D20220614();
        int[] diagonalOrder = main.findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        System.out.println(Arrays.toString(diagonalOrder));
    }
}
