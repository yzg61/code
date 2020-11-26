package com.yzg.jianzhioffer;

/**
 * @author yangzg
 */
public class Er_wei_shu_zu_zhong_de_cha_zhao_lcof {
    /**
     * 剑指 Offer 04. 二维数组中的查找
     * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * <p>
     * <p>
     * <p>
     * 示例:
     * <p>
     * 现有矩阵 matrix 如下：
     * <p>
     * [
     * [1,   4,  7, 11, 15],
     * [2,   5,  8, 12, 19],
     * [3,   6,  9, 16, 22],
     * [10, 13, 14, 17, 24],
     * [18, 21, 23, 26, 30]
     * ]
     * 给定 target = 5，返回 true。
     * <p>
     * 给定 target = 20，返回 false。
     * <p>
     * <p>
     * <p>
     * 限制：
     * <p>
     * 0 <= n <= 1000
     * <p>
     * 0 <= m <= 1000
     */

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        /* [
         *   [1,   4,  7, 11, 15],
         *   [2,   5,  8, 12, 19],
         *   [3,   6,  9, 16, 22],
         *   [10, 13, 14, 17, 24],
         *   [18, 21, 23, 26, 30]
         * ]         */
        //起点为矩阵的右上角
        int x = 0;
        int y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] > target) {
                //如果当前值比目标值大，索引向左走
                y--;
            } else {
                //如果当前值比目标值小，索引向下走
                x++;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        Er_wei_shu_zu_zhong_de_cha_zhao_lcof main = new Er_wei_shu_zu_zhong_de_cha_zhao_lcof();
        boolean res = main.findNumberIn2DArray(new int[][]{{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}}, 25);
        System.out.println(res);

    }
}
