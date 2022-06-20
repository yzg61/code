package com.yzg.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SubsetsWithDup {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Set<List<Integer>> list = new HashSet<>();

        for (int num : nums) {
            Set<List<Integer>> newList = new HashSet<>();
            newList.add(Collections.singletonList(num));
            for (List<Integer> subsets : list) {
                List<Integer> newSubsets = new ArrayList<>(subsets);
                newSubsets.add(num);
                newList.add(newSubsets.stream().sorted().collect(Collectors.toList()));
            }
            list.addAll(newList);
        }
        list.add(Collections.emptyList());
        return new ArrayList<>(list);
    }
}
