package com.yzg.test.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author yzg
 * @create 2019/8/1
 * 编程题]工作方案
 * 时间限制：1秒
 *
 * 空间限制：153600K
 *
 * 牛牛手中有s份工作需要完成,牛牛准备将工作分给三位员工。考虑到三位员工还有其他工作需要做,牛牛规定他们每人必须要参与的工作数量分别是a,b,c。
 * 牛牛需要制定详细的工作方案,需要满足每份工作至少有一个人做,同一份工作可以由两个或者三个人共同参与。牛牛一下意识到可能的工作方案很多,牛牛需要你帮他计算一下一共有多少种不同的工作方案(对于两种方案,如果某份工作分配的人或者人数不一样就考虑为不一样的工作方案)。
 *
 * 对于输入样例,s = 3, a = 3, b = 1, c = 1
 * a要参与所有三份工作,b和c各自有三种选择,所以不同的工作方案是3 * 3 * 1= 9
 * 如果s = 3, a = 1, b = 1, c = 1
 * 相当于对三个员工做全排列,所以不同的工作方案是3 * 2 * 1 = 6
 *
 * 输入描述:
 * 输入包括一行,一行包括4个正整数s,a,b,c(1 ≤ s ≤ 50, 1 ≤ a, b, c ≤ s),分别表示需要完成的工作份数,每个员工必须要参与的工作数量。
 *
 * 输出描述:
 * 输出一个正整数,表示不同的方案种数,答案可能很大,输出答案对1000000007取模。
 *
 * 输入例子1:
 * 3 3 1 1
 *
 * 输出例子1:
 * 9
 */
public class Test9 {

    public static void main(String ages[]) {
        
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int mod = 1000000007;
        int cnt[][][][] = new int[s][a][b][c];
        cnt[0][0][0][0] = 0;


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
