package com.yzg.leetcode;

import cn.hutool.core.collection.CollectionUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subsets {

    /**
     * 78. 子集
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     *
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [1,2,3]
     * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     * 示例 2：
     *
     * 输入：nums = [0]
     * 输出：[[],[0]]
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 10
     * -10 <= nums[i] <= 10
     * nums 中的所有元素 互不相同
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();

        for (int num : nums) {
            List<List<Integer>> newList = new ArrayList<>();
            newList.add(Collections.singletonList(num));
            for (List<Integer> subsets : list) {
                List<Integer> newSubsets = new ArrayList<>(subsets);
                newSubsets.add(num);
                newList.add(newSubsets);
            }
            list.addAll(newList);
        }
        list.add(Collections.emptyList());
        return list;
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        List<List<Integer>> list = subsets.subsets(new int[]{1, 2, 2});


        System.out.println(Arrays.toString(list.toArray()));
    }
}
