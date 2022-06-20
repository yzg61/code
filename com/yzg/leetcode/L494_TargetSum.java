package com.yzg.leetcode;

import java.util.HashSet;
import java.util.Set;

public class L494_TargetSum {
    /**
     * 494. Target Sum
     * Medium
     * <p>
     * 3281
     * <p>
     * 133
     * <p>
     * Add to List
     * <p>
     * Share
     * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
     * <p>
     * Find out how many ways to assign symbols to make sum of integers equal to target S.
     * <p>
     * Example 1:
     * <p>
     * Input: nums is [1, 1, 1, 1, 1], S is 3.
     * Output: 5
     * Explanation:
     * <p>
     * -1+1+1+1+1 = 3
     * +1-1+1+1+1 = 3
     * +1+1-1+1+1 = 3
     * +1+1+1-1+1 = 3
     * +1+1+1+1-1 = 3
     * <p>
     * There are 5 ways to assign symbols to make the sum of nums be target 3.
     */
    //结果数量
    private int res = 0;
    //sum为确定符号的数字之和
    private int sum;
    //len为sum数组长度
    private int len;
    //sums[i] 表示 nums[i] 到 nums[len - 1] 的数字和
    private int[] sums ;
    public int findTargetSumWays(int[] nums, int S) {
        this.sum = S;
        this.len = nums.length;
        sums = new int[len];
        sums[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            sums[i] = sums[i + 1] + nums[i];
        }
        find(nums, 0,  0);
        return res;
    }

    /**
     *
     * @param nums 数组
     * @param index 数组当前索引
     * @param sum 之前所有确定符号的数字之和
     */
    private void find(int []nums, int index,int sum) {

        if (index < len) {
            if (sum - sums[index] > this.sum) {
                //当前数字之和 - 剩余数字之和 > 目标结果 ,
                // 表示如果接下来全是-也无法达到目标结果，直接排除
                return;
            }
            if (sum + sums[index] < this.sum) {
                //当前数字之和 + 剩余数字之和 < 目标结果 ，
                // 表示如果接下来全是+也无法达到目标结果，直接排除
                return;
            }
            //+
            find(nums, index + 1,  sum + nums[index]);
            //-
            find(nums, index + 1, sum - nums[index]);
        } else {
            //所有符号确定，判断是否满足条件
            if (sum == this.sum) {
                res++;
            }
        }
    }

    public static void main(String[] args) {
        L494_TargetSum main = new L494_TargetSum();
        long timer = System.currentTimeMillis();
        int res = main.findTargetSumWays(new int[]{34,21,12,36,16,7,31,7,41,49,7,48,22,19,32,46,19,18,44,34,24,45,23,45,23,23,45}, 47);
        System.out.println(System.currentTimeMillis() - timer);
        System.out.println(res);
    }

}
