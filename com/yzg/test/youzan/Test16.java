package com.yzg.test.youzan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author yzg
 * @create 2019/9/4
 */
public class Test16 {
    //给定一个数组A[n], 定义数组的众数 ( Majority Element) 为数组中出现次数超过 n/2 次的元素,
    // 假设数组A[n]非空且一定存在众数, 请设计算法找到该众数并输出.

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(";");

        System.out.println(method(str[0],str[1]));
    }
    public static boolean method(String a, String b){
        if (a.length() != b.length())
            return false;
        for (int i =0; i<a.length();i++){
            String s = a.substring(i,a.length()) + a.substring(0,i);
            if (b.equals(s))
                return true;
        }
        return false;
    }


}
