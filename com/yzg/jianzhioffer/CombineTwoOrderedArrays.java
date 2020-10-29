package com.yzg.jianzhioffer;

public class CombineTwoOrderedArrays {
    /**
     * 题目描述
     * 给出两个有序的整数数组 A 和 B ，请将数组 B 合并到数组 A 中，变成一个有序的数组
     * 注意：
     * 可以假设 A 数组有足够的空间存放 B 数组的元素，A 和 B 中初始的元素数目分别为 m 和 n
     */
    public void merge(int[] A, int m, int[] B, int n) {
        //合并后的数组最大值索引为more
        int more = m + n - 1;
        m--;
        n--;
        while (n >= 0 || m >= 0) {
            if (n < 0 || m >= 0 && A[m] > B[n]) {
                A[more--] = A[m--];
            } else {
                A[more--] = B[n--];
            }
        }
    }
}
