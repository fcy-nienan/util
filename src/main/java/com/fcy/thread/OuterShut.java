package com.fcy.thread;

import java.util.logging.Logger;

public class OuterShut {
    private static Logger logger = Logger.getLogger(OuterShut.class.getName());

    public static void main(String args[]) throws Exception {
        Watcher watcher=new Watcher();
        Thread t=new Thread(watcher);
        t.start();
//        Thread.sleep(10000);
//        watcher.shutdown();
        System.out.println(t.isInterrupted());
        t.interrupt();//设置值
        System.out.println(t.isInterrupted());
        t.isInterrupted();//返回值
        System.out.println("1::"+Thread.interrupted());//返回值并且设置值
        System.out.println(t.isInterrupted());
    }
}
