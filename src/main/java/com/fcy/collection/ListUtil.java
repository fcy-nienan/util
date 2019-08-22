package com.fcy.collection;

import java.util.List;

/**
 * @descripiton:
 * @author: fcy
 * @date: 2019-05-10  1:27
 */
public class ListUtil {
    public static void addArray(List list, Object[] array){
        for (Object o : array) {
            list.add(o);
        }
    }
}
