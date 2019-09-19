package com.yzg.javabasc.thread;

import java.util.concurrent.Callable;

/**
 * @author yzg
 * @create 2019/8/23
 */
public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        String value = "test";
        System.out.println("Ready");
        Thread.sleep(5000);
        System.out.println("test done");
        return value;
    }
}
