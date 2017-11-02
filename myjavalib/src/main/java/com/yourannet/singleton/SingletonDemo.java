package com.yourannet.singleton;

/**
 * Created by Administrator on 2017/11/2.
 */

public class SingletonDemo {

    public static void main(String[] args){
        Singleton singleton = Singleton.getInstance();
        singleton.printMsg();

    }
}
