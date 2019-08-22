package com.fcy.dataTransfer;

import com.fcy.io.IOUtil;

import java.io.*;

/**
 * @descripiton:
 * @author: fcy
 * @date: 2019-05-10  1:06
 */
public class SerializableUtil {
    public static byte[] writeObject(Object o){
        ByteArrayOutputStream arrayOutputStream=new ByteArrayOutputStream();
        ObjectOutputStream outputStream=null;
        try{
            outputStream=new ObjectOutputStream(arrayOutputStream);
            outputStream.writeObject(o);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            IOUtil.closeStream(arrayOutputStream,outputStream);
        }
        return arrayOutputStream.toByteArray();
    }
    public static Object readObject(byte[] bytes){
        ByteArrayInputStream arrayInputStream=new ByteArrayInputStream(bytes);
        Object o=null;
        ObjectInputStream inputStream=null;
        try{
            inputStream=new ObjectInputStream(arrayInputStream);
            o=inputStream.readObject();
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            IOUtil.closeStream(arrayInputStream,inputStream);
        }
        return o;
    }
}
