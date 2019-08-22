package com.fcy.io;

import java.io.*;

/**
 * @descripiton:
 * @author: fcy
 * @date: 2019-05-10  0:53
 */
public class IOUtil {
    public static byte[] getByteFromStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        transfer(inputStream,outputStream);
        return outputStream.toByteArray();
    }
    public static void transfer(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bytes=new byte[2048];
        int len=0;
        while ((len=inputStream.read(bytes))!=-1){
            outputStream.write(bytes,0,len);
        }
    }
    public static void closeStream(Closeable... closeable){
        for (Closeable c: closeable) {
            close(c);
        }
    }
    private static void close(Closeable closeable){
        if (closeable!=null){
            try {
                closeable.close();
            } catch (IOException e) {
                System.out.println("Unable to close the resources:"+e.getMessage());
            }
        }
    }
    public static void genFile(String outputPath,String fileName,byte[] bytes){

    }


}
