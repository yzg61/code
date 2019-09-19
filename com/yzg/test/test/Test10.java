
package com.yzg.test.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author yzg
 * @create 2019/8/1
 *
 */

public class Test10 {

    public static void main(String ages[]) {


        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int x[] = new int[n];
        for (int i = 0; i < n; i++){
            x[i] = scanner.nextInt();
        }
        

        //先排序
        Arrays.sort(x);
        //左移s所有的点
        //这样所有点只有两个选择，不动，或右移2s
        for (int i = 0; i < n; i++){

            x[i] -= s;
        }
        //左边界
        int left = x[0];
        //右边界
        int right = x[n -1];

        int min = right - left;
        //确定左边界
        if (x[0] + 2*s >= x[n - 1]){
            //左边界右移2s后超过右边界
            left = x[n -1];
        }else {
            left = x[0] + 2*s;
        }

        //遍历当前左边界之前的点
        for (int i = 1; x[i] < left; i++){
            //右移2s
            if (x[i] + 2*s > right){
                //大于右边界
                if (right - x[i] < min){
                    //更新最小值
                    min = right - x[i];
                }
                //更新右边界
                right = x[i] + 2*s;
            }
        }
        if (right - left < min){
            min = right - left;
        }
        System.out.println(min);

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
