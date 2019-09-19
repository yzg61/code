package com.yzg.javabasc.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author yzg
 * @create 2019/8/23
 */
public class FutureTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<>(new MyCallable());
        Thread t = new Thread(task);
        t.start();
        if (!task.isDone()){
            System.out.println("task has not finished");
        }
        System.out.println("task return: " +task.get());
    }
}
