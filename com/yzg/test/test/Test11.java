package com.yzg.test.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author yzg
 * @create 2019/8/1
 *
 * 小易参加了一个骰子游戏,这个游戏需要同时投掷n个骰子,每个骰子都是一个印有数字1~6的均匀正方体。
 * 小易同时投掷出这n个骰子,如果这n个骰子向上面的数字之和大于等于x,小易就会获得游戏奖励。
 * 小易想让你帮他算算他获得奖励的概率有多大。
 *
 * 输入描述:
 * 输入包括两个正整数n和x(1 ≤ n < 25, 1 ≤ x < 150),分别表示骰子的个数和可以获得奖励的最小数字和。
 *
 * 输出描述:
 * 输出小易可以获得奖励的概率。
 * 如果概率为1,输出1,如果概率为0,输出0,其他以最简分数(x/y)的形式输出。
 *
 * 输入例子1:
 * 3 9
 *
 * 输出例子1:
 * 20/27
 */

public class Test11 {



    public static void main(String ages[]) {

        int[] a = new int[1];

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        long count = 0;
        long temp;
        for (int y = 1; y <= n; y++){
            /*for (int x = 1; x<=n;x++){
                if (x%y >= k){
                    count++;
                }
            }*/
            // 假设n = a*y +b；在每个长度为y的区间里只有（y-k）个数模y余数>=k。
            count += n/y*(y-k);
            temp = n%y;
            if(temp >= k) {                    //再考虑余数b是否>=k
                count += temp-k+1;
            }
        }


        System.out.println(count);

    }


    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
