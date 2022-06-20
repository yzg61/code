package com.yzg.javabasc.thread;


public class WaitNotify {

    public static Object object = new Object();
    public static void main(String[] args) {

        new Thread(()->{
            synchronized (object) {
                System.out.println(Thread.currentThread().getName() + "获取到锁");
                try {
                    System.out.println(Thread.currentThread().getName() + "wait()");
                    object.wait();
                    System.out.println(Thread.currentThread().getName() + "恢复执行");
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + "wait方法发生InterruptedException异常");
                }
                System.out.println(Thread.currentThread().getName() + "结束");

            }
        }).start();

        new Thread(()->{
            synchronized (object) {
                System.out.println(Thread.currentThread().getName() + "获取到锁");
                System.out.println(Thread.currentThread().getName() + "notify()");

                object.notify();
                System.out.println(Thread.currentThread().getName() + "notify()执行完毕");
                try {
                    System.out.println(Thread.currentThread().getName() + "sleep(3000)");
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName() + "sleep(3000)执行完毕");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "结束");

            }
        }).start();
    }
}
