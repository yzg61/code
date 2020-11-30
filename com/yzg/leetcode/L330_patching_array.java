package com.yzg.leetcode;

import java.util.Arrays;

public class L330_patching_array {
    /**
     * 330. 按要求补齐数组
     * 给定一个已排序的正整数数组 nums，和一个正整数 n 。从 [1, n] 区间内选取任意个数字补充到 nums 中，使得 [1, n] 区间内的任何数字都可以用 nums 中某几个数字的和来表示。请输出满足上述要求的最少需要补充的数字个数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [1,3], n = 6
     * 输出: 1
     * 解释:
     * 根据 nums 里现有的组合 [1], [3], [1,3]，可以得出 1, 3, 4。
     * 现在如果我们将 2 添加到 nums 中， 组合变为: [1], [2], [3], [1,3], [2,3], [1,2,3]。
     * 其和可以表示数字 1, 2, 3, 4, 5, 6，能够覆盖 [1, 6] 区间里所有的数。
     * 所以我们最少需要添加一个数字。
     * 示例 2:
     * <p>
     * 输入: nums = [1,5,10], n = 20
     * 输出: 2
     * 解释: 我们需要添加 [2, 4]。
     * 示例 3:
     * <p>
     * 输入: nums = [1,2,2], n = 5
     * 输出: 0
     */
    public int minPatches(int[] nums, int n) {
        //res表示补充的数字个数
        int res = 0;
        int length = nums.length;
        //less表示满足条件需要的下一个数字，同时表示[1,less)（less > 1）已经满足条件
        //less初始值为 1 表示，满足[1,1]需要下一个数字为1
        //添加数字 num后，需要的下一个数字变成 less  = less + num;
        // num为添加的数字，如果数组中的数 <= 需要添加的数less，那么把数组中的数添加：num = nums[i]
        //如果数组中的数 > 需要添加的数less，那么需要补充一个数字添加:num = less, res++;
        //如果less > n 表示，添加的数字[1, less)已经满足,同时[1,n]一定满足
        long less = 1;
        int i = 0;
        while (less <= n) {
            if (i < length && nums[i] <= less) {
                less += nums[i];
                i++;
            } else {
                less += less;
                res++;
            }
            System.out.println(less);
        }
        return res;
    }


    public static void main(String[] args) {
        L330_patching_array main = new L330_patching_array();
        int i = main.minPatches(new int[]{1,2,31,33}, Integer.MAX_VALUE);
        System.out.println(i);
    }
}
