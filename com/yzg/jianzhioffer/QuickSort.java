package com.yzg.jianzhioffer;

import java.util.Arrays;
import java.util.Timer;

public class QuickSort {
    public static void main(String[] args) {
        QuickSort main = new QuickSort();
        int [] arr = {1,231,45,94,35,26,45,78,56,45,67,234,23,31,54,789,34,78,34,5,34,23};
        int[] sort = main.quickSort(arr);
        System.out.println(Arrays.toString(sort));
    }
    public int [] quickSort(int [] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    public static void quickSort(int [] arr, int l, int r) {
        if (l < r) {
            int p = partition(arr, l, r);
            quickSort(arr, l, p - 1);
            quickSort(arr, p, r);
        }
    }

    public static int partition(int [] arr, int l, int r) {
        int p = arr[r];
        int less = l;
        int more = r;
        while (less < more) {
            if (arr[less] <= p) {
                less++;
            } else if (arr[less] > p){
                swap(arr, less, --more);
            }
        }
        swap(arr, less, r);
        return more;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
