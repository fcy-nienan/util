package com.fcy.thread;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Logger;

public class OuterShut {
    private static Logger logger = Logger.getLogger(OuterShut.class.getName());

    public static void main(String args[]) throws Exception {
        ThreadPoolExecutor executor=TPE.tpe(10,10,20);

    }
}
