package com.yourannet.singleton;

/**
 * Created by Administrator on 2017/11/2.
 */
public class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton(){}

    public static Singleton getInstance(){
        return instance;
    }

    public void printMsg(){
        System.out.print("hello singleton !");
    }
}
