package com.yzg.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Permutations2 {

    /**
     * 47. 全排列 II
     * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [1,1,2]
     * 输出：
     * [[1,1,2],
     *  [1,2,1],
     *  [2,1,1]]
     * 示例 2：
     *
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 8
     * -10 <= nums[i] <= 10
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();

        List<Integer> cur = Arrays.stream(nums).boxed().collect(Collectors.toList());

        dfs(nums, 0, cur, res);

        return new ArrayList<>(res);
    }

    /**
     * 回溯
     * @param nums 数组
     * @param i 将选则的第i个元素
     * @param cur cur[0,i) 为已选择的元素，[i, n - 1]为待选择的
     * @param res 所有满足的结果
     */
    private void dfs(int[] nums, int i, List<Integer> cur, Set<List<Integer>> res) {
        if (i == cur.size()) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int j = i; j < nums.length; j++) {
            //选中nums[j], 将nums[j] 与 nums[i] 交换，则nums[0, i] 都是已经选过的数
            Collections.swap(cur, j, i);
            //回溯
            dfs(nums,i + 1, cur, res);
            //取消交换
            Collections.swap(cur, j, i);
        }
    }

    public static void main(String[] args) {
        Permutations2 permutations = new Permutations2();
        List<List<Integer>> list = permutations.permuteUnique(new int[]{1,1,2});

        System.out.println(list);
    }
}
