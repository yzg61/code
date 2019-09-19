package com.yzg.test.test;

import org.junit.Test;

/**
 * @author yzg
 * @create 2019/7/4
 */
public class Test1 {

    @Test
    public void test() {

        int arr[] = {5, 5, 5, 4, 3, 8, 43, 5, 36, 23, 76, 23, 76, 34, 56, 34, -2, 23};
        quickSort(arr,0,arr.length - 1);
        printArray(arr);

        String s = "ss";
    }


    public void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            //随机选择数组中的一个数，与最后一个值交换
            swap(arr, left + (int) (Math.random() * (right - left +1)),right);
            int cur = left;
            int less = left - 1;
            int more = right + 1;
            while (cur < more) {
                if (arr[cur] < arr[right]) {
                    swap(arr, ++less, cur++);
                } else if (arr[cur] > arr[right]) {
                    swap(arr, --more, cur);
                } else {
                    cur++;
                }

            }
            quickSort(arr, left,less);
            quickSort(arr,more,right);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

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
