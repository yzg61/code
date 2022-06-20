package com.yzg.leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

public class largest_number {
    /**
     * 179. 最大数
     * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
     * <p>
     * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [10,2]
     * 输出："210"
     * 示例 2：
     * <p>
     * 输入：nums = [3,30,34,5,9]
     * 输出："9534330"
     * 示例 3：
     * <p>
     * 输入：nums = [1]
     * 输出："1"
     * 示例 4：
     * <p>
     * 输入：nums = [10]
     * 输出："10"
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 100
     * 0 <= nums[i] <= 109
     */

    public static void main(String[] args) {
        largest_number main = new largest_number();
        System.out.println(main.largestNumber(new int[]{0, 0, 0}));
    }

    public String largestNumber(int[] nums) {


        String res = Arrays.stream(nums)
                .boxed()
                .sorted(this::compare)
                .map(String::valueOf)
                .collect(Collectors.joining());

        return res.startsWith("0") ? "0" : res;
    }

    public void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }


    public int compare(int a, int b) {
        int i = 0;

        byte[] byteA = (a + String.valueOf(b)).getBytes();
        byte[] byteB = (b + String.valueOf(a)).getBytes();

        int lengthA = byteA.length;
        int lengthB = byteB.length;

        int minLength = Math.min(lengthA, lengthB);

        while (i < minLength) {
            if (byteA[i] == byteB[i]) {
                i++;
            } else {
                return byteA[i] > byteB[i] ? 1 : -1;
            }
        }

        if (lengthA == lengthB) {
            return 0;
        }

        return lengthA > lengthB ? 1 : -1;
    }
}
