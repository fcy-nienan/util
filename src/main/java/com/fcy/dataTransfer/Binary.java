package com.fcy.dataTransfer;

import java.util.logging.Logger;

public class Binary {
    private static Logger logger = Logger.getLogger(Binary.class.getName());

    public static void main(String args[]) throws Exception {

    }
    private static String toBinary(char c){
        return Integer.toBinaryString(c);
    }
}
