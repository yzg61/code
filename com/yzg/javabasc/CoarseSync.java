package com.yzg.javabasc;

import java.util.Hashtable;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yzg
 * @create 2019/9/14
 */
public class CoarseSync {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int[] n = new int[m];
        for (int i = 0; i < m; i++) {
            n[i] = scanner.nextInt();
        }

        int num = n[0];
        for (int i = 1; i < n.length; i++) {
            num = num^n[i];
        }
        System.out.println(num);
    }
}
