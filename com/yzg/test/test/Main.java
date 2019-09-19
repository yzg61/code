package com.yzg.test.test;

import java.util.HashMap;

/**
 * @author yzg
 * @create 2019/8/2
 */

public class Main extends Parent{
    public static int t=childStaticMethod2();
    {
        System.out.println("子类非静态初始化块");
    }
    static{
        System.out.println("子类静态初始化块");
    }
    public Main(){
        System.out.println("子类的构造方法");
    }
    public static int childStaticMethod2(){
        System.out.println("子类的静态方法2"); return 1000;
    }
    public static int childStaticMethod(){
        System.out.println("子类的静态方法");

        return 1000;
    }

    public static void main(String[] args) {

        Parent child=new Main();
    }

}

