package com.yzg.leetcode;

import java.util.Arrays;

public class L41 {
    /**
     * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1,2,0]
     * 输出: 3
     * 示例 2:
     * <p>
     * 输入: [3,4,-1,1]
     * 输出: 2
     * 示例 3:
     * <p>
     * 输入: [7,8,9,11,12]
     * 输出: 1
     *  
     * <p>
     * 提示：
     * <p>
     * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/first-missing-positive
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public int firstMissingPositive(int[] nums) {
        int l = nums.length;

        int i = 0;
        while (i < l) {
            //遍历数组，将第nums[i]- 1 个与第i个交换
            if (nums[i] > 0 && nums[i] < l && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }

        }
        //遍历交换后的数组，如果满足num[i] - 1 == i,表示数字i + 1之前交换过，存在数组中
        //如果出现 num[i] - 1 != i,表示数字 i + 1 没有交换，没有出现在数组中，
        // 则数字 i + 1 就是数组中没有出现的最小的正整数。
        //最后，如果整个交换后的数组都没有出现 num[i] - 1 != i， 表示数组中的数字
        for (i = 0; i < l; i++) {
            if (nums[i] - 1 != i) {
                return i + 1;
            }
        }

        return l + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int [] a = {1,2,0,2,4,6,4};
        L41 main = new L41();
        int res = main.firstMissingPositive(a);
        System.out.println(res);
    }
}

