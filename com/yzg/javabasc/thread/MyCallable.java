package com.yzg.javabasc.thread;

import lombok.SneakyThrows;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.LockSupport;

/**
 * @author yzg
 * @create 2019/8/23
 */
public class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {

        //new
        Thread thread = new Thread(){
            @Override
            public void run() {
                while (true) {
                    System.out.println("running" +this.getName());
                }
            }
        };
        //runnable: running / blocked
        thread.start();
        //running -> runnable
        Thread.yield();
        //waiting
        LockSupport.park();
        thread.wait();
        thread.join();
        //timed waiting
        LockSupport.parkNanos(10000);
        LockSupport.parkUntil(1000);
        Thread.sleep(1000);
        thread.wait(1000);
        thread.join(1000);
        //waiting -> runnable
        LockSupport.unpark(thread);
        thread.notify();
        thread.notifyAll();


        String value = "test";
        System.out.println("Ready");
        Thread.sleep(5000);
        System.out.println("test done");
        return value;
    }
}
