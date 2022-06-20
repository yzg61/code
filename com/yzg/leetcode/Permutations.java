package com.yzg.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {

    /**
     * 46. 全排列
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * 示例 2：
     *
     * 输入：nums = [0,1]
     * 输出：[[0,1],[1,0]]
     * 示例 3：
     *
     * 输入：nums = [1]
     * 输出：[[1]]
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 6
     * -10 <= nums[i] <= 10
     * nums 中的所有整数 互不相同
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> cur = Arrays.stream(nums).boxed().collect(Collectors.toList());

        dfs(nums, 0, cur, res);

        return res;
    }

    /**
     * 回溯
     * @param nums 数组
     * @param i 将选则的第i个元素
     * @param cur cur[0,i) 为已选择的元素，[i, n - 1]为待选择的
     * @param res 所有满足的结果
     */
    private void dfs(int[] nums, int i, List<Integer> cur, List<List<Integer>> res) {
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
        Permutations permutations = new Permutations();
        List<List<Integer>> list = permutations.permute(new int[]{1});

        System.out.println(list);
    }
}
