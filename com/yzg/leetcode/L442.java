package com.yzg.leetcode;

import java.util.ArrayList;
import java.util.List;

public class L442 {
    /**
     * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
     *
     * 找到所有出现两次的元素。
     *
     * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
     *
     * 示例：
     *
     * 输入:
     * [4,3,2,7,8,2,3,1]
     *
     * 输出:
     * [2,3]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-all-duplicates-in-an-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                if (nums[nums[i] - 1] > 0) {
                    nums[nums[i] - 1] = -nums[nums[i] - 1];
                } else {
                    res.add(nums[i]);
                }
            } else {
                if (nums[-nums[i] - 1] > 0) {
                    nums[-nums[i] - 1] = -nums[-nums[i] - 1];
                } else {
                    res.add(-nums[i]);
                }
            }
        }

        return res;
    }
}
