package com.yzg.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class L84 {
    /**
     * 84. 柱状图中最大的矩形
     * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
     * <p>
     * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
     */

    private final Stack<Integer> stack = new Stack<>();

    public int largestRectangleArea(int[] heights) {
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
    public static void main(String[] args) {
        L84 main = new L84();
        int[] arr = {2, 1, 5, 6, 2, 3};

        System.out.println(main.largestRectangleArea(arr));
    }
    private int getArea(int[] heights, int i) {

        int height = heights[i];
        int right = i;
        int left = i;
        //向左遍历找到第一个比h[i]小的
        while (left > 0 && heights[left - 1] >= height) {
            left--;
        }
        //向右遍历找到第一个比h[i]小的
        while (right < heights.length - 1 && heights[right + 1] >= height) {
            right++;
        }
        //返回以h[i]为高的矩形面积
        return (right - left + 1) * height;
    }
}
