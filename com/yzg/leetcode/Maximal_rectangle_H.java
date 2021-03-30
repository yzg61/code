package com.yzg.leetcode;

import java.util.Stack;

public class Maximal_rectangle_H {
    public static void main(String[] args) {
        Maximal_rectangle_H main = new Maximal_rectangle_H();
        int i = main.maximalRectangle(new char[][]{{'0'}});
        System.out.println(i);
    }

    /**
     * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，
     * 找出只包含 1 的最大矩形，并返回其面积。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：matrix = [
     * ["1","0","1","0","0"],
     * ["1","0","1","1","1"],
     * ["1","1","1","1","1"],
     * ["1","0","0","1","0"]
     * ]
     * 输出：6
     * 解释：最大矩形如上图所示。
     * 示例 2：
     * <p>
     * 输入：matrix = []
     * 输出：0
     * 示例 3：
     * <p>
     * 输入：matrix = [["0"]]
     * 输出：0
     * 示例 4：
     * <p>
     * 输入：matrix = [["1"]]
     * 输出：1
     * 示例 5：
     * <p>
     * 输入：matrix = [["0","0"]]
     * 输出：0
     *  
     * <p>
     * 提示：
     * <p>
     * rows == matrix.length
     * cols == matrix[0].length
     * 0 <= row, cols <= 200
     * matrix[i][j] 为 '0' 或 '1'
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximal-rectangle
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int res = 0;

        int[][] arr = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                arr[i][j] = (matrix[i][j] - 48);
                if (i > 0 && arr[i][j] != 0) {
                    arr[i][j] += arr[i - 1][j];
                }
            }
            res = Math.max(res, largestRectangleArea(arr[i]));
        }


        return res;
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] arr = new int[heights.length + 2];
        System.arraycopy(heights, 0, arr, 1, heights.length);
        int max = 0;
        // 如果
        // 对栈中柱体来说，栈中的下一个柱体就是其「左边第一个小于自身的柱体」；
        // 若当前柱体 i 的高度小于栈顶柱体的高度，说明 i 是栈顶柱体的「右边第一个小于栈顶柱体的柱体」。
        // 因此以栈顶柱体为高的矩形的左右宽度边界就确定了，可以计算面积
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                int h = arr[stack.pop()];
                max = Math.max(max, (i - (stack.peek() + 1)) * h);
            }

            stack.push(i);
        }

        return max;
    }
}
