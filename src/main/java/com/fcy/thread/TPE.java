package com.fcy.thread;

import com.fcy.io.Dis;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class TPE {
    private static Logger logger = Logger.getLogger(TPE.class.getName());
    public static void main(String args[]) throws Exception {
        String hex=Integer.toBinaryString(-1);
        String[] ar=splitLength(hex,-1);
        Dis.oneArray(ar);
    }

    public static ThreadPoolExecutor tpe(int core,int blockSize,int max){
        ThreadPoolExecutor executor=new ThreadPoolExecutor(core,max,0, TimeUnit.MICROSECONDS,new ArrayBlockingQueue<Runnable>(blockSize));
        return executor;
    }
    public static ThreadPoolExecutor tpe(int core){
        ThreadPoolExecutor executor=new ThreadPoolExecutor(core,core,0,TimeUnit.MICROSECONDS,new LinkedBlockingQueue<Runnable>());
        return executor;
    }
    public static ThreadPoolExecutor tpe(int core,int blockSize,int max,long second){
        ThreadPoolExecutor executor=new ThreadPoolExecutor(core,max,second,TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(blockSize));
        return executor;
    }
    public static int getLen(int count,int len){
        if (count<=0||len<=0){
            throw new IllegalArgumentException("can not be zero!");
        }
        return count%len==0?count/len:count/len+1;
    }
    public static String[] splitLength(String s,int len){
        if (s==null){
            throw new NullPointerException("param can not be null!");
        }
        if (len>=s.length()||len<=0){
            return new String[]{s};
        }
        char[] chars = s.toCharArray();
        int index=0;
        String[] result=new String[getLen(s.length(),len)];
        for(int start=0;start<s.length();start+=len){
            if (start+len>s.length()){
                len=s.length()-start;
            }
            String t=new String(chars,start,len);
            result[index++]=t;
        }
        return result;
    }

}
