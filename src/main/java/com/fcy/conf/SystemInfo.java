package com.fcy.conf;
//java.version    Java 运行时环境版本
//java.vendor     Java 运行时环境供应商
//java.vendor.url     Java 供应商的 URL
//java.home   Java 安装目录
//java.vm.specification.version   Java 虚拟机规范版本
//java.vm.specification.vendor    Java 虚拟机规范供应商
//java.vm.specification.name  Java 虚拟机规范名称
//java.vm.version     Java 虚拟机实现版本
//java.vm.vendor  Java 虚拟机实现供应商
//java.vm.name    Java 虚拟机实现名称
//java.specification.version  Java 运行时环境规范版本
//java.specification.vendor   Java 运行时环境规范供应商
//java.specification.name     Java 运行时环境规范名称
//java.class.version  Java 类格式版本号
//java.class.path     Java 类路径
//java.library.path   加载库时搜索的路径列表
//java.io.tmpdir  默认的临时文件路径
//java.compiler   要使用的 JIT 编译器的名称
//java.ext.dirs   一个或多个扩展目录的路径
//os.name     操作系统的名称
//os.arch     操作系统的架构
//os.version  操作系统的版本
//file.separator  文件分隔符（在 UNIX 系统中是“/”）
//path.separator  路径分隔符（在 UNIX 系统中是“:”）
//line.separator  行分隔符（在 UNIX 系统中是“/n”）
//user.name   用户的账户名称
//user.home   用户的主目录
//user.dir    用户的当前工作目录
public class SystemInfo {
    enum EPlatform {
        Any("any"),
        Linux("Linux"),
        Mac_OS("Mac OS"),
        Mac_OS_X("Mac OS X"),
        Windows("Windows"),
        OS2("OS/2"),
        Solaris("Solaris"),
        SunOS("SunOS"),
        MPEiX("MPE/iX"),
        HP_UX("HP-UX"),
        AIX("AIX"),
        OS390("OS/390"),
        FreeBSD("FreeBSD"),
        Irix("Irix"),
        Digital_Unix("Digital Unix"),
        NetWare_411("NetWare"),
        OSF1("OSF1"),
        OpenVMS("OpenVMS"),
        Others("Others");
        private EPlatform(String desc){
            this.description = desc;
        }
        public String toString(){
            return description;
        }
        private String description;
    }
    public static void main(String args[]) throws Exception {
        System.out.println(SystemInfo.isLinux());
        System.out.println(SystemInfo.getOSname().description);
    }
    private static String OS = System.getProperty("os.name").toLowerCase();

    private static SystemInfo _instance = new SystemInfo();

    private EPlatform platform;

    private SystemInfo(){}

    public static boolean isLinux(){
        return OS.indexOf("linux")>=0;
    }

    public static boolean isMacOS(){
        return OS.indexOf("mac")>=0&&OS.indexOf("os")>0&&OS.indexOf("x")<0;
    }

    public static boolean isMacOSX(){
        return OS.indexOf("mac")>=0&&OS.indexOf("os")>0&&OS.indexOf("x")>0;
    }

    public static boolean isWindows(){
        return OS.indexOf("windows")>=0;
    }

    public static boolean isOS2(){
        return OS.indexOf("os/2")>=0;
    }

    public static boolean isSolaris(){
        return OS.indexOf("solaris")>=0;
    }

    public static boolean isSunOS(){
        return OS.indexOf("sunos")>=0;
    }

    public static boolean isMPEiX(){
        return OS.indexOf("mpe/ix")>=0;
    }

    public static boolean isHPUX(){
        return OS.indexOf("hp-ux")>=0;
    }

    public static boolean isAix(){
        return OS.indexOf("aix")>=0;
    }

    public static boolean isOS390(){
        return OS.indexOf("os/390")>=0;
    }

    public static boolean isFreeBSD(){
        return OS.indexOf("freebsd")>=0;
    }

    public static boolean isIrix(){
        return OS.indexOf("irix")>=0;
    }

    public static boolean isDigitalUnix(){
        return OS.indexOf("digital")>=0&&OS.indexOf("unix")>0;
    }

    public static boolean isNetWare(){
        return OS.indexOf("netware")>=0;
    }

    public static boolean isOSF1(){
        return OS.indexOf("osf1")>=0;
    }

    public static boolean isOpenVMS(){
        return OS.indexOf("openvms")>=0;
    }
    /**
     * 获取操作系统名字
     * @return 操作系统名
     */
    public static EPlatform getOSname(){
        if(isAix()){
            _instance.platform = EPlatform.AIX;
        }else if (isDigitalUnix()) {
            _instance.platform = EPlatform.Digital_Unix;
        }else if (isFreeBSD()) {
            _instance.platform = EPlatform.FreeBSD;
        }else if (isHPUX()) {
            _instance.platform = EPlatform.HP_UX;
        }else if (isIrix()) {
            _instance.platform = EPlatform.Irix;
        }else if (isLinux()) {
            _instance.platform = EPlatform.Linux;
        }else if (isMacOS()) {
            _instance.platform = EPlatform.Mac_OS;
        }else if (isMacOSX()) {
            _instance.platform = EPlatform.Mac_OS_X;
        }else if (isMPEiX()) {
            _instance.platform = EPlatform.MPEiX;
        }else if (isNetWare()) {
            _instance.platform = EPlatform.NetWare_411;
        }else if (isOpenVMS()) {
            _instance.platform = EPlatform.OpenVMS;
        }else if (isOS2()) {
            _instance.platform = EPlatform.OS2;
        }else if (isOS390()) {
            _instance.platform = EPlatform.OS390;
        }else if (isOSF1()) {
            _instance.platform = EPlatform.OSF1;
        }else if (isSolaris()) {
            _instance.platform = EPlatform.Solaris;
        }else if (isSunOS()) {
            _instance.platform = EPlatform.SunOS;
        }else if (isWindows()) {
            _instance.platform = EPlatform.Windows;
        }else{
            _instance.platform = EPlatform.Others;
        }
        return _instance.platform;
    }
}
