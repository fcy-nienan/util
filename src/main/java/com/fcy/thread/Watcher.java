package com.fcy.thread;
import java.util.logging.Logger;
public class Watcher implements Runnable{
    private static Logger logger = Logger.getLogger(Watcher.class.getName());
    private volatile boolean stop=false;

    public static void main(String args[]) throws Exception {

    }

    public void run() {
        while (!stop){
            System.out.println("info");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread is stopped!");
    }
    public void shutdown(){
        stop=true;
    }
}
