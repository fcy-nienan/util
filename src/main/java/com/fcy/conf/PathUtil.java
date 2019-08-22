package com.fcy.conf;

import java.util.logging.Logger;

public class PathUtil {
    private static Logger logger=Logger.getLogger(PathUtil.class.getName());
    public static void main(String args[]) throws Exception {

    }
    public static String normalizeFileSystemPath(String path) {
        if (path==null){
            logger.warning("path can not be null!");
            return "";
        }
        if (path.length()==0){
            logger.warning("path length must be > 0");
            return "";
        }
        if (SystemInfo.isWindows()){
            return path.replaceAll("\\\\","/");
        }
        return path;
    }
}
