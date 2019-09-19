package com.yzg.test.test;

import org.junit.Test;

/**
 * @author yzg
 * @create 2019/7/19
 */
public class Test4 {

    /**
     * 打印一圈
     *
     * @param m
     * @param a 左上角横坐标
     * @param b 左上角纵坐标
     * @param c 右下角横坐标
     * @param d 右下角纵坐标
     */
    public void printRound(int[][] m, int a, int b, int c, int d) {
        int x = a;
        int y = b;

        if (a == b && b == c && c == d) {
            System.out.print(m[x][y]);
            System.out.print(",");
            return;
        }

        //从左到右 x = a,y = b;
        while (x < c) {
            System.out.print(m[x][y]);
            System.out.print(",");
            x++;
        }
        //从上到下 x = c, y = b;
        while (y < d) {
            System.out.print(m[x][y]);
            System.out.print(",");
            y++;
        }
        //从右到左 x = c, y = d;
        while (x > a) {
            System.out.print(m[x][y]);
            System.out.print(",");
            x--;
        }
        //从下到上 x = a, y= d;
        while (y > b) {
            System.out.print(m[x][y]);
            System.out.print(",");
            y--;
        }
    }

    public void print(int[][] m) {
        int x1 = 0;
        int y1 = 0;
        int x2 = m.length - 1;
        int y2 = m[0].length - 1;

        while ((x1 <= x2)&&(y1 <= y2)) {
            printRound(m,x1,y1,x2,y2);
            x1++;
            x2--;
            y1++;
            y2--;
        }
    }

    @Test
    public void test() {
        int[][] m = {{1, 2}, {3, 4}};
        System.out.println("m[1][2] = " + m[0][1]);
        print(m);

    }
}
