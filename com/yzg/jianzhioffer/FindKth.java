package com.yzg.jianzhioffer;

import java.util.Arrays;

public class FindKth {
    /**
     * 有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
     * <p>
     * 给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。
     * <p>
     * 示例1
     * 输入
     * [1,3,5,2,2],5,3
     * 返回值
     * 2
     */


    public int findKth(int[] a, int n, int K) {
        // write code here
        return findK(a, 0, n - 1, K - 1 );

    }

    public int findK(int[] a, int l, int r, int K) {
        int p = partition(a, l, r);
        if (p == K) {
            return a[p];
        } else if (p > K) {
            return findK(a, l, p - 1, K);
        } else {
            return findK(a, p + 1, r, K);
        }
    }

    public static int partition(int[] a, int l, int r) {
        int less = r;
        int more = l;
        while (less > more) {
            if (a[less] > a[l]) {
                swap(a, ++more, less);
            } else {
                less--;
            }
        }
        swap(a, less, l);
        return more;
    }


    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        FindKth main = new FindKth();
        int[] a = {1332802,1177178,1514891,871248,753214,123866,1615405,328656,1540395,968891,1884022,252932,1034406,1455178,821713,486232,860175,1896237,852300,566715,1285209,1845742,883142,259266,520911,1844960,218188,1528217,332380,261485,1111670,16920,1249664,1199799,1959818,1546744,1904944,51047,1176397,190970,48715,349690,673887,1648782,1010556,1165786,937247,986578,798663};
        int kth = main.findKth(a, a.length, 24);
        System.out.println(kth);
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));

    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int p = partition(arr, l, r);
            quickSort(arr, l, p - 1);
            quickSort(arr, p + 1, r);
        }
    }

    public int findKth2(int[] a, int n, int K) {
        // write code here

        int l = 0; int r = n-1;
        return quik(a, l, r, K);

    }

    private int quik(int[] a, int l, int r, int k) {
        int position = find(a, l , r, k);
        if(position == k-1) {
            return a[position];
        } else if(position > k-1) {
            return quik(a, l, position -1, k);
        } else {
            return quik(a, position+1, r, k);
        }
    }

    private int find(int[] a, int l, int r, int k) {
        int i = l;
        int j = r;
        int key = a[i];
        while(i < j) {
            while(i<j && a[j] <= key) j--;
            a[i] = a[j] ;
            while(i<j && a[i] >= key) i++;
            a[j] = a[i];



        }
        a[j] = key;
        return j;
    }
}
