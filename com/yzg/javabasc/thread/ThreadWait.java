package com.yzg.javabasc.thread;

import java.time.temporal.ValueRange;
import java.util.Arrays;

/**
 * @author yzg
 * @create 2019/8/23
 */
public class ThreadWait implements Runnable {

    private String value;

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        value = "we have data now";
    }

    public static void main(String[] args) throws InterruptedException {
        String s = "192,156,123";
        String[] splits = s.split("//.");
        System.out.println(Arrays.toString(splits));
    }
}
