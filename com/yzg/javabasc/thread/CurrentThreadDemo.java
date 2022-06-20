package com.yzg.javabasc.thread;

import org.apache.poi.ss.formula.functions.T;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author yzg
 * @create 2019/8/19
 */
public class CurrentThreadDemo {
    public static int a = 0;
    public static int b = 0;
    public synchronized static void staticA(){
        a++;
    }
    public synchronized static void staticB(){
        a++;
    }
    public synchronized void methodC() {
        b++;
    }
    public static void main(String[] args) {

        CurrentThreadDemo demo = new CurrentThreadDemo();
        CurrentThreadDemo demo2 = new CurrentThreadDemo();

        new Thread(()->{
            int i =0;
            while (i < 5000000) {
                staticA();
                demo.methodC();
                i++;
            }
        }).start();

        new Thread(()->{
            int i =0;
            while (i < 5000000) {
                staticB();
                demo2.methodC();
                i++;
            }

            System.out.println(Thread.currentThread().getName() +",  a = " + a);
            System.out.println(Thread.currentThread().getName() +",  b = " + b);
        }).start();

    }
}
