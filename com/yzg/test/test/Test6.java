package com.yzg.test.test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author yzg
 * @create 2019/8/1
 */
public class Test6 {

    public static void main(String ages[]){

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++){
            int n = scanner.nextInt();
            int[] a = new int[n];
            int mod4 = 0;
            int mod2 = 0;
            int odd = 0;
            for (int j = 0; j < n; j++){
                a[j] = scanner.nextInt();
                if (a[j]%4 == 0){
                    mod4++;
                }else if (a[j]%2 == 0){
                    mod2++;
                }else {
                    odd++;
                }
            }

            if (mod2 > 0){
                if (mod4 > odd){
                    System.out.println("Yes");
                }
                else {

                }
            }


            System.out.println();
        }

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
