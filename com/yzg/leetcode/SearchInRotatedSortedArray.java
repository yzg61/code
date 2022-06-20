package com.yzg.leetcode;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        SearchInRotatedSortedArray main = new SearchInRotatedSortedArray();
        int search = main.search(new int[]{1,3}, 3);
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
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {

        return searchTarget(nums, target, 0, nums.length - 1);

    }

    private int searchTarget(int[] nums, int target, int x, int y) {
        if (x < 0 || y > nums.length - 1 || x > y) {
            return -1;
        }
        //将数组对半分，一半有序，另一半可能有序
        int i = (x + y) >> 1;
        if (nums[i] == target) {
            return i;
        }
        //如果target位于有序数组中，对有序数组进行二分查找
        if (nums[x] <= nums[i]) {
            if (target >= nums[x] && target <= nums[i]) {
                return binarySearch(nums, target, x, i);
            } else {
                //如果target不位于有序数组中，对另一半可能有序的数组再对半分，重复上述操作
                return searchTarget(nums, target, i + 1, y);
            }
        }

        if (i + 1 < nums.length && nums[i + 1] <= nums[y]) {
            if (target >= nums[i + 1] && target <= nums[y]) {
                return binarySearch(nums, target, i + 1, y);
            } else {
                return searchTarget(nums, target, x, i);
            }
        }

        return -1;
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
