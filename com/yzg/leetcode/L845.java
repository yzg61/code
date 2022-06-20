package com.yzg.leetcode;

import java.util.Arrays;

public class L845 {
    /**
     * 854. 相似度为 K 的字符串
     * 如果可以通过将 A 中的两个小写字母精确地交换位置 K 次得到与 B 相等的字符串，
     * 我们称字符串 A 和 B 的相似度为 K（K 为非负整数）。
     *
     * 给定两个字母异位词 A 和 B ，返回 A 和 B 的相似度 K 的最小值。
     *
     *
     *
     * 示例 1：
     *
     * 输入：A = "ab", B = "ba"
     * 输出：1
     * 示例 2：
     *
     * 输入：A = "abc", B = "bca"
     * 输出：2
     * 示例 3：
     *
     * 输入：A = "abac", B = "baca"
     * 输出：2
     * 示例 4：
     *
     * 输入：A = "aabc", B = "abca"
     *                       aacb
     *                       aabc
     * 输出：2
     *
     *
     * 提示：
     *
     * 1 <= A.length == B.length <= 20
     * A 和 B 只包含集合 {'a', 'b', 'c', 'd', 'e', 'f'} 中的小写字母。
     */
    private int res = 0;
    public int kSimilarity(String A, String B) {
        int k = 0;
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();

        dfs(a, b, 0, b.length - 1);

        return res;
    }

    private void dfs(char[] a, char[] b, int l, int r) {
        if (r < l) {
            if (a[l] != b[r]) {

            }
            dfs(a, b, l++, r);
        }
    }


    public static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
