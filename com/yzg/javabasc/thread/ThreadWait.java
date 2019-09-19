package com.yzg.javabasc.thread;

import java.time.temporal.ValueRange;

/**
 * @author yzg
 * @create 2019/8/23
 */
public class ThreadWait implements Runnable {

    private String value;

    @Override
    public void run() {
        try {
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        value = "we have data now";
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadWait tw = new ThreadWait();
        Thread t = new Thread(tw);
        t.start();
        /*while (tw.value == null){
            Thread.currentThread().sleep(100);
        }*/
        t.join();
        System.out.println("tw.value = " + tw.value);
    }
}
