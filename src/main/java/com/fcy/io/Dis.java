package com.fcy.io;

import java.io.BufferedReader;

/**
 * @descripiton:
 * @author: fcy
 * @date: 2019-05-10  1:36
 */
public class Dis {
    public static void twoArray(Object[][] objects){
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<objects.length;i++){
            for(int j=0;j<objects[i].length;j++){
                builder.append(objects[i][j]).append("\t");
            }
            builder.append('\n');
        }
        System.out.println(builder.toString());
    }
    public static void oneArray(Object[] objects){
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<objects.length;i++){
            builder.append(objects[i].toString());
            builder.append("\t");
        }
        System.out.println(builder.toString());
    }
}
