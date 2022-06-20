package com.yzg.leetcode;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        MinimumSizeSubarraySum main = new MinimumSizeSubarraySum();
        int i = main.minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1});
        System.out.println(i);
    }

    /**
     * 209. 长度最小的子数组
     * 给定一个含有 n 个正整数的数组和一个正整数 target 。
     * <p>
     * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：target = 7, nums = [2,3,1,2,4,3]
     * 输出：2
     * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
     * 示例 2：
     * <p>
     * 输入：target = 4, nums = [1,4,4]
     * 输出：1
     * 示例 3：
     * <p>
     * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
     * 输出：0
     */

    public int minSubArrayLen(int target, int[] nums) {

        int l = 0, r = 0, len = nums.length + 1;
        int sum = nums[0];
        while (l <= r && r < nums.length) {
            if (sum >= target) {
                //满足条件尝试缩小窗口
                len = Math.min(r - l + 1, len);
                sum -= nums[l];
                l++;
            } else {
                //不满足则尝试扩大窗口
                r++;
                if (r < nums.length) {
                    sum += nums[r];
                }
            }
        }

        return len > nums.length ? 0 : len;
    }
}
