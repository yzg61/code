package com.yzg.test.xiaomi;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author yzg
 * @create 2019/9/11
 */
public class Main {
    /**
     * 《2048》是一款热门的数字游戏。游戏中，每个方块上的数字都有2的幂，数字方块会根据指令整体进行上下左右移动，如果两个数字相同的方块在移动中碰撞，他们就会合成一个新的方块。例如下图为4*4格子的游戏，0表示格子为空，图a为移动前格子中的数字，图b为图a左移后的结果:
     *
     * 0 0 2 4
     * 0 2 2 2
     * 0 4 2 2
     * 8 8 2 2
     *    图a
     * 2 4 0 0
     * 4 2 0 0
     * 4 4 0 0
     * 16 4 0 0
     *    图b
     * 问，给定n*m的矩阵M，0表示空格子，非0整数表示待移动的数字，按照2048的移动规则，输出进行左移操作后的矩阵结果。
     *
     * 输入
     * 输入n行数据
     *
     * 第1行为矩阵行数
     *
     * 第2行到第n行为矩阵每行数据，m个数据用空格隔开
     *
     * 输出
     * 输出左移后的矩阵，单行元素用空格隔开，换行处无空格
     *
     *
     * 样例输入
     * 4
     * 0 0 2 4
     * 0 2 2 2
     * 0 4 2 2
     * 8 8 2 2
     * 样例输出
     * 2 4 0 0
     * 4 2 0 0
     * 4 4 0 0
     * 16 4 0 0
     * @param input
     * @return
     */
    static String solution(String[] input) {

        for (int i = 0; i < input.length; i++) {
            StringBuffer stringBuffer = new StringBuffer();
            String[] s = input[i].split(" ");//每一行数据
            ArrayList<Integer> integers = new ArrayList<>();
            for (int j = 0; j < s.length; j++) {
                integers.add(Integer.valueOf(s[j]));
            }
            ArrayList<Integer> group = group(integers);
            for (int j = 0; j < group.size(); j++){
                stringBuffer.append(group.get(j));
                if (j != group.size() - 1){
                    stringBuffer.append(" ");
                }
            }
            System.out.println(stringBuffer);
        }
        return null;
    }
    public static ArrayList<Integer> group(ArrayList<Integer> integers){

        int l = integers.size();//防止全是0陷入死循环
        while (integers.get(0) == 0 && l > 0){
            integers.remove(0);
            integers.add(0);
            l--;
        }
        //前面的0全部移到后面了
        //开始找相同的数
        for (int i = 1; i < integers.size();i++){
            int a = integers.get(i);
            int b = integers.get(i - 1);
            if (a == b && a != 0){//相撞
                integers.set(i - 1,integers.get(i) * 2);
                integers.remove(i);
                integers.add(0);
                //group(integers);//递归从头找一遍
            }
        }
        return integers;
    }


    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;

        int _input_size = 0;
        _input_size = Integer.parseInt(in.nextLine().trim());
        String[] _input = new String[_input_size];
        String _input_item;
        for (int _input_i = 0; _input_i < _input_size; _input_i++) {
            try {
                _input_item = in.nextLine();
            } catch (Exception e) {
                _input_item = null;
            }
            _input[_input_i] = _input_item;
        }

        res = solution(_input);
    }
}
