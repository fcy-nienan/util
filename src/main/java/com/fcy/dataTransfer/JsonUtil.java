package com.fcy.dataTransfer;

import com.fcy.collection.ListUtil;
import com.fcy.io.Dis;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @descripiton:
 *         Field[] fields=clazz.getFields(); 获取该对象的public字段(包括父类)
 *         Field[] declare=clazz.getDeclaredFields(); 获取该对象所属类的所有字段(不包含父类)
 *
 * @author: fcy
 * @date: 2019-05-10  1:06
 */
public class JsonUtil {
    public static Object getObject(String jsonStr){
        return null;
    }
    public static String getJson(Object object) throws IllegalAccessException {
        List<Field> fields=new ArrayList<Field>();

        ListUtil.addArray(fields,object.getClass().getDeclaredFields());
        Object tmp=object;
        while (tmp!=null){
            ListUtil.addArray(fields,tmp.getClass().getDeclaredFields());
            tmp=tmp.getClass().getSuperclass();
        }
        for (Field field : fields) {
            field.setAccessible(true);
            String name=field.getName();
            Object o=field.get(object);

        }

        return null;
    }
    private static String[][] getMap(Object o) throws IllegalAccessException {
        Class clazz=o.getClass();
        Field[] fields=clazz.getDeclaredFields();
        int size=fields.length;
        String[][] result=new String[size][2];
        for (int i=0;i<fields.length;i++){
            Field f=fields[i];
            f.setAccessible(true);
            String name=f.getName();
            String value= (String) f.get(o);
            result[i][0]=name;
            result[i][1]=value;
        }
        return result;
    }
    public static void main(String[] args) throws Exception{
        String[][] map=getMap(new test2());
        Dis.printArray(map);
        test2 t=new test2();
        Object o=t.getClass().getSuperclass();
        while (o!=null){
            System.out.println(((Class) o).getName());
            o=((Class) o).getSuperclass();
        }
    }
    static class test{
        private String username;
        protected String password;
        String age;
        public String nickname;
    }
    static class test1 extends test{
        private String a;
        String b;
        protected String c;
        public String d;
    }
    static class test2 extends test1{
        private String aa;
        String bb;
        protected String cc;
        public String dd;
    }

    public static boolean isInt(Object o){
        if (o!=null)
            return o instanceof Integer;
        return false;
    }
    public static boolean isLong(Object o){
        if (o!=null)
            return o instanceof Long;
        return false;
    }
    public static boolean isFloat(Object o){
        if (o!=null)
            return o instanceof Float;
        return false;
    }
    public static boolean isArray(Object o){
        if (o!=null)
            return o.getClass().isArray();
        return false;
    }
    public static boolean isString(Object o){
        if (o!=null)
            return o instanceof String;
        return false;
    }
    public static boolean isList(Object o){
        if (o!=null)
            return o instanceof List;
        return false;
    }
    public static boolean isMap(Object o){
        if (o!=null)
            return o instanceof Map;
        return false;
    }
    public static boolean isSet(Object o){
        if (o==null)return false;
        return o instanceof Set;
    }
}
