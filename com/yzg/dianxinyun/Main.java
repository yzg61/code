package com.yzg.dianxinyun;

import java.util.Scanner;

/**
 * @author yzg
 * @create 2019/9/18
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine()
                .replace("[", "")
                .replace("]", "")
                .replace(" ","")
                .split(",");

        int[] a = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals("")){
                System.out.println(0);
                return;
            }
            a[i] = Integer.parseInt(str[i]);
        }
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            int m = a[i];
            max = Math.max(max,m);
            for (int j = i + 1; j < a.length; j++){
                m+=a[j];
                max = Math.max(max,m);
            }
        }
        System.out.println(max);
    }
}
