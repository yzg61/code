package com.yzg.leetcode;

public class SearchA2DMatrix {

    /**
     * 74. 搜索二维矩阵
     * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
     *
     * 每行中的整数从左到右按升序排列。
     * 每行的第一个整数大于前一行的最后一个整数。
     *
     *
     * 示例 1：
     *
     *
     * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
     * 输出：true
     * 示例 2：
     *
     *
     * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
     * 输出：false
     *
     *
     * 提示：
     *
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= m, n <= 100
     * -104 <= matrix[i][j], target <= 104
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int x = searchX(matrix, target, 0, matrix.length - 1);
        if (x < 0) {
            return false;
        }
        int res = binarySearch(matrix[x], target, 0, matrix[x].length - 1);

        return res >= 0;
    }

    /**
     * 找到矩阵中可能存在 target的行
     * @param matrix
     * @param target
     * @param start
     * @param end
     * @return
     */
    private int searchX(int[][] matrix, int target, int start, int end) {
        if (end < 0) {
            return -1;
        }

        int i = (start + end) >> 1;
        /**
         * 10
         * 24
         * 34
         * 44
         * 52
         */
        if (matrix[i][0] > target) {
            return searchX(matrix, target, start, i - 1);
        } else {
            if (start == end) {
                return start;
            }
            return searchX(matrix, target, i + 1, end);
        }
    }
    private int binarySearch(int[] nums, int target, int x, int y) {
        if (x > y || x < 0 || y > nums.length - 1) {
            return -1;
        }

        int i = (x + y) >> 1;
        if (nums[i] == target) {
            return i;
        }
        if (nums[i] > target) {
            return binarySearch(nums, target, x, i - 1);
        } else {
            return binarySearch(nums, target, i + 1, y);
        }
    }
}
