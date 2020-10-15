package com.yzg.shejimoshi;

import com.yzg.test.Main;
import java.lang.reflect.Proxy;

/**
 * @author yzg
 * @create 2019/7/12
 * 单列模式
 */
public class Singleton {

/*
    private static Singleton singleton = null;
*/

    //私有构造方法防止实例化
    private Singleton(){
    }

    public static Singleton getInstance(){
        return SingletonHolder.instance;
    }

    private static class SingletonHolder{
        private static final Singleton instance = new Singleton();
    }


    /*private static synchronized void init(){
        if (singleton == null){
            singleton = new Singleton();
        }
    }

    public static Singleton getSingleton(){
        if (singleton == null){
            init();
        }
        return singleton;
    }*/
}
