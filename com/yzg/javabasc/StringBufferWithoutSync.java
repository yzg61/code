package com.yzg.javabasc;

/**
 * @author yzg
 * @create 2019/9/14
 */
public class StringBufferWithoutSync {
    //StringBuffer是线程安全的，append方法由synchronized修饰，但sb对象只会在append方法中使用
    //不可能被其他线程引用，因此sb对象属于不可能共享的资源，JVM会自动进行锁消除
    public void add(String str1,String str2){
        StringBuffer sb = new StringBuffer();
        sb.append(str1).append(str2);
    }

    public static void main(String[] args) {
        StringBufferWithoutSync withoutSync = new StringBufferWithoutSync();
        for (int i =0; i < 1000; i++){
            withoutSync.add("Semester","bbb");
        }
    }
}
