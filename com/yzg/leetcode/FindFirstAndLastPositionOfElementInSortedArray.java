package com.yzg.leetcode;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementInSortedArray main = new FindFirstAndLastPositionOfElementInSortedArray();
        int[] ints = main.searchRange(new int[]{4,1,3}, 3);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     * <p>
     * 如果数组中不存在目标值 target，返回 [-1, -1]。
     * <p>
     * 进阶：
     * <p>
     * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [5,7,7,8,8,10], target = 8
     * 输出：[3,4]
     * 示例 2：
     * <p>
     * 输入：nums = [5,7,7,8,8,10], target = 6
     * 输出：[-1,-1]
     * 示例 3：
     * <p>
     * 输入：nums = [], target = 0
     * 输出：[-1,-1]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {

        int[] res = {-1, -1};

        //二分查找
        int i = binarySearch(nums, target, 0, nums.length - 1);

        if (i >= 0) {
            return findStartAndEnd(nums, target, i, res);
        }
        return res;
    }

    /**
     * 二分查找
     *
     * @param nums
     * @param target
     * @return
     */
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

    private int[] findStartAndEnd(int[] nums, int target, int i, int[] res) {
        int start = i, end = i;
        while (start > 0) {
            if (nums[start - 1] != target) {
                break;
            }
            start--;
        }

        while (end < nums.length - 1) {
            if (nums[end + 1] != target) {
                break;
            }
            end++;
        }
        res[0] = start;
        res[1] = end;

        return res;
    }
}
