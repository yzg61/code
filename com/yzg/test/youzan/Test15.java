package com.yzg.test.youzan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author yzg
 * @create 2019/9/4
 */
public class Test15 {
    //给定一个数组A[n], 定义数组的众数 ( Majority Element) 为数组中出现次数超过 n/2 次的元素,
    // 假设数组A[n]非空且一定存在众数, 请设计算法找到该众数并输出.

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().replace("[", "").replace("]", "").split(",");
        int[] a = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            a[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(a);
        System.out.println(a[a.length - 3]);
    }


}
