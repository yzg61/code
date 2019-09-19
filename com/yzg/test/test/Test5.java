package com.yzg.test.test;

import java.util.ArrayList;


public class Test5 {


    public ArrayList<Integer> printMatrix(int [][] matrix) {

        ArrayList<Integer> list = new ArrayList<>();

        //左上角
        int x1 = 0;
        int y1 = matrix[0].length - 1;
        //右下角
        int x2 = matrix.length - 1;
        int y2 = 0;
        while(x1 <= x2 && y1 >= y2){
            printOne(list,matrix,x1,y1,x2,y2);
            x1++;
            y1--;
            x2--;
            y2++;
        }

        return list;
    }
    public void printOne(ArrayList<Integer> list, int [][] matrix, int x1, int y1, int x2, int y2){

        //起点
        int x = x1;
        int y = y1;
        //只有一个点
        if (x1 == x2 && x2 == y1 && y1 == y2) {
            list.add(matrix[x][y]);
            return;
        }
        while(x < x2){
            list.add(matrix[x][y]);
            x++;
        }
        //x = x2;
        while(y > y2){
            list.add(matrix[x][y]);
            y--;
        }
        //y=y2
        while(x > x1){
            list.add(matrix[x][y]);
            x--;
        }
        //x = x1;
        while(y < y1){
            list.add(matrix[x][y]);
            y--;
        }
    }


}