package com.fcy.thread;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

public class OuterShut {
    private static Logger logger = Logger.getLogger(OuterShut.class.getName());

    public static void main(String args[]) throws Exception {
        ReentrantLock lock=new ReentrantLock();
        ThreadPoolExecutor executor=TPE.tpe(10,10,20);
        executor.submit(()->{
            System.out.println("start apply for lock");
            lock.lock();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unlock();
        });
        Thread.sleep(3000);
        lock.lock();
        Thread.sleep(3000);
        lock.unlock();
        executor.shutdown();
    }
}
