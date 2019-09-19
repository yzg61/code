package com.yzg.test;

/**
 * @author yzg
 * @create 2019/8/2
 */

import java.util.*;

public class Main {

    /*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
******************************开始写代码******************************/
    static int solution(int[] arr) {
        int num = 0;
        for (int i = 1; i < arr.length; i++){
            if (arr[i] < arr[i - 1]){
                swap(arr,i - 1, i);
                num++;
            }
        }
        return num;
    }
    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _arr_size = 0;
        _arr_size = Integer.parseInt(in.nextLine().trim());
        int[] _arr = new int[_arr_size];
        int _arr_item;
        for(int _arr_i = 0; _arr_i < _arr_size; _arr_i++) {
            _arr_item = Integer.parseInt(in.nextLine().trim());
            _arr[_arr_i] = _arr_item;
        }

        res = solution(_arr);
        System.out.println(String.valueOf(res));

    }


}
