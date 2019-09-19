package com.yzg.test.test;

import org.junit.Test;

/**
 * @author yzg
 * @create 2019/7/9
 */
public class Test2 {

    @Test
    public void test() {

        generate(5);
    }

    private int[] p;
    private int num;

    public void generate(int num) {
        p = new int[num];
        for (int i = 0; i < num; i++) {
            p[i] = i + 1;
        }
        this.num = num;
        fun(0);
    }

    public void fun(int index) {

        if (index >= num) {
            return;
        }

        swap(p, index, 0);
        print(p);
        for (int i = 1; i < num - 1; i++) {
            for (int j = i + 1; j < num; j++) {
                swap(p, i, j);
                print(p);
                swap(p, i, j);
            }
        }

        fun(++index);

    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void print(int[] a) {
        for (int i : a) {
            System.out.print(i);
        }
        System.out.println();
    }

}
