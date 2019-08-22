package com.fcy.io;

/**
 * @descripiton:
 * @author: fcy
 * @date: 2019-05-10  1:36
 */
public class Dis {
    public static void printArray(Object[][] objects){
        for(int i=0;i<objects.length;i++){
            for(int j=0;j<objects[i].length;j++){
                System.out.print(objects[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
