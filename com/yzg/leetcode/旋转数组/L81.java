package com.yzg.leetcode.旋转数组;

public class L81 {
    public static void main(String[] args) {
        L81 main = new L81();
        boolean search = main.search(new int[]{1,1,1,1,1,2,1}, 2);
        System.out.println(search);
    }

    /**
     * 33. 搜索旋转排序数组
     * 整数数组 nums 按升序排列，数组中的值 互不相同 。
     * <p>
     * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
     * <p>
     * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [4,5,6,7,0,1,2], target = 0
     * 输出：4
     * 示例 2：
     * <p>
     * 输入：nums = [4,5,6,7,0,1,2], target = 3
     * 输出：-1
     * 示例 3：
     * <p>
     * 输入：nums = [1], target = 0
     * 输出：-1
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 5000
     * -10^4 <= nums[i] <= 10^4
     * nums 中的每个值都 独一无二
     * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
     * -10^4 <= target <= 10^4
     * <p>
     * <p>
     * 进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？
     */

    public boolean search(int[] nums, int target) {

        return searchIndex(nums, target, 0, nums.length - 1);
    }

    private boolean searchIndex(int[] nums, int target, int l, int r) {

        if (l > r) {
            return false;
        }
        int index = (l + r) / 2;
        int num = nums[index];

        if (num == target) {
            return true;
        }
        if (nums[l] == target) {
            return true;
        }
        if (nums[r] == target) {
            return true;
        }
        int rightIndex = index;
        while (index > 0 && nums[index-1] == num) {
            index--;
        }
        while (rightIndex < nums.length && nums[rightIndex + 1] == num) {
            rightIndex++;
        }
        if (l == r) {
            return false;
        }
        //[1,1,1,1,1,2,1] 2
        if (num > nums[l]) {
            if (target > nums[l] && target < num) {
                return searchIndex(nums, target, l, index - 1);
            } else {
                return searchIndex(nums, target, rightIndex + 1, r);
            }
        } else {
            if (target >= num && target <= nums[r]) {
                return searchIndex(nums, target, rightIndex + 1, r);
            } else {
                return searchIndex(nums, target, l, index - 1);
            }
        }
    }
}
