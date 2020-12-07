package com.yzg.leetcode;

import javafx.scene.Node;

import java.util.Arrays;
import java.util.logging.Level;

public class L213 {
    /**
     * 213. 打家劫舍 II
     * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
     *
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [2,3,2]
     * 输出：3
     * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
     * 示例 2：
     *
     * 输入：nums = [1,2,3,1]
     * 输出：4
     * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     *      偷窃到的最高金额 = 1 + 3 = 4 。
     * 示例 3：
     *
     * 输入：nums = [0]
     * 输出：0
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 100
     * 0 <= nums[i] <= 1000
     *
     * 0,1,2,3,4,5,6
     */

    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        //dp0[i]表示在不偷第一间房屋
        int[] dp0 = Arrays.copyOfRange(nums, 1, len);
        //dp1[i]表示在不偷最后一间房屋
        int[] dp1 = Arrays.copyOfRange(nums, 0, len - 1);

        return Math.max(robMax(dp0),robMax(dp1));
    }

    /**
     * 偷窃一排房屋，首尾不相连
     * @param nums
     * @return
     */
    public int robMax(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        //dp[i]表示偷窃前i个房屋的最大金额
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        //dp[n] = max(nums[n] + dp[n - 2], dp[n - 1])
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(nums[i - 1] + dp[i - 2], dp[i - 1]);
        }

        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        L213 main = new L213();
        int rob = main.rob(new int[]{226,174,214,16,218,48,153,131,128,17,});
        System.out.println(rob);
    }
}
